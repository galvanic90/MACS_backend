package com.xaraxx.macs.controllers;

import com.xaraxx.macs.exceptions.EntityNotFoundException;
import com.xaraxx.macs.models.CategoriesByChampionship;
import com.xaraxx.macs.repositories.CategoriesByChampionshipRepository;
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
public class CategoriesByChampioshipController {
    @Autowired
    private final CategoriesByChampionshipRepository repository;

    CategoriesByChampioshipController(CategoriesByChampionshipRepository repository){
        this.repository = repository;
    }

    @GetMapping("/categ-champ")
    public @ResponseBody Iterable<CategoriesByChampionship> getAllCategariesByChampionship(){
        return repository.findAll();
    }

    @PostMapping("/categ-champ")
    public CategoriesByChampionship createCategoriesByChampionship(@RequestBody CategoriesByChampionship newCategoriesByChampionship){
        return repository.save(newCategoriesByChampionship);
    }

    @GetMapping("/categ-champ/{id}")
    public CategoriesByChampionship getCategoriesByChampionshipById(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(id));
    }

    @PutMapping("/categ-champ/{id}")
    public CategoriesByChampionship updateCategoriesByChampionship(@RequestBody CategoriesByChampionship newCategoriesByChampionship, @PathVariable Integer id){
        return repository.findById(id)
                .map((categories)->{categories.setChampionship(newCategoriesByChampionship.getChampionship());
                    categories.setCategory(newCategoriesByChampionship.getCategory());
                    return repository.save(categories);
                })
                .orElseGet(()->{
                    return repository.save(newCategoriesByChampionship);
                });

    }

    @DeleteMapping("/categ-champ/{id}")
    public void deleteCategoriesByChampionshipById(@PathVariable Integer id){
        repository.deleteById(id);
    }
}
