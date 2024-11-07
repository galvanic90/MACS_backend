package com.xaraxx.macs.exceptions;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(Integer id){
        super("Could not found the Entity" + id);
    }

    public EntityNotFoundException(String message){
        super(message);
    }
}
