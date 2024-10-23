package com.xaraxx.macs.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;

    private String twoCharCountryCode;

    private String threeCharCountryCode;


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

    public String getTwoCharCountryCode() {
        return twoCharCountryCode;
    }

    public void setTwoCharCountryCode(String twoCharCountryCode) {
        this.twoCharCountryCode = twoCharCountryCode;
    }

    public String getThreeCharCountryCode() {
        return threeCharCountryCode;
    }

    public void setThreeCharCountryCode(String threeCharCountryCode) {
        this.threeCharCountryCode = threeCharCountryCode;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Country country))
            return false;
        return Objects.equals(this.id, country.id) && Objects.equals(this.name, country.name) && Objects.equals(this.twoCharCountryCode, country.twoCharCountryCode) && Objects.equals(this.threeCharCountryCode, country.threeCharCountryCode);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.name, this.twoCharCountryCode, this.threeCharCountryCode);
    }

    @Override
    public String toString(){
        return "Country{" + "id=" + this.id + '\'' + ", name=" + this.name + '\'' + ", contry-code-2="+ this.twoCharCountryCode + '\'' + ", country-code-3=" + this.threeCharCountryCode + '}';
    }
}