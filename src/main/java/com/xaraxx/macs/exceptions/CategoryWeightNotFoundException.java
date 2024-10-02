package com.xaraxx.macs.exceptions;

public class CategoryWeightNotFoundException extends RuntimeException {
    CategoryWeightNotFoundException(Integer id){
        super("Could not find the category weight" + id);
    }
}
