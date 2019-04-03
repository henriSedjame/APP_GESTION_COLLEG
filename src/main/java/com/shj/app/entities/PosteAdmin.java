package com.shj.app.entities;

public enum PosteAdmin {
    Directeur( "Directeur" ), Secretaire( "Secretaire" ), Professeur( "Professeur" );

    private String label;

    private PosteAdmin( String label ) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel( String label ) {
        this.label = label;
    }

}
