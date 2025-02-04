package com.xaraxx.macs.mappers;

import com.xaraxx.macs.DTOs.ChampionshipDTO;
import com.xaraxx.macs.exceptions.EntityNotFoundException;
import com.xaraxx.macs.models.Championship;
import com.xaraxx.macs.repositories.ChampionshipRepository;
import com.xaraxx.macs.repositories.LocationRepository;
import com.xaraxx.macs.repositories.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChampionshipMapper {
    @Autowired
    private ChampionshipRepository championshipRepository;
    @Autowired
    private final ClubRepository clubRepository;
    @Autowired
    private final LocationRepository locationRepository;

    ChampionshipMapper(ClubRepository clubRepository, LocationRepository locationRepository) {
        this.clubRepository = clubRepository;
        this.locationRepository = locationRepository;
    }

    public ChampionshipDTO convertToChampionshipDTO(Championship championship) {
        ChampionshipDTO dto = new ChampionshipDTO();
        dto.setName(championship.getName());
        dto.setStartEventDate(championship.getStartEventDate());
        dto.setEndEventDate(championship.getEndEventDate());
        dto.setClubId(championship.getClub().getId());
        dto.setLocationId(championship.getLocation().getId());
        return dto;
    }

    public Championship convertToChampionship(ChampionshipDTO championshipDTO) {
        Championship championship = new Championship();
        championship.setName(championshipDTO.getName());
        championship.setStartEventDate(championshipDTO.getStartEventDate());
        championship.setEndEventDate(championshipDTO.getEndEventDate());
        championship.setClub(clubRepository.findById(championshipDTO.getClubId()).orElseThrow(() -> new EntityNotFoundException(championshipDTO.getClubId())));
        championship.setLocation(locationRepository.findById(championshipDTO.getLocationId()).orElseThrow(() -> new EntityNotFoundException(championshipDTO.getLocationId())));
        return championship;
    }
}
