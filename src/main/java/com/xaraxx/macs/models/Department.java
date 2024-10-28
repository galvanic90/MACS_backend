package com.xaraxx.macs.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

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

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Department department))
            return false;
        return Objects.equals(this.id, department.id) && Objects.equals(this.name, department.name)
                && Objects.equals(this.code, department.code);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.name, this.code);
    }

    @Override
    public String toString(){
        return "Department{" + "id=" + this.id + '\'' +", name=" + this.name + '\'' + ", code=" + this.code + '}';
    }
}