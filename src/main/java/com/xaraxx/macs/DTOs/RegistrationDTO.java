package com.xaraxx.macs.DTOs;

import java.util.List;

public class RegistrationDTO {
    Integer category;
    List<Integer> athletes;

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public List<Integer> getAthletes() {
        return athletes;
    }

    public void setAthletes(List<Integer> athletes) {
        this.athletes = athletes;
    }
}
