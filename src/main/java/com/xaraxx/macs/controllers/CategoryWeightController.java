package com.xaraxx.macs.controllers;

import com.xaraxx.macs.models.CategoryWeight;
import com.xaraxx.macs.exceptions.CategoryWeightNotFoundException;
import com.xaraxx.macs.repository.CategoryWeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CategoryWeightController {
    @Autowired
    private final CategoryWeightRepository repository;

    CategoryWeightController(CategoryWeightRepository repository){
        this.repository = repository;
    }


    @GetMapping("/category-weight")
    public @ResponseBody Iterable<CategoryWeight> getAllCategoriesByWeight() {
        // This returns a JSON or XML with the users
        return repository.findAll();
    }

    @PostMapping("/category-weight")
    public CategoryWeight createCategoryWeight(@RequestBody CategoryWeight newCategoryWeight){
        return repository.save(newCategoryWeight);
    }

    // Get a single item
    @GetMapping("/category-weight/{id}")
    CategoryWeight getCategoryWeightById(@PathVariable Integer id){
        return repository.findById(id)
            .orElseThrow(() -> new CategoryWeightNotFoundException(id));
    }

    @PutMapping("/category-weight/{id}")
    CategoryWeight updateCategoryWeightById(@RequestBody CategoryWeight newCategoryWeight, @PathVariable Integer id){
        return repository.findById(id)
                .map(categoryWeight -> {
                    categoryWeight.setName(newCategoryWeight.getName());
                    categoryWeight.setInitialWeight(newCategoryWeight.getInitialWeight());
                    categoryWeight.setFinalWeight(newCategoryWeight.getFinalWeight());
                    return repository.save(categoryWeight);
                })
                .orElseGet(()->{
                   return repository.save(newCategoryWeight);
                });
    }

    @DeleteMapping("/category-weight/{id}")
    void deleteCategoryWeightById(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}