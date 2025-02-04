package com.xaraxx.macs.controllers;

import com.xaraxx.macs.exceptions.EntityNotFoundException;

import com.xaraxx.macs.mappers.LocationMapper;
import com.xaraxx.macs.models.Location;
import com.xaraxx.macs.DTOs.LocationDTO;
import com.xaraxx.macs.repositories.LocationRepository;
import jakarta.validation.Valid;
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
    LocationMapper locationMapper;

    LocationController(LocationRepository repository, LocationMapper locationMapper) {
        this.repository = repository;
        this.locationMapper = locationMapper;
    }

    @GetMapping("/location")
    public @ResponseBody Iterable<Location> getAllLocation(){
        return repository.findAll();
    }

    @PostMapping("/location")
    public Location createLocation(@Valid @RequestBody LocationDTO newLocation){
        Location location = locationMapper.convertToLocation(newLocation);
       return  repository.save(location);
    }

    @GetMapping("/location/{id}")
    public Location getLocationById(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));

    }

    @PutMapping("/location/{id}")
    public Location updateLocationById(@RequestBody LocationDTO newLocation, @PathVariable Integer id){
       Location location = locationMapper.convertToLocation(newLocation);
       location.setId(id);
       return repository.save(location);
    }

    @DeleteMapping("/location/{id}")
    void deleteLocationById(@PathVariable Integer id){
        repository.deleteById(id);
    }
}
