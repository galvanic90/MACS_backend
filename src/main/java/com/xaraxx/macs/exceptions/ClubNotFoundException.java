package com.xaraxx.macs.exceptions;



public class ClubNotFoundException extends RuntimeException{
    public ClubNotFoundException(Integer id){
        super("Could not find the club" + id);
    }

}
