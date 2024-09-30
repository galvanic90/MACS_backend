package com.xaraxx.macs.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CategoryWeight {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;

    private String inicialWeight;

    private String finalWeight;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInicialWeight() {
        return inicialWeight;
    }

    public void setInicialWeight(String inicialWeight) {
        this.inicialWeight = inicialWeight;
    }

    public String getFinalWeight() {
        return finalWeight;
    }

    public void setFinalWeight(String finalWeight) {
        this.finalWeight = finalWeight;
    }
}