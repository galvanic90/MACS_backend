package com.xaraxx.macs.controllers;

import com.xaraxx.macs.exceptions.EntityNotFoundException;
import com.xaraxx.macs.models.BeltGrade;
import com.xaraxx.macs.repositories.BeltGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeltGradeController {
    @Autowired
    private final BeltGradeRepository repository;

    BeltGradeController(BeltGradeRepository repository){ this.repository = repository; }

    @GetMapping("/belt-grade")
    public @ResponseBody Iterable<BeltGrade> getAllBeltGrades() {
        // This returns a JSON or XML with the users
        return repository.findAll();
    }

    @PostMapping("/belt-grade")
    public BeltGrade createBeltGrade(@RequestBody BeltGrade newBeltGrade){
        return repository.save(newBeltGrade);
    }

    // Get a single item
    @GetMapping("/belt-grade/{id}")
    public BeltGrade getBeltGradeById(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
    }

    @PutMapping("/belt-grade/{id}")
    public BeltGrade updateBeltGradeById(@RequestBody BeltGrade newBeltGrade, @PathVariable Integer id){
        return repository.findById(id)
                .map(beltGrade -> {
                    beltGrade.setColor(newBeltGrade.getColor());
                    return repository.save(beltGrade);
                })
                .orElseGet(()->{
                    return repository.save(newBeltGrade);
                });
    }

    @DeleteMapping("/belt-grade/{id}")
    public void deleteBeltGradeById(@PathVariable Integer id) {
        repository.deleteById(id);
    }

}
