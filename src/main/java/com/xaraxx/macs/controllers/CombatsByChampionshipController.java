package com.xaraxx.macs.controllers;
import com.xaraxx.macs.DTOs.combat.FeedInDTO;
import com.xaraxx.macs.DTOs.combat.MatchDTO;
import com.xaraxx.macs.DTOs.combat.RoundDTO;
import com.xaraxx.macs.DTOs.combat.TeamDTO;
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
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

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

    @PostMapping("/combat")
    public CombatsByChampionship createCombatsByChampionship(@RequestBody CombatsByChampionship newCombats){
        return repository.save(newCombats);
    }

    // TO DO, CREATE METHOD THAT IMPLEMENT SAVE A BATCH OF COMBATS

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

    @GetMapping("/pyramid/{championshipId}")
    public @ResponseBody Iterable<RoundDTO> pyramid(@PathVariable Integer championshipId){
        Integer numberOfRounds = repository.numberOfRounds(championshipId).orElseThrow(()-> new EntityNotFoundException("Provided championship does not have combats"));
        List<RoundDTO> rounds = new ArrayList<>();
        for(int i = 1; i <= numberOfRounds; i++) {
            RoundDTO round = new RoundDTO();
            List<CombatsByChampionship> combatsByChampionships = repository.findByCategoriesByChampionship_idAndRoundOrderByIdAsc(championshipId, i);
            List<MatchDTO> matches = combatsByChampionships.stream().map(combatByChampionship -> {
                MatchDTO matchDTO = new MatchDTO();
                if(combatByChampionship.isFeedIn()) {
                    FeedInDTO feedInDTO = new FeedInDTO();
                    feedInDTO.setName("Paso directo");
                    feedInDTO.setId("5");
                    matchDTO.setFeedIn(feedInDTO);
                } else {
                    TeamDTO team1 = new TeamDTO();
                    TeamDTO team2 = new TeamDTO();
                    matchDTO.setTeam1(team1);
                    matchDTO.setTeam2(team2);
                }
                matchDTO.setTitle("# " + combatByChampionship.getCombatNumber());
                return matchDTO;
            }).toList();
            round.setMatchs(matches);
            rounds.add(round);
        }
        return rounds;
    }
}
