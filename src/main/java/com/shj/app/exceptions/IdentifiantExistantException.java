package com.shj.app.exceptions;

@SuppressWarnings( "serial" )
public class IdentifiantExistantException extends Exception {

    private String message = "";

    public IdentifiantExistantException( String message ) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
