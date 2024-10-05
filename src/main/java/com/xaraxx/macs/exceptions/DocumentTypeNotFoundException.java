package com.xaraxx.macs.exceptions;



public class DocumentTypeNotFoundException extends RuntimeException {

    public DocumentTypeNotFoundException(Integer id){
        super("Could not found document type" + id);
    }

}
