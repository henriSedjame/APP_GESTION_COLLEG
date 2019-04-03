package com.shj.app.exceptions;

@SuppressWarnings( "serial" )
public class MauvaisIdentifiantsException extends Exception {

    private String message = "";

    public MauvaisIdentifiantsException( String message ) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
