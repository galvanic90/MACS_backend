package com.xaraxx.macs.exceptions;

public class BeltGradeNotFoundException extends RuntimeException {
    public BeltGradeNotFoundException(Integer id){
        super("Could not find the belt grade" + id);
    }
}
