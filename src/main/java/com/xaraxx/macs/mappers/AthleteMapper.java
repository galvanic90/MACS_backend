package com.xaraxx.macs.mappers;

import com.xaraxx.macs.DTOs.AthleteDTO;
import com.xaraxx.macs.exceptions.EntityNotFoundException;
import com.xaraxx.macs.models.Athlete;
import com.xaraxx.macs.repositories.ClubRepository;
import com.xaraxx.macs.repositories.CountryRepository;
import com.xaraxx.macs.repositories.DocumentTypeRepository;
import com.xaraxx.macs.repositories.BeltGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AthleteMapper {
    @Autowired
    private final DocumentTypeRepository documentTypeRepository;
    @Autowired
    private final CountryRepository countryRepository;
    @Autowired
    private final ClubRepository clubRepository;
    @Autowired
    private final BeltGradeRepository beltGradeRepository;

    AthleteMapper(DocumentTypeRepository documentTypeRepository, CountryRepository countryRepository, ClubRepository clubRepository, BeltGradeRepository beltGradeRepository){
        this.documentTypeRepository = documentTypeRepository;
        this.countryRepository = countryRepository;
        this.clubRepository = clubRepository;
        this.beltGradeRepository = beltGradeRepository;
    }

    public AthleteDTO convertToAthleteDTO(Athlete athlete){
        AthleteDTO dto = new AthleteDTO();
        dto.setName(athlete.getName());
        dto.setLastName(athlete.getLastName());
        dto.setIdNumber(athlete.getIdNumber());
        dto.setSex(athlete.getSex());
        dto.setBirthDate(athlete.getBirthDate());
        dto.setWeight(athlete.getWeight());
        dto.setPictureUrl(athlete.getPictureUrl());
        dto.setClubId(athlete.getClub().getId());
        dto.setDocumentTypeId(athlete.getDocumentType().getId());
        dto.setBeltId(athlete.getBelt().getId());
        dto.setCountryId(athlete.getHomeland().getId());
        return dto;
    }

    public Athlete convertToAthlete(AthleteDTO athleteDTO){
        Athlete athlete = new Athlete();
        athlete.setName(athleteDTO.getName());
        athlete.setLastName(athleteDTO.getLastName());
        athlete.setIdNumber(athleteDTO.getIdNumber());
        athlete.setSex(athleteDTO.getSex());
        athlete.setBirthDate(athleteDTO.getBirthDate());
        athlete.setWeight(athleteDTO.getWeight());
        athlete.setPictureUrl(athleteDTO.getPictureUrl());
        athlete.setClub(clubRepository.findById(athleteDTO.getClubId()).orElseThrow(() -> new EntityNotFoundException(athlete.getClub().getId())));
        athlete.setDocumentType(documentTypeRepository.findById(athleteDTO.getDocumentTypeId()).orElseThrow(() -> new EntityNotFoundException(athlete.getDocumentType().getId())));
        athlete.setBelt(beltGradeRepository.findById(athleteDTO.getBeltId()).orElseThrow(() -> new EntityNotFoundException(athlete.getBelt().getId())));
        athlete.setHomeland(countryRepository.findById(athleteDTO.getCountryId()).orElseThrow(() -> new EntityNotFoundException(athlete.getHomeland().getId())));
        return athlete;
    }

}
