package com.xaraxx.macs.controllers;

import com.xaraxx.macs.models.CategoryWeight;
import com.xaraxx.macs.repository.CategoryWeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryWeightController {
    @Autowired
    private CategoryWeightRepository repository;

    CategoryWeightController(CategoryWeightRepository repository){
        this.repository = repository;
    }


    @GetMapping(path="/category-weight/")
    public @ResponseBody Iterable<CategoryWeight> getAllCategoriesByWeight() {
        // This returns a JSON or XML with the users
        return repository.findAll();
    }

}