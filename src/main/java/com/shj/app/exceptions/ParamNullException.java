package com.shj.app.exceptions;

@SuppressWarnings( "serial" )
public class ParamNullException extends Exception {

    private String message = "";

    public ParamNullException( String message ) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
