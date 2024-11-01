package com.xaraxx.macs.controllers;
import com.xaraxx.macs.exceptions.EntityNotFoundException;
import com.xaraxx.macs.models.CombatsByChampionship;
import com.xaraxx.macs.repositories.CombatsByChampionshipRepository;
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
public class CombatsByChampionshipController {
    @Autowired
    private final CombatsByChampionshipRepository repository;

    CombatsByChampionshipController(CombatsByChampionshipRepository repository){
        this.repository = repository;
    }

    @GetMapping("/combats")
    public @ResponseBody Iterable<CombatsByChampionship> getAllCombatsByChampionship(){
        return repository.findAll();
    }

    @PostMapping("/combats")
    public CombatsByChampionship createCombatsByChampionship(@RequestBody CombatsByChampionship newCombats){
        return repository.save(newCombats);
    }

    @GetMapping("/combats/{id}")
    public CombatsByChampionship getCombatsByChampionshipById(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(id));
    }

    @PutMapping("/combats/{id}")
    public CombatsByChampionship updateCombatsByChampionship(@RequestBody CombatsByChampionship newCombats, @PathVariable Integer id){
        return repository.findById(id)
                .map((combats)->{combats.setCombatNumber(newCombats.getCombatNumber());
                    combats.setPointsBlue(newCombats.getPointsBlue());
                    combats.setPointsRed(newCombats.getPointsRed());
                    combats.setAthleteBlue(newCombats.getAthleteBlue());
                    combats.setAthleteRed(newCombats.getAthleteRed());
                    combats.setWinner(newCombats.getWinner());
                    return repository.save(combats);
                })
                .orElseGet(() -> {
                    return repository.save(newCombats);
                });
    }

    @DeleteMapping("/combats/{id}")
    public void deleteCombatsByChampionship(@PathVariable Integer id){
        repository.deleteById(id);
    }
}
