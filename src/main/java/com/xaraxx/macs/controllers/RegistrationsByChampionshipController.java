package com.xaraxx.macs.controllers;
import com.xaraxx.macs.exceptions.EntityNotFoundException;
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

@RestController
public class RegistrationsByChampionshipController {
    @Autowired
    private final RegistrationsByChampionshipRepository repository;

    RegistrationsByChampionshipController(RegistrationsByChampionshipRepository repository){
        this.repository = repository;
    }

    @GetMapping("/registrations-champ")
    public @ResponseBody Iterable<RegistrationsByChampionship> getAllRegistrationsByChampionship(){
        return repository.findAll();
    }

    @PostMapping("/registrations-champ")
    public RegistrationsByChampionship createRegistrationsByChampionship(@RequestBody RegistrationsByChampionship newRegistrations){
        return repository.save(newRegistrations);
    }

    @GetMapping("/registrations-champ/{id}")
    public RegistrationsByChampionship getRegistrationByChampionshipById(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
    }

    @PutMapping("/registrations-champ/{id}")
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
}
