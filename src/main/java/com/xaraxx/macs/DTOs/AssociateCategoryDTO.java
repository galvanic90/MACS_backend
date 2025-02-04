package com.xaraxx.macs.DTOs;

import com.xaraxx.macs.models.Gender;

import java.util.Objects;

public class AssociateCategoryDTO {
    private Integer age;
    private Integer belt;
    private Integer championship;
    private Gender sex;
    private Integer weight;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getBelt() {
        return belt;
    }

    public void setBelt(Integer belt) {
        this.belt = belt;
    }

    public Integer getChampionship() {
        return championship;
    }

    public void setChampionship(Integer championship) {
        this.championship = championship;
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AssociateCategoryDTO that = (AssociateCategoryDTO) o;
        return Objects.equals(age, that.age) && Objects.equals(belt, that.belt) && Objects.equals(championship, that.championship) && sex == that.sex && Objects.equals(weight, that.weight);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(age);
        result = 31 * result + Objects.hashCode(belt);
        result = 31 * result + Objects.hashCode(championship);
        result = 31 * result + Objects.hashCode(sex);
        result = 31 * result + Objects.hashCode(weight);
        return result;
    }

    @Override
    public String toString() {
        return "AssociateCategoryDTO{" +
                "age=" + age +
                ", belt=" + belt +
                ", championship=" + championship +
                ", sex=" + sex +
                ", weight=" + weight +
                '}';
    }
}
