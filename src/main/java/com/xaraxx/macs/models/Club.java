package com.xaraxx.macs.models;

import com.xaraxx.macs.models.Municipality;
import com.xaraxx.macs.models.Country;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Id;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Club club = (Club) o;
        return id.equals(club.id) && name.equals(club.name) && email.equals(club.email) && municipality.equals(club.municipality) && country.equals(club.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, municipality, country);
    }

    @Override
    public String toString() {
        return "Club{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", municipality=" + municipality + '\'' +
                ", country=" + country + '\'' +
                '}';
    }
}
