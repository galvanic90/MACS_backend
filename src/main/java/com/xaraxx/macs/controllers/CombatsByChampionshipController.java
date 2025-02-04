package com.xaraxx.macs.controllers;
import com.xaraxx.macs.DTOs.UpdateCombatDTO;
import com.xaraxx.macs.DTOs.combat.*;
import com.xaraxx.macs.exceptions.EntityNotFoundException;
import com.xaraxx.macs.models.CategoriesByChampionship;
import com.xaraxx.macs.models.CombatsByChampionship;
import com.xaraxx.macs.models.RegistrationsByChampionship;
import com.xaraxx.macs.repositories.CombatsByChampionshipRepository;
import com.xaraxx.macs.repositories.RegistrationsByChampionshipRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@RestController
public class CombatsByChampionshipController {
    @Autowired
    private final CombatsByChampionshipRepository repository;
    @Autowired
    private final RegistrationsByChampionshipRepository registrationRepository;


    CombatsByChampionshipController(CombatsByChampionshipRepository repository, RegistrationsByChampionshipRepository registrationRepository){
        this.repository = repository;
        this.registrationRepository = registrationRepository;
    }

    @GetMapping("/combat")
    public @ResponseBody Iterable<CombatsByChampionship> getAllCombatsByChampionship(){
        return repository.findAll();
    }

    @PostMapping("/combat")
    public void createCombatsByCategory(@RequestBody CombatByCategoryDTO newCombats) {
        CategoriesByChampionship category = new CategoriesByChampionship();
        category.setId(newCombats.getCategory());
        List<RegistrationsByChampionship> participants = registrationRepository.findByCategoriesByChampionship_id(newCombats.getCategory());
        int numParticipants = participants.size();
        int nextPowerOf2 = 1;
        int rounds = 0;
        while (nextPowerOf2 < numParticipants) {
            nextPowerOf2 *= 2;
            rounds++;
        }
        int byes = nextPowerOf2 - numParticipants;

        System.out.println("Participantes: " + numParticipants);
        System.out.println("Byes: " + byes);
        System.out.println("Rounds: " + rounds);
        List<Integer> byePosition = new ArrayList<>(byes);
        if(byes> 0) {
            int interval = numParticipants/byes;
            for(int i = 0; i< byes; i++) {
                byePosition.add(i*interval);
            }
            System.out.println(byePosition);
        }
        List<Integer> combatPositions = getRemainingNumbers(numParticipants-1, new HashSet<>(byePosition));
        for (Integer position : byePosition) {
            CombatsByChampionship combatsByChampionship = new CombatsByChampionship();
            combatsByChampionship.setWinner(participants.get(position));
            combatsByChampionship.setFeedIn(true);
            combatsByChampionship.setCategoriesByChampionship(category);
            combatsByChampionship.setRound(1);
            repository.save(combatsByChampionship);

        }
        for (int i = 0; i < combatPositions.size() ; i += 2) {
            CombatsByChampionship combatsByChampionship = new CombatsByChampionship();
            combatsByChampionship.setCategoriesByChampionship(category);
            combatsByChampionship.setRound(1);
            combatsByChampionship.setAthleteBlue(participants.get(combatPositions.get(i)));
            combatsByChampionship.setAthleteRed(participants.get(combatPositions.get(i+1)));
            combatsByChampionship.setFeedIn(false);
            repository.save(combatsByChampionship);
        }
        int combatsInRound = nextPowerOf2/2;
        for(int round = 2; round <= rounds; round++){
            combatsInRound = combatsInRound/2;
            for(int i = 0; i < combatsInRound; i++) {
                System.out.println("Round: "+ round);
                CombatsByChampionship combatsByChampionship = new CombatsByChampionship();
                combatsByChampionship.setCategoriesByChampionship(category);
                combatsByChampionship.setRound(round);
                repository.save(combatsByChampionship);
            }
        }
    }

    public static List<Integer> getRemainingNumbers(int n, Set<Integer> skipSet) {
        List<Integer> remainingNumbers = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (!skipSet.contains(i)) {
                remainingNumbers.add(i);
            }
        }
        return remainingNumbers;
    }

    // TO DO, CREATE METHOD THAT IMPLEMENT SAVE A BATCH OF COMBATS

    @GetMapping("/combat/{id}")
    public CombatsByChampionship getCombatsByChampionshipById(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(id));
    }

    @PutMapping("/combat/{id}")
    public CombatsByChampionship updateCombatsByChampionship(@RequestBody UpdateCombatDTO newCombats, @PathVariable Integer id){
        return repository.findById(id)
                .map((combats)->{
                    combats.setPointsBlue(newCombats.getPointsBlue());
                    combats.setPointsRed(newCombats.getPointsRed());
                    if(newCombats.getAthleteBlue()!= null) {
                        registrationRepository.findById(newCombats.getAthleteBlue()).ifPresent(combats::setAthleteBlue);
                    }
                    if(newCombats.getAthleteRed()!=null) {
                        registrationRepository.findById(newCombats.getAthleteRed()).ifPresent(combats::setAthleteRed);
                    }
                    if(newCombats.getWinner()!=null) {
                        registrationRepository.findById(newCombats.getWinner()).ifPresent(combats::setWinner);
                    }
                    return repository.save(combats);
                })
                .orElseThrow(()-> new EntityNotFoundException("Combat %s not found".formatted(id)));
    }

    @GetMapping("/pyramid/{categoryId}")
    public @ResponseBody Iterable<RoundDTO> pyramid(@PathVariable Integer categoryId){
        Integer numberOfRounds = repository.numberOfRounds(categoryId).orElseThrow(()-> new EntityNotFoundException("Provided category of championship does not have combats"));
        List<RoundDTO> rounds = new ArrayList<>();
        for(int i = 1; i <= numberOfRounds; i++) {
            RoundDTO round = new RoundDTO();
            List<CombatsByChampionship> combatsByChampionships = repository.findByCategoriesByChampionship_idAndRoundOrderByIdAsc(categoryId, i);
            List<MatchDTO> matches = combatsByChampionships.stream().map(combatByChampionship -> {
                MatchDTO matchDTO = new MatchDTO();
                matchDTO.setId(combatByChampionship.getId().toString());
                if(combatByChampionship.isFeedIn()) {
                    FeedInDTO feedInDTO = new FeedInDTO();
                    feedInDTO.setName(combatByChampionship.getWinner().getAthlete().getName());
                    feedInDTO.setId(combatByChampionship.getWinner().getId().toString());
                    matchDTO.setTitle("By");
                    matchDTO.setFeedIn(feedInDTO);
                } else {
                    matchDTO.setTitle("# " + combatByChampionship.getCombatNumber());
                    TeamDTO team1 = convertToTeamDTO(combatByChampionship.getAthleteBlue());
                    TeamDTO team2 = convertToTeamDTO(combatByChampionship.getAthleteRed());
                    team1.setScore(combatByChampionship.getPointsBlue());
                    team2.setScore(combatByChampionship.getPointsRed());
                    matchDTO.setTeam1(team1);
                    matchDTO.setTeam2(team2);
                }
                return matchDTO;
            }).toList();
            round.setMatchs(matches);
            rounds.add(round);
        }
        return rounds;
    }

    public TeamDTO convertToTeamDTO(RegistrationsByChampionship registration) {
        TeamDTO team = new TeamDTO();
        if(registration!= null) {
            team.setId(registration.getId().toString());
            team.setName(registration.getAthlete().getName());
        } else{
            team.setId("");
            team.setName("_");
        }
        return team;
    }
}
