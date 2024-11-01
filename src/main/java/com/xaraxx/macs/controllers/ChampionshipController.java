package com.xaraxx.macs.controllers;

import com.xaraxx.macs.exceptions.EntityNotFoundException;
import com.xaraxx.macs.models.Championship;
import com.xaraxx.macs.repositories.ChampionshipRepository;
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

    ChampionshipController(ChampionshipRepository repository){
        this.repository = repository;
    }

    @GetMapping("/championship")
    public @ResponseBody Iterable<Championship> getAllChampioship(){
        return repository.findAll();
    }

    @PostMapping("/championship")
    public Championship createChampionship(@RequestBody Championship newChampionship){
        return repository.save(newChampionship);
    }

    @GetMapping("/championship/{id}")
    public Championship getChampionshipById(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
    }

    @PutMapping("/championship/{id}")
    public Championship updateChampionshipById(@PathVariable Integer id, @RequestBody Championship newChampionship){
        return repository.findById(id)
                .map((championship)->{championship.setName(newChampionship.getName());
                    championship.setClub(newChampionship.getClub());
                    championship.setLocation(newChampionship.getLocation());
                    championship.setStartEventDate(newChampionship.getStartEventDate());
                    championship.setEndEventDate(newChampionship.getEndEventDate());
                    return repository.save(championship);
                 })
                .orElseGet(() -> {
                    return repository.save(newChampionship);
                });
    }

    @DeleteMapping("/championship/{id}")
    public void deleteChampionshipById(@PathVariable Integer id){
        repository.deleteById(id);
    }

}
