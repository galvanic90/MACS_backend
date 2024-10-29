package com.xaraxx.macs.controllers;

import com.xaraxx.macs.exceptions.EntityNotFoundException;
import com.xaraxx.macs.models.CategoryBeltGrade;
import com.xaraxx.macs.repositories.CategoryBeltGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryBeltGradeController {
    @Autowired
    private final CategoryBeltGradeRepository repository;

    CategoryBeltGradeController(CategoryBeltGradeRepository repository){
        this.repository = repository;
    }

    @GetMapping("/category-belt-grade")
    public @ResponseBody Iterable<CategoryBeltGrade> getAllCategoriesByBeltGrade(){ return repository.findAll();}

    @PostMapping("/category-belt-grade")
    public CategoryBeltGrade createCategoryBeltGrade(@RequestBody CategoryBeltGrade newCategoryBeltGrade){
        return repository.save(newCategoryBeltGrade);
    }

    @GetMapping("/category-belt-grade/{id}")
    public CategoryBeltGrade getCategoryBeltGradeById(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
    }

    @PutMapping("/category-belt-grade/{id}")
    public CategoryBeltGrade updateCategoryBeltGradeById(@RequestBody CategoryBeltGrade newCategoryBeltGrade, @PathVariable Integer id){
        return repository.findById(id)
                .map(categoryBeltGrade -> {
                    categoryBeltGrade.setName(newCategoryBeltGrade.getName());
                    return repository.save(categoryBeltGrade);
                })
                .orElseGet(()-> {
                    return repository.save(newCategoryBeltGrade);
                });
    }

    @DeleteMapping("/category-belt-grade/{id}")
    public void deleteCategoryBeltGradeById(@PathVariable Integer id){
        repository.deleteById(id);
    }

}
