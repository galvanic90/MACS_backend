package com.xaraxx.macs.controllers;

import com.xaraxx.macs.exceptions.LocationNotFoundException;
import com.xaraxx.macs.models.Location;
import com.xaraxx.macs.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LocationController {
    @Autowired
    private final LocationRepository repository;

    LocationController(LocationRepository repository){
        this.repository = repository;
    }

    @GetMapping("/location")
    public @ResponseBody Iterable<Location> getAllLocation(){
        return repository.findAll();
    }

    @PostMapping("/location")
    public Location createLocation(@RequestBody Location newLocation){
       return  repository.save(newLocation);
    }

    @GetMapping("/location/{id}")
    public Location getLocationById(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException(id));

    }
}
