package com.shj.app.exceptions;

@SuppressWarnings( "serial" )
public class EleveExistantException extends Exception {

    private String message = "";

    public EleveExistantException( String message ) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
