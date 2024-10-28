package com.xaraxx.macs.controllers;

import com.xaraxx.macs.exceptions.ClubNotFoundException;
import com.xaraxx.macs.models.Club;
import com.xaraxx.macs.repositories.ClubRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class ClubController {
    @Autowired
    private final ClubRepository repository;

    ClubController(ClubRepository repository){
        this.repository = repository;
    }

    @GetMapping("/club")
    public @ResponseBody Iterable<Club> getAllClub(){
        return repository.findAll();
    }

    @PostMapping("/club")
    public Club createClub(@RequestBody Club newClub){
        return repository.save(newClub);
    }

    @GetMapping("/club/{id}")
    public Club getClubById(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new ClubNotFoundException(id));
    }
}
