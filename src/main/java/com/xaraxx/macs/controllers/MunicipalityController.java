package com.xaraxx.macs.controllers;

import com.xaraxx.macs.exceptions.EntityNotFoundException;
import com.xaraxx.macs.models.Municipality;
import com.xaraxx.macs.repositories.MunicipalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MunicipalityController {
    @Autowired
    private final MunicipalityRepository repository;

    MunicipalityController(MunicipalityRepository repository){
        this.repository = repository;
    }

    @GetMapping("/municipality")
    public @ResponseBody Iterable<Municipality> getAllMunicipality(){
        return repository.findAll();
    }

    @GetMapping("/municipality/{id}")
    public Municipality getMunicipalityById(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(id));
    }
}
