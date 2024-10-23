package com.xaraxx.macs.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;

    private String address;

    private String phoneNumber;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Location location))
            return false;
        return Objects.equals(this.id, location.id) && Objects.equals(this.name, location.name)
                && Objects.equals(this.address, location.address) && Objects.equals(this.phoneNumber, location.phoneNumber);

    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.name, this.address, this.phoneNumber);
    }

    @Override
    public String toString(){
        return "Location{" + "id=" + this.id + '\'' + ", name='" + this.name + '\'' + ", address='" + this.address + '\'' + ", phone-number='" + this.phoneNumber + '}';
    }
}