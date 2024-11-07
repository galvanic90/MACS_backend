package com.xaraxx.macs.models;

import java.util.Objects;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Categories {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private Gender sex;
    @NotNull
    @ManyToOne
    @JoinColumn(name="FK_category_weight")
    private CategoryWeight categoryWeight;
    @NotNull
    @ManyToOne
    @JoinColumn(name="FK_category_belt_grade")
    private CategoryBeltGrade categoryBeltGrade;
    @NotNull
    @ManyToOne
    @JoinColumn(name="FK_category_age")
    private CategoryAge categoryAge;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (!(o instanceof Categories categories))
            return false;
        return Objects.equals(this.id, categories.id) && Objects.equals(this.sex, categories.sex) && Objects.equals(this.categoryWeight, categories.categoryWeight)
                && Objects.equals(this.categoryBeltGrade, categories.categoryBeltGrade) && Objects.equals(this.categoryAge, categories.categoryAge);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.sex, this.categoryWeight, this.categoryBeltGrade, this.categoryAge);
    }

    @Override
    public String toString() {
        return "Categories{" +
                "id=" + id +
                ", sex=" + sex +
                ", categoryWeight=" + categoryWeight +
                ", categoryBeltGrade=" + categoryBeltGrade +
                ", categoryAge=" + categoryAge +
                '}';
    }
}
