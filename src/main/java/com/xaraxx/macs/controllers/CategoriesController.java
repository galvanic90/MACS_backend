package com.xaraxx.macs.controllers;
import com.xaraxx.macs.exceptions.EntityNotFoundException;
import com.xaraxx.macs.models.Categories;
import com.xaraxx.macs.repositories.CategoriesRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class CategoriesController {
    @Autowired
    private final CategoriesRepository repository;

    CategoriesController(CategoriesRepository repository){
        this.repository = repository;
    }

    @GetMapping("/categories")
    public @ResponseBody Iterable<Categories> getAllCategories(){
        return repository.findAll();
    }

    @PostMapping("/categories")
    public Categories createCategories(@RequestBody Categories newCategory){
        return repository.save(newCategory);
    }

    @GetMapping("/categories/{id}")
    public Categories getCategoriesById(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(()->
                    new EntityNotFoundException(id)
                );
    }

    @PutMapping("/categories/{id}")
    public Categories updateCategoriesById(@RequestBody Categories newCategories, @PathVariable Integer id){
        return repository.findById(id)
                .map((categories)->{categories.setSex(newCategories.getSex());
                    categories.setCategoriesWeight(newCategories.getCategoriesWeight());
                    categories.setCategoriesBeltGrade(newCategories.getCategoriesBeltGrade());
                    categories.setCategoriesAge(newCategories.getCategoriesAge());
                    return repository.save(categories);
                })
                .orElseGet(()-> repository.save(newCategories));
    }

    @DeleteMapping("/categories/{id}")
    public void deleteCategoriesById(@PathVariable Integer id){
        repository.deleteById(id);
    }
}
