package com.xaraxx.macs.models;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class CategoryWeight {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;

    private String initialWeight;

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

    public String getInitialWeight() {
        return initialWeight;
    }

    public void setInitialWeight(String initialWeight) {
        this.initialWeight = initialWeight;
    }

    public String getFinalWeight() {
        return finalWeight;
    }

    public void setFinalWeight(String finalWeight) {
        this.finalWeight = finalWeight;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof CategoryWeight categoryWeight))
            return false;
        return Objects.equals(this.id, categoryWeight.id) && Objects.equals(this.name, categoryWeight.name)
                && Objects.equals(this.initialWeight, categoryWeight.initialWeight) && Objects.equals(this.finalWeight, categoryWeight.finalWeight);

    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.name, this.initialWeight, this.finalWeight);
    }

    @Override
    public String toString(){
        return "Category-Weight{" + "id=" + this.id + '\'' +", name='" + this.name + '\'' + ", initialWeight='" + this.initialWeight + '\'' + ", finalWeight='" + this.finalWeight + '}';
    }

    @Entity
    public static class Clubs {
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private Integer id;

        private String name;

        private String email;

        @ManyToOne
        @JoinColumn(name = "FK_country")
        private Country country;

        @ManyToOne
        @JoinColumn(name = "FK_municipality")
        private Municipality municipality;

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

        public Country getCountry() {
            return country;
        }

        public void setCountry(Country country) {
            this.country = country;
        }

        public Municipality getMunicipality() {
            return municipality;
        }

        public void setMunicipality(Municipality municipality) {
            this.municipality = municipality;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Clubs clubs = (Clubs) o;
            return Objects.equals(this.id, clubs.id) && Objects.equals(this.name, clubs.name) && Objects.equals(this.email, clubs.email) && country.equals(clubs.country) && municipality.equals(clubs.municipality);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.id, this.name, this.email, this.country, this.municipality);
        }

        @Override
        public String toString() {
            return "Clubs{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", country=" + country + '\'' +
                    ", municipality=" + municipality + '\'' +
                    '}';
        }
    }
}