package com.xaraxx.macs.controllers;

import com.xaraxx.macs.exceptions.EntityNotFoundException;
import com.xaraxx.macs.models.Athlete;
import com.xaraxx.macs.repositories.AthleteRepository;
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

    AthleteController(AthleteRepository repository){
        this.repository = repository;
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
    public Athlete createAthlete(@RequestBody Athlete newAthlete){
        return repository.save(newAthlete);
    }

    @PutMapping("/athlete/{id}")
    public Athlete updateAthleteById(@RequestBody Athlete newAthlete, @PathVariable Integer id){
        return repository.findById(id)
                .map((athlete)->{athlete.setName(newAthlete.getName());
                    athlete.setLastName(newAthlete.getLastName());
                    athlete.setIdNumber(newAthlete.getIdNumber());
                    athlete.setSex(newAthlete.getSex());
                    athlete.setBirthDate(newAthlete.getBirthDate());
                    athlete.setPictureUrl(newAthlete.getPictureUrl());
                    athlete.setWeight(newAthlete.getWeight());
                    athlete.setClub(newAthlete.getClub());
                    athlete.setDocumentType(newAthlete.getDocumentType());
                    athlete.setBelt(newAthlete.getBelt());
                    athlete.setHomeland(newAthlete.getHomeland());
                    return repository.save(athlete);
                })
                .orElseGet(()->{
                    return repository.save(newAthlete);
                });
    }

    @DeleteMapping("/athlete/{id}")
    public void deleteAthleteById(@PathVariable Integer id){
        repository.deleteById(id);
    }
}
