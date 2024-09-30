package com.xaraxx.macs.controllers;

import com.xaraxx.macs.models.CategoryWeight;
import com.xaraxx.macs.repository.CategoryWeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/category-weight")
public class CategoryWeightController {
    @Autowired
    private CategoryWeightRepository categoryWeightRepository;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<CategoryWeight> getAllCategoriesByWeight() {
        // This returns a JSON or XML with the users
        return categoryWeightRepository.findAll();
    }

}