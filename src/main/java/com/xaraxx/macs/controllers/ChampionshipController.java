package com.xaraxx.macs.controllers;

import com.xaraxx.macs.DTOs.ChampionshipDTO;
import com.xaraxx.macs.exceptions.EntityNotFoundException;
import com.xaraxx.macs.mappers.ChampionshipMapper;
import com.xaraxx.macs.models.Championship;
import com.xaraxx.macs.repositories.ChampionshipRepository;
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
public class ChampionshipController {
    @Autowired
    private final ChampionshipRepository repository;
    ChampionshipMapper championshipMapper;

    ChampionshipController(ChampionshipRepository repository, ChampionshipMapper championshipMapper){
        this.repository = repository;
        this.championshipMapper = championshipMapper;
    }

    @GetMapping("/championship")
    public @ResponseBody Iterable<Championship> getAllChampioship(){
        return repository.findAll();
    }

    @PostMapping("/championship")
    public Championship createChampionship(@Valid @RequestBody ChampionshipDTO newChampionship){
        Championship championship = championshipMapper.convertToChampionship(newChampionship);
        return repository.save(championship);
    }

    @GetMapping("/championship/{id}")
    public Championship getChampionshipById(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
    }

    @PutMapping("/championship/{id}")
    public Championship updateChampionshipById(@PathVariable Integer id, @RequestBody ChampionshipDTO newChampionship){
        Championship championship = championshipMapper.convertToChampionship(newChampionship);
        championship.setId(id);
        return repository.save(championship);
    }

    @DeleteMapping("/championship/{id}")
    public void deleteChampionshipById(@PathVariable Integer id){
        repository.deleteById(id);
    }

}
