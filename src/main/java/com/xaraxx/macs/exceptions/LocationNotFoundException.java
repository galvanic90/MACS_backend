package com.xaraxx.macs.exceptions;

public class LocationNotFoundException extends RuntimeException{
     public LocationNotFoundException(Integer id){
        super("Could not found the location" + id);
    }
}
