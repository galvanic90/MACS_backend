package com.xaraxx.macs.mappers;

import com.xaraxx.macs.DTOs.CategoriesDTO;
import com.xaraxx.macs.exceptions.EntityNotFoundException;
import com.xaraxx.macs.models.Categories;
import com.xaraxx.macs.repositories.CategoryAgeRepository;
import com.xaraxx.macs.repositories.CategoryBeltGradeRepository;
import com.xaraxx.macs.repositories.CategoryWeightRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoriesMapper {
    @Autowired
    private final CategoryWeightRepository categoryWeightRepository;
    @Autowired
    private final CategoryBeltGradeRepository categoryBeltGradeRepository;
    @Autowired
    private final CategoryAgeRepository categoryAgeRepository;

    CategoriesMapper(CategoryWeightRepository categoryWeightRepository, CategoryBeltGradeRepository categoryBeltGradeRepository, CategoryAgeRepository categoryAgeRepository){
        this.categoryWeightRepository = categoryWeightRepository;
        this.categoryBeltGradeRepository = categoryBeltGradeRepository;
        this.categoryAgeRepository = categoryAgeRepository;
    }

    public CategoriesDTO convertToCategoriesDTO(Categories categories){
        CategoriesDTO dto = new CategoriesDTO();
        dto.setSex(categories.getSex());
        dto.setCategoriesWeightId(categories.getCategoriesWeight().getId());
        dto.setCategoriesBeltGradeId(categories.getCategoriesBeltGrade().getId());
        dto.setCategoriesAgeId(categories.getCategoriesAge().getId());
        return dto;
    }

    public Categories convertToCategories(CategoriesDTO categoriesDTO){
        Categories categories = new Categories();
        categories.setSex(categoriesDTO.getSex());
        categories.setCategoriesWeight(categoryWeightRepository.findById(categoriesDTO.getCategoriesWeightId()).orElseThrow(()-> new EntityNotFoundException("Category weight not found")));
        categories.setCategoriesBeltGrade(categoryBeltGradeRepository.findById(categoriesDTO.getCategoriesBeltGradeId()).orElseThrow(()-> new EntityNotFoundException("Category Belt grade not found")));
        categories.setCategoriesAge(categoryAgeRepository.findById(categoriesDTO.getCategoriesAgeId()).orElseThrow(()-> new EntityNotFoundException(("Category age not found"))));
        return categories;
    }
}
