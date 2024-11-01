package com.xaraxx.macs.models;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class CategoriesByChampionship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="FK_championship")
    private Championship championship;
    @ManyToOne
    @JoinColumn(name = "FK_category")
    private Categories category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Championship getChampionship() {
        return championship;
    }

    public void setChampionship(Championship championship) {
        this.championship = championship;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof CategoriesByChampionship categoriesByChampionship))
            return false;
        return Objects.equals(this.id, categoriesByChampionship.id) && Objects.equals(this.championship, categoriesByChampionship.championship)
                && Objects.equals(this.category, categoriesByChampionship.category);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.championship, this.category);
    }

    @Override
    public String toString() {
        return "CategoriesByChampionship{" +
                "id=" + id +
                ", championship=" + championship +
                ", category=" + category +
                '}';
    }
}
