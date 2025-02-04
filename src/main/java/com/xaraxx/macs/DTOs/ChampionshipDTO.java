package com.xaraxx.macs.DTOs;

import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.Objects;

public class ChampionshipDTO {
    private String name;
    private Date startEventDate;
    private Date endEventDate;
    @NotNull
    private Integer clubId;
    @NotNull
    private Integer locationId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartEventDate() {
        return startEventDate;
    }

    public void setStartEventDate(Date startEventDate) {
        this.startEventDate = startEventDate;
    }

    public Date getEndEventDate() {
        return endEventDate;
    }

    public void setEndEventDate(Date endEventDate) {
        this.endEventDate = endEventDate;
    }

    public Integer getClubId() {
        return clubId;
    }

    public void setClubId(Integer clubId) {
        this.clubId = clubId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(!(o instanceof ChampionshipDTO championshipDTO))
            return false;
        return Objects.equals(this.name, championshipDTO.name) && Objects.equals(this.startEventDate, championshipDTO.startEventDate) && Objects.equals(this.endEventDate, championshipDTO.endEventDate)
                && Objects.equals(this.clubId, championshipDTO.clubId) && Objects.equals(this.locationId, championshipDTO.locationId);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.name, this.startEventDate, this.endEventDate, this.clubId, this.locationId);
    }

    @Override
    public String toString() {
        return "ChampionshipDTO{" +
                "name='" + name + '\'' +
                ", startEventDate=" + startEventDate +
                ", endEventDate=" + endEventDate +
                ", clubId=" + clubId +
                ", locationId=" + locationId +
                '}';
    }
}
