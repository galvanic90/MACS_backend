package com.xaraxx.macs.controllers;

import com.xaraxx.macs.exceptions.EntityNotFoundException;
import com.xaraxx.macs.models.DocumentType;
import com.xaraxx.macs.repositories.DocumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentTypeController {
    @Autowired
    final private DocumentTypeRepository repository;

    DocumentTypeController(DocumentTypeRepository repository){
        this.repository = repository;
    }

    @GetMapping("/doc-type")
    public @ResponseBody Iterable <DocumentType> getAllDocumentType(){
        return repository.findAll();
    }

    @GetMapping("/doc-type/{id}")
    DocumentType getDocumentTypeById(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
    }
}
