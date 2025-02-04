package com.xaraxx.macs.DTOs;

import jakarta.validation.constraints.NotNull;
import java.util.Objects;

public class LocationDTO {
    private String name;
    private String address;
    private String phoneNumber;
    @NotNull
    private Integer municipalityId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getMunicipalityId() {
        return municipalityId;
    }

    public void setMunicipalityId(Integer municipalityId) {
        this.municipalityId = municipalityId;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(!(o instanceof LocationDTO locationDTO))
            return false;
        return Objects.equals(this.name, locationDTO.name) && Objects.equals(this.address, locationDTO.address)
                && Objects.equals(this.phoneNumber, locationDTO.phoneNumber) && Objects.equals(this.municipalityId, locationDTO.municipalityId);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.name, this.address, this.phoneNumber, this.municipalityId);
    }

    @Override
    public String toString() {
        return "LocationDTO{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", municipalityId=" + municipalityId +
                '}';
    }
}
