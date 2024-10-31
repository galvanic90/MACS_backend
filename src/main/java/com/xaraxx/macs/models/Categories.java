package com.xaraxx.macs.models;

import java.util.Objects;
import jakarta.persistence.*;

@Entity
public class Categories {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Enumerated(EnumType.ORDINAL)
    private Gender sex;

    @ManyToOne
    @JoinColumn(name="FK_category_weight")
    private CategoryWeight categoryWeight;

    @ManyToOne
    @JoinColumn(name="FK_category_belt_grade")
    private CategoryBeltGrade categoryBeltGrade;

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

    public CategoryWeight getCategoryWeight() {
        return categoryWeight;
    }

    public void setCategoryWeight(CategoryWeight categoryWeight) {
        this.categoryWeight = categoryWeight;
    }

    public CategoryBeltGrade getCategoryBeltGrade() {
        return categoryBeltGrade;
    }

    public void setCategoryBeltGrade(CategoryBeltGrade categoryBeltGrade) {
        this.categoryBeltGrade = categoryBeltGrade;
    }

    public CategoryAge getCategoryAge() {
        return categoryAge;
    }

    public void setCategoryAge(CategoryAge categoryAge) {
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
