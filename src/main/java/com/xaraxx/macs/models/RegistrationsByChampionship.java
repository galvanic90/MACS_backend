package com.xaraxx.macs.models;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class RegistrationsByChampionship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="FK_athlete", referencedColumnName = "id")
    private Athlete athlete;
    @ManyToOne
    @JoinColumn(name="FK_categories_by_champ", referencedColumnName = "id")
    private CategoriesByChampionship categoriesByChampionship;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    public CategoriesByChampionship getCategoriesByChampionship() {
        return categoriesByChampionship;
    }

    public void setCategoriesByChampionship(CategoriesByChampionship categoriesByChampionship) {
        this.categoriesByChampionship = categoriesByChampionship;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof RegistrationsByChampionship registrations))
            return false;
        return Objects.equals(this.id, registrations.id) && Objects.equals(this.athlete, registrations.athlete)
                && Objects.equals(this.categoriesByChampionship, registrations.categoriesByChampionship);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.athlete, this.categoriesByChampionship);
    }

    @Override
    public String toString() {
        return "RegistrationsByChampionship{" +
                "id=" + id +
                ", athlete=" + athlete +
                ", categoriesByChampionship=" + categoriesByChampionship +
                '}';
    }
}
