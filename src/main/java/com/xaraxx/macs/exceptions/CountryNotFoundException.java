package com.xaraxx.macs.exceptions;

public class CountryNotFoundException extends RuntimeException{
    public CountryNotFoundException(Integer id){
        super("Could not find the country" + id);
    }
}
