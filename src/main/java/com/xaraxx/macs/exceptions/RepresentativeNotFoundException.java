package com.xaraxx.macs.exceptions;

public class RepresentativeNotFoundException extends RuntimeException {
    public RepresentativeNotFoundException(Integer id){
        super("Could not found representative" + id);
    }
}
