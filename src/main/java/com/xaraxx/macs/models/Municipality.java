package com.xaraxx.macs.models;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Municipality{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Municipality municipality))
            return false;
        return Objects.equals(this.id, municipality.id) && Objects.equals(this.name, municipality.name) && Objects.equals(this.department, municipality.department);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.name, this.department);
    }

    @Override
    public String toString(){
        return "Municipality{" + "id=" + this.id + '\'' +", name=" + this.name + '\'' +", department=" + this.department + "}";
    }

}