package com.xaraxx.macs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CategoryBeltGradeNotFoundAdvice {
    @ExceptionHandler(CategoryBeltGradeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String categoryBeltGradeNotFoundHandler(CategoryBeltGradeNotFoundException ex){
        return ex.getMessage();
    }
}
