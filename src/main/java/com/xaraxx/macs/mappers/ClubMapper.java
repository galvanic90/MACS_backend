package com.xaraxx.macs.mappers;

import com.xaraxx.macs.DTOs.CreateClubDTO;

import com.xaraxx.macs.exceptions.EntityNotFoundException;
import com.xaraxx.macs.models.Athlete;
import com.xaraxx.macs.models.Club;
import com.xaraxx.macs.repositories.AthleteRepository;
import com.xaraxx.macs.repositories.CountryRepository;
import com.xaraxx.macs.repositories.MunicipalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClubMapper {
    @Autowired
    private final MunicipalityRepository municipalityRepository;
    @Autowired
    private final CountryRepository countryRepository;
    @Autowired
    private final AthleteRepository athleteRepository;

    ClubMapper(MunicipalityRepository municipalityRepository, CountryRepository countryRepository, AthleteRepository athleteRepository){
        this.municipalityRepository = municipalityRepository;
        this.countryRepository = countryRepository;
        this.athleteRepository = athleteRepository;
    }


    public CreateClubDTO converToClubDTO(Club club){
        CreateClubDTO dto = new CreateClubDTO();
        dto.setName(club.getName());
        dto.setEmail(club.getEmail());
        dto.setMunicipalityId(club.getMunicipality().getId());
        dto.setCountryId(club.getCountry().getId());
        dto.setAthletesId(club.getAthleteList().stream().map(Athlete::getId).collect(Collectors.toList()));
        return dto;
    }

    public Club convertToClub(CreateClubDTO createClubDTO){
        List<Athlete> athletes = new ArrayList<Athlete>();
        Club club = new Club();
        club.setName(createClubDTO.getName());
        club.setEmail(createClubDTO.getEmail());
        club.setMunicipality(municipalityRepository.findById(createClubDTO.getMunicipalityId()).orElseThrow(()-> new EntityNotFoundException(createClubDTO.getMunicipalityId())));
        club.setCountry(countryRepository.findById(createClubDTO.getCountryId()).orElseThrow(() -> new EntityNotFoundException(createClubDTO.getCountryId())));
        Iterator<Integer> id = createClubDTO.getAthletesId().iterator();
        while (id.hasNext()){
            athletes.add(athleteRepository.findById(id.next()).orElseThrow(() -> new EntityNotFoundException(id.next())));
        }
        club.setAthleteList(athletes);

        return club;
    }
}
