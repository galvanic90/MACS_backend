package com.xaraxx.macs.exceptions;

public class MunicipalityNotFoundException extends RuntimeException {
    public MunicipalityNotFoundException(Integer id){
        super("Could not found the location" + id);
    }

}
