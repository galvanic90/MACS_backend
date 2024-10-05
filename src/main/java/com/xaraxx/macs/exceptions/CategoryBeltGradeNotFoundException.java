package com.xaraxx.macs.exceptions;

public class CategoryBeltGradeNotFoundException extends  RuntimeException{
    public CategoryBeltGradeNotFoundException(Integer id){
        super("Could not find the category belt grade" + id);
    }
}
