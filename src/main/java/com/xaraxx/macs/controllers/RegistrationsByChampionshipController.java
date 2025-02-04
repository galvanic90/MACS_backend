package com.xaraxx.macs.controllers;
import com.xaraxx.macs.DTOs.RegistrationDTO;
import com.xaraxx.macs.exceptions.EntityNotFoundException;
import com.xaraxx.macs.models.Athlete;
import com.xaraxx.macs.models.CategoriesByChampionship;
import com.xaraxx.macs.models.RegistrationsByChampionship;
import com.xaraxx.macs.repositories.RegistrationsByChampionshipRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class RegistrationsByChampionshipController {
    @Autowired
    private final RegistrationsByChampionshipRepository repository;

    RegistrationsByChampionshipController(RegistrationsByChampionshipRepository repository){
        this.repository = repository;
    }

    @GetMapping("/registrations")
    public @ResponseBody Iterable<RegistrationsByChampionship> getAllRegistrationsByChampionship(){
        return repository.findAll();
    }

    @GetMapping("/category/{category}/registrations")
    public @ResponseBody List<RegistrationsByChampionship> getRegistrationsByCategory(@PathVariable Integer category){
        return repository.findByCategoriesByChampionship_id(category);
    }

    @PostMapping("/registrations")
    public void createRegistrationsByChampionship(@RequestBody RegistrationDTO newRegistrations){
        CategoriesByChampionship categoriesByChampionship = new CategoriesByChampionship();
        categoriesByChampionship.setId(newRegistrations.getCategory());
        for(Integer athleteId: newRegistrations.getAthletes()) {
            RegistrationsByChampionship registration = new RegistrationsByChampionship();
            registration.setCategoriesByChampionship(categoriesByChampionship);
            Athlete athlete = new Athlete();
            athlete.setId(athleteId);
            registration.setAthlete(athlete);
            repository.save(registration);
        }

    }


    @GetMapping("/registrations/{id}")
    public RegistrationsByChampionship getRegistrationByChampionshipById(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
    }

    @PutMapping("/registrations/{id}")
    public RegistrationsByChampionship updateRegistrationByChampionshipById(@RequestBody RegistrationsByChampionship newRegistrations, @PathVariable Integer id){
        return repository.findById(id)
                .map((registrations)->{registrations.setAthlete(newRegistrations.getAthlete());
                    registrations.setCategoriesByChampionship(newRegistrations.getCategoriesByChampionship());
                    return repository.save(registrations);
                })
                .orElseGet(()->{
                    return repository.save(newRegistrations);
                });
    }

    @DeleteMapping("/registrations/{id}")
    public void deleteCombatsByChampionshipById(@PathVariable Integer id){
        repository.deleteById(id);
    }

}
