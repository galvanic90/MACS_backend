package com.xaraxx.macs.DTOs;

import com.xaraxx.macs.models.Gender;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class CategoriesDTO {
    @NotNull
    private Gender sex;
    @NotNull
    private Integer categoriesWeightId;
    @NotNull
    private Integer categoriesBeltGradeId;
    @NotNull
    private Integer categoriesAgeId;

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    public Integer getCategoriesWeightId() {
        return categoriesWeightId;
    }

    public void setCategoriesWeightId(Integer categoriesWeightId) {
        this.categoriesWeightId = categoriesWeightId;
    }

    public Integer getCategoriesBeltGradeId() {
        return categoriesBeltGradeId;
    }

    public void setCategoriesBeltGradeId(Integer categoriesBeltGradeId) {
        this.categoriesBeltGradeId = categoriesBeltGradeId;
    }

    public Integer getCategoriesAgeId() {
        return categoriesAgeId;
    }

    public void setCategoriesAgeId(Integer categoriesAgeId) {
        this.categoriesAgeId = categoriesAgeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof CategoriesDTO dto))
            return false;
        return Objects.equals(this.sex, dto.sex) && Objects.equals(this.categoriesWeightId, dto.categoriesWeightId)
                && Objects.equals(this.categoriesBeltGradeId, dto.categoriesBeltGradeId) && Objects.equals(this.categoriesAgeId, dto.categoriesAgeId);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.sex, this.categoriesWeightId, this.categoriesBeltGradeId, this.categoriesAgeId);
    }

    @Override
    public String toString() {
        return "CategoriesDTO{" +
                "sex=" + sex +
                ", categoriesWeightId=" + categoriesWeightId +
                ", categoriesBeltGradeId=" + categoriesBeltGradeId +
                ", categoriesAgeId=" + categoriesAgeId +
                '}';
    }
}
