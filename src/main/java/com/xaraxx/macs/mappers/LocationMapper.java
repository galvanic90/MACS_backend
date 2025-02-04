package com.xaraxx.macs.mappers;

import com.xaraxx.macs.DTOs.LocationDTO;
import com.xaraxx.macs.exceptions.EntityNotFoundException;
import com.xaraxx.macs.models.Location;
import com.xaraxx.macs.repositories.MunicipalityRepository;
import com.xaraxx.macs.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {
    @Autowired
    private final MunicipalityRepository municipalityRepository;
    @Autowired
    private final LocationRepository locationRepository;

    LocationMapper(MunicipalityRepository municipalityRepository, LocationRepository locationRepository) {
        this.municipalityRepository = municipalityRepository;
        this.locationRepository = locationRepository;
    }

    public LocationDTO convertToLocationDTO(Location location) {
        LocationDTO dto = new LocationDTO();
        dto.setAddress(location.getAddress());
        dto.setName(location.getName());
        dto.setPhoneNumber(location.getPhoneNumber());
        dto.setMunicipalityId(location.getMunicipality().getId());
        return dto;
    }

    public Location convertToLocation(LocationDTO locationDTO) {
        Location location = new Location();
        location.setAddress(locationDTO.getAddress());
        location.setName(locationDTO.getName());
        location.setPhoneNumber(locationDTO.getPhoneNumber());
        location.setMunicipality(municipalityRepository.findById(locationDTO.getMunicipalityId()).orElseThrow(()-> new EntityNotFoundException(locationDTO.getMunicipalityId())));
        return location;
    }
}
