package com.shj.app.entities;

public enum Niveau {

    N_6EME( "Sixieme" ), N_5EME( "Cinquieme" ), N_4EME( "Quatrieme" ), N_3EME( "Troisieme" );

    private String label;

    private Niveau( String label ) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel( String label ) {
        this.label = label;
    }

}
