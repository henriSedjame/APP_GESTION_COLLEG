package com.shj.app.entities;

public enum Jour {
    J1( "Lundi" ), J2( "Mardi" ), J3( "Mercredi" ), J4( "Jeudi" ), J5( "Vendredi" );

    private String label;

    private Jour( String label ) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel( String label ) {
        this.label = label;
    }

}
