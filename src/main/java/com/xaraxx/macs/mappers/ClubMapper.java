package com.xaraxx.macs.mappers;

import com.xaraxx.macs.DTOs.ClubDTO;

import com.xaraxx.macs.exceptions.EntityNotFoundException;
import com.xaraxx.macs.models.Athlete;
import com.xaraxx.macs.models.Club;
import com.xaraxx.macs.repositories.AthleteRepository;
import com.xaraxx.macs.repositories.CountryRepository;
import com.xaraxx.macs.repositories.MunicipalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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


    public ClubDTO converToClubDTO(Club club){
        ClubDTO dto = new ClubDTO();
        dto.setName(club.getName());
        dto.setEmail(club.getEmail());
        dto.setMunicipalityId(club.getMunicipality().getId());
        dto.setCountryId(club.getCountry().getId());
        return dto;
    }

    public Club convertToClub(ClubDTO clubDTO){
        Club club = new Club();
        club.setName(clubDTO.getName());
        club.setEmail(clubDTO.getEmail());
        club.setMunicipality(municipalityRepository.findById(clubDTO.getMunicipalityId()).orElseThrow(()-> new EntityNotFoundException(clubDTO.getMunicipalityId())));
        club.setCountry(countryRepository.findById(clubDTO.getCountryId()).orElseThrow(() -> new EntityNotFoundException(clubDTO.getCountryId())));

        return club;
    }
}
