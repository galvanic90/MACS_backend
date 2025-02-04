package com.xaraxx.macs.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
public class CategoriesByChampionship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="FK_championship")
    private Championship championship;
    //@NotNull
    @Enumerated(EnumType.ORDINAL)
    private Gender sex;
    //@NotNull
    @ManyToOne
    @JoinColumn(name="FK_category_weight")
    private CategoryWeight categoryWeight;
    //@NotNull
    @ManyToOne
    @JoinColumn(name="FK_category_belt_grade")
    private CategoryBeltGrade categoryBeltGrade;
    //@NotNull
    @ManyToOne
    @JoinColumn(name="FK_category_age")
    private CategoryAge categoryAge;

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

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    public CategoryWeight getCategoriesWeight() {
        return categoryWeight;
    }

    public void setCategoriesWeight(CategoryWeight categoryWeight) {
        this.categoryWeight = categoryWeight;
    }

    public CategoryBeltGrade getCategoriesBeltGrade() {
        return categoryBeltGrade;
    }

    public void setCategoriesBeltGrade(CategoryBeltGrade categoryBeltGrade) {
        this.categoryBeltGrade = categoryBeltGrade;
    }

    public CategoryAge getCategoriesAge() {
        return categoryAge;
    }

    public void setCategoriesAge(CategoryAge categoryAge) {
        this.categoryAge = categoryAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoriesByChampionship that = (CategoriesByChampionship) o;
        return Objects.equals(id, that.id) && Objects.equals(championship, that.championship) && sex == that.sex && Objects.equals(categoryWeight, that.categoryWeight) && Objects.equals(categoryBeltGrade, that.categoryBeltGrade) && Objects.equals(categoryAge, that.categoryAge);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(championship);
        result = 31 * result + Objects.hashCode(sex);
        result = 31 * result + Objects.hashCode(categoryWeight);
        result = 31 * result + Objects.hashCode(categoryBeltGrade);
        result = 31 * result + Objects.hashCode(categoryAge);
        return result;
    }

    @Override
    public String toString() {
        return "CategoriesByChampionship{" +
                "id=" + id +
                ", championship=" + championship +
                ", sex=" + sex +
                ", categoryWeight=" + categoryWeight +
                ", categoryBeltGrade=" + categoryBeltGrade +
                ", categoryAge=" + categoryAge +
                '}';
    }
}
