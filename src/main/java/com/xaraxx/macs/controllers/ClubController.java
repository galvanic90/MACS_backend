package com.xaraxx.macs.controllers;

import com.xaraxx.macs.DTOs.ClubDTO;
import com.xaraxx.macs.exceptions.EntityNotFoundException;
import com.xaraxx.macs.mappers.ClubMapper;
import com.xaraxx.macs.models.Club;
import com.xaraxx.macs.repositories.ClubRepository;
import jakarta.validation.Valid;
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
public class ClubController {
    @Autowired
    private final ClubRepository repository;
    ClubMapper clubMapper;

    ClubController(ClubRepository repository, ClubMapper clubMapper){
        this.repository = repository;
        this.clubMapper = clubMapper;
    }

    @GetMapping("/club")
    public @ResponseBody Iterable<Club> getAllClub(){
        return repository.findAll();
    }

    @PostMapping("/club")
    public Club createClub(@Valid @RequestBody ClubDTO newClub){
        Club club = clubMapper.convertToClub(newClub);
        return repository.save(club);
    }

    @GetMapping("/club/{id}")
    public Club getClubById(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
    }
    @PutMapping("/club/{id}")
    public Club updateClubById(@RequestBody ClubDTO newClub, @PathVariable Integer id){
        Club club = clubMapper.convertToClub(newClub);
        club.setId(id);
        return repository.save(club);
    }

    @DeleteMapping("/club/{id}")
    public void deleteClubById(@PathVariable Integer id){
        repository.deleteById(id);
    }
}
