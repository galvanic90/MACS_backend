package com.xaraxx.macs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.xaraxx.macs.models.Municipality;

@RestControllerAdvice
public class MunicipalityNotFoundAdvice {
    @ExceptionHandler(MunicipalityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String municipalityNotFoundHandler(MunicipalityNotFoundException exception){
        return exception.getMessage();
    }
}
