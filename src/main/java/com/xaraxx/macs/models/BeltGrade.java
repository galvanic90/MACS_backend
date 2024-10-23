package com.xaraxx.macs.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class BeltGrade {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String color;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof BeltGrade beltGrade))
            return false;
        return Objects.equals(this.id, beltGrade.id) && Objects.equals(this.color, beltGrade.color);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.color);
    }

    @Override
    public String toString(){
        return "Belt-Grade{" + "id=" + this.id + '\'' + ", color='" + this.color + '}';
    }
}
