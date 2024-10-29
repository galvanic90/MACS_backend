package com.xaraxx.macs.controllers;

import com.xaraxx.macs.exceptions.EntityNotFoundException;
import com.xaraxx.macs.models.Department;
import com.xaraxx.macs.repositories.DepartmentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {
    private final DepartmentRepository repository;

    DepartmentController(DepartmentRepository repository){
        this.repository = repository;
    }

    @GetMapping("/department")
    public @ResponseBody Iterable <Department> getAllDepartment(){
        return repository.findAll();
    }

    @GetMapping("/department/{id}")
    Department getDepartmentById(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
    }
}
