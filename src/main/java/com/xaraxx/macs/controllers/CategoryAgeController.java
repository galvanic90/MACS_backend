package com.xaraxx.macs.controllers;

import com.xaraxx.macs.models.CategoryAge;
import com.xaraxx.macs.repository.CategoryAgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/category-age")
public class CategoryAgeController {
    @Autowired
    private CategoryAgeRepository categoryAgeRepository;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<CategoryAge> getAllUsers() {
        // This returns a JSON or XML with the users
        return categoryAgeRepository.findAll();
    }

}
