package com.xaraxx.macs.DTOs;

import java.util.List;
import java.util.Objects;

public class ClubDTO {
    private String name;
    private String email;
    private Integer municipalityId;
    private Integer countryId;
    private List<Integer> athletesId;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getMunicipalityId() {
        return municipalityId;
    }

    public void setMunicipalityId(Integer municipalityId) {
        this.municipalityId = municipalityId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public List<Integer> getAthletesId() {
        return athletesId;
    }

    public void setAthletesId(List<Integer> athletesId) {
        this.athletesId = athletesId;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (!(o instanceof ClubDTO clubDTO))
            return false;
        return  Objects.equals(this.name, clubDTO.name) && Objects.equals(this.email, clubDTO.email)
                && Objects.equals(this.municipalityId, clubDTO.municipalityId) && Objects.equals(this.countryId, clubDTO.countryId) && Objects.equals(this.athletesId, clubDTO.athletesId);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.name, this.email, this.municipalityId, this.countryId, this.athletesId);
    }
    @Override
    public String toString() {
        return "ClubDTO{" +
                ", name='" + this.name + '\'' +
                ", email='" + this.email + '\'' +
                ", municipality=" + this.municipalityId + '\'' +
                ", country=" + this.countryId + '\'' +
                ", athletes=" + this.athletesId + '\'' +
                '}';
    }

}
