package com.xaraxx.macs.controllers;

import com.xaraxx.macs.exceptions.EntityNotFoundException;
import com.xaraxx.macs.models.Country;
import com.xaraxx.macs.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
    @Autowired
    private final CountryRepository repository;

    CountryController(CountryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/country")
    public @ResponseBody Iterable<Country> getAllCountries(){
        return repository.findAll();
    }

    @GetMapping("/country/{id}")
    Country getCountryById(@PathVariable Integer id){
        return repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(id));
    }

}
