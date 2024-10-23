package com.xaraxx.macs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CategoryWeightNotFoundAdvice {
    @ExceptionHandler(CategoryWeightNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String categoryWeightNotFoundHandler(CategoryWeightNotFoundException ex){
        return ex.getMessage();
    }
}
