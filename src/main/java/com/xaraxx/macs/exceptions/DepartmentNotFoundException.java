package com.xaraxx.macs.exceptions;

public class DepartmentNotFoundException extends RuntimeException{
    public DepartmentNotFoundException(Integer id){
        super("Could not find the department " + id);
    }
}
