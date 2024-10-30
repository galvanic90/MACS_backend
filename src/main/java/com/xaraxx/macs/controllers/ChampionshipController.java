package com.xaraxx.macs.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.xaraxx.macs.models.Championship;
import com.xaraxx.macs.repositories.ChampionshipRepository;

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

    ChampionshipController(ChampionshipRepository repository){
        this.repository = repository;
    }

    @GetMapping("/championship")
    public @ResponseBody Iterable<Championship> getAllChampioship(){
        return repository.findAll();
    }

    

}
