package com.xaraxx.macs.controllers;

import com.xaraxx.macs.DTOs.AthleteDTO;
import com.xaraxx.macs.exceptions.EntityNotFoundException;
import com.xaraxx.macs.mappers.AthleteMapper;
import com.xaraxx.macs.models.Athlete;
import com.xaraxx.macs.repositories.AthleteRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class AthleteController {
    @Autowired
    private final AthleteRepository repository;
    @Autowired
    private final AthleteMapper athleteMapper;

    AthleteController(AthleteRepository repository, AthleteMapper athleteMapper){
        this.repository = repository;
        this.athleteMapper = athleteMapper;
    }

    @GetMapping("/athlete")
    public @ResponseBody Iterable<Athlete> getAllAthlete(){
        return repository.findAll();
    }

    @GetMapping("/athlete/{id}")
    public Athlete getAthleteById(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(id));
    }

    @PostMapping("/athlete")
    public Athlete createAthlete(@Valid @RequestBody AthleteDTO newAthlete){
        Athlete athlete = athleteMapper.convertToAthlete(newAthlete);
        return repository.save(athlete);
    }

    @PutMapping("/athlete/{id}")
    public Athlete updateAthleteById(@RequestBody AthleteDTO newAthlete, @PathVariable Integer id){
        Athlete athlete = athleteMapper.convertToAthlete(newAthlete);
        athlete.setId(id);
        return repository.save(athlete);
    }

    @DeleteMapping("/athlete/{id}")
    public void deleteAthleteById(@PathVariable Integer id){
        repository.deleteById(id);
    }
}
