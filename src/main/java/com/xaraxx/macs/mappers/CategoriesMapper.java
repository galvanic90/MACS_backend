package com.xaraxx.macs.mappers;

import com.xaraxx.macs.DTOs.AssociateCategoryDTO;
import com.xaraxx.macs.exceptions.EntityNotFoundException;
import com.xaraxx.macs.models.CategoriesByChampionship;
import com.xaraxx.macs.models.Championship;
import com.xaraxx.macs.repositories.CategoryAgeRepository;
import com.xaraxx.macs.repositories.CategoryBeltGradeRepository;
import com.xaraxx.macs.repositories.CategoryWeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
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

    public AssociateCategoryDTO convertToAssociateCategoryDTO(CategoriesByChampionship categories){
        AssociateCategoryDTO dto = new AssociateCategoryDTO();
        dto.setChampionship(categories.getChampionship().getId());
        dto.setSex(categories.getSex());
        dto.setWeight(categories.getCategoriesWeight().getId());
        dto.setBelt(categories.getCategoriesBeltGrade().getId());
        dto.setAge(categories.getCategoriesAge().getId());
        return dto;
    }

    public CategoriesByChampionship convertToCategoriesByChampionship(AssociateCategoryDTO categoriesDTO){
        CategoriesByChampionship categories = new CategoriesByChampionship();
        Championship championship = new Championship();
        championship.setId(categoriesDTO.getChampionship());
        categories.setChampionship(championship);
        categories.setSex(categoriesDTO.getSex());
        categories.setCategoriesWeight(categoryWeightRepository.findById(categoriesDTO.getBelt()).orElseThrow(()-> new EntityNotFoundException("Category weight not found")));
        categories.setCategoriesBeltGrade(categoryBeltGradeRepository.findById(categoriesDTO.getBelt()).orElseThrow(()-> new EntityNotFoundException("Category Belt grade not found")));
        categories.setCategoriesAge(categoryAgeRepository.findById(categoriesDTO.getAge()).orElseThrow(()-> new EntityNotFoundException(("Category age not found"))));
        return categories;
    }
}
