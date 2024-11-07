package com.xaraxx.macs.models;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
public class Club {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;

    private String email;

    @ManyToOne
    @JoinColumn(name = "FK_municipality")
    private Municipality municipality;

    @ManyToOne
    @JoinColumn(name = "FK_country", nullable = false)
    private Country country;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (!(o instanceof Club club))
            return false;
        return Objects.equals(this.id, club.id) && Objects.equals(this.name, club.name) && Objects.equals(this.email, club.email)
                && Objects.equals(this.municipality, club.municipality) && Objects.equals(this.country, club.country);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.name, this.email, this.municipality, this.country);
    }
    @Override
    public String toString() {
        return "Club{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", email='" + this.email + '\'' +
                ", municipality=" + this.municipality + '\'' +
                ", country=" + this.country + '\'' +
                '}';
    }
}
