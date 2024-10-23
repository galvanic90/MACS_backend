package com.xaraxx.macs.controllers;

import com.xaraxx.macs.models.CategoryAge;
import com.xaraxx.macs.repositories.CategoryAgeRepository ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryAgeController {
    @Autowired
    private CategoryAgeRepository repository;

    CategoryAgeController(CategoryAgeRepository repository){
        this.repository = repository;
    }

    @GetMapping(path="/category-age")
    public @ResponseBody Iterable<CategoryAge> getAllCategoriesByAges() {
        // This returns a JSON or XML with the users
        return repository.findAll();
    }

}
