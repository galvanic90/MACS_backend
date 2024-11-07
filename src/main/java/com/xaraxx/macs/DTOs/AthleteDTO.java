package com.xaraxx.macs.DTOs;

import com.xaraxx.macs.models.Gender;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;


public class AthleteDTO {
    @NotNull
    private String name;
    @NotNull
    private String lastName;
    @NotNull
    private String idNumber;
    private Gender sex;
    @NotNull
    private String birthDate;
    @NotNull
    private double weight;
    private String pictureUrl;
    @NotNull
    private Integer clubId;
    @NotNull
    private Integer documentTypeId;
    @NotNull
    private Integer beltId;
    @NotNull
    private Integer countryId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Integer getClubId() {
        return clubId;
    }

    public void setClubId(Integer clubId) {
        this.clubId = clubId;
    }

    public Integer getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(Integer documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public Integer getBeltId() {
        return beltId;
    }

    public void setBeltId(Integer beltId) {
        this.beltId = beltId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof AthleteDTO athleteDTO))
            return false;
        return Objects.equals(this.name, athleteDTO.name) && Objects.equals(this.lastName, athleteDTO.lastName) && Objects.equals(this.idNumber, athleteDTO.idNumber)
                && Objects.equals(this.sex, athleteDTO.sex) && Objects.equals(this.birthDate, athleteDTO.birthDate) && Objects.equals(this.weight, athleteDTO.weight)
                && Objects.equals(this.pictureUrl, athleteDTO.pictureUrl) && Objects.equals(this.clubId, athleteDTO.clubId) && Objects.equals(this.documentTypeId, athleteDTO.documentTypeId)
                && Objects.equals(this.beltId, athleteDTO.beltId) && Objects.equals(this.countryId, athleteDTO.countryId);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.name, this.lastName, this.idNumber, this.sex, this.birthDate, this.weight, this.pictureUrl, this.clubId, this.documentTypeId, this.beltId, this.countryId);
    }

    @Override
    public String toString() {
        return "AthleteDTO{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", sex=" + sex + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", weight=" + weight + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", clubId=" + clubId + '\'' +
                ", documentTypeId=" + documentTypeId + '\'' +
                ", beltId=" + beltId + '\'' +
                ", countryId=" + countryId + '\'' +
                '}';
    }
}
