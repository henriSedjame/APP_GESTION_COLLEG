package com.shj.app.exceptions;

@SuppressWarnings( "serial" )
public class IdentiteExistantException extends Exception {

    private String message = "";

    public IdentiteExistantException( String message ) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
