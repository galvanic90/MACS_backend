package com.xaraxx.macs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BeltGradeNotFoundAdvice {
    @ExceptionHandler(BeltGradeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String beltGradeNotFoundHandler(BeltGradeNotFoundException ex){
        return ex.getMessage();
    }
}
