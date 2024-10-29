package com.xaraxx.macs.controllers;

import com.xaraxx.macs.exceptions.EntityNotFoundException;

import com.xaraxx.macs.models.Location;
import com.xaraxx.macs.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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
                .orElseThrow(() -> new EntityNotFoundException(id));

    }

    @PutMapping("/location/{id}")
    public Location updateLocationById(@RequestBody Location newLocation, @PathVariable Integer id){
        return repository.findById(id)
                .map((location)->{ location.setName(newLocation.getName());
                    location.setAddress(newLocation.getAddress());
                    location.setPhoneNumber(newLocation.getPhoneNumber());
                    location.setMunicipality(newLocation.getMunicipality());
                    return repository.save(location);
                })
                .orElseGet(()->{
                    return repository.save(newLocation);
                });
    }

    @DeleteMapping("/location/{id}")
    void deleteLocationById(@PathVariable Integer id){
        repository.deleteById(id);
    }
}
