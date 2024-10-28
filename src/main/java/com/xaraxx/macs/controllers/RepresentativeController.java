package com.xaraxx.macs.controllers;

import com.xaraxx.macs.exceptions.RepresentativeNotFoundException;
import com.xaraxx.macs.models.Representative;
import com.xaraxx.macs.repositories.RepresentativeRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class RepresentativeController {
    @Autowired
    private final RepresentativeRepository repository;

    RepresentativeController(RepresentativeRepository repository){
        this.repository = repository;
    }

    @GetMapping("/representative")
    public @ResponseBody Iterable <Representative> getAllRepresentative(){
        return repository.findAll();
    }

    @PostMapping("/representative")
    public Representative createRepresentative(@RequestBody Representative newRepresentative){
        return repository.save(newRepresentative);
    }

    @GetMapping("/representative/{id}")
    public Representative getRepresentativeById(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new RepresentativeNotFoundException(id));
    }
}
