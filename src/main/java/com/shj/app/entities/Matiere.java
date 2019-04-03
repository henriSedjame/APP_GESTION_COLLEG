package com.shj.app.entities;

public enum Matiere {
    Français( "Français" ), Maths( "Mathematiques" ), SVT( "Sciences de la Vie et de la Terre" ), PC(
            "Physiques-Chimie" ), Sport( "Sport" ), HG( "Histoire-Geographie" ), Anglais( "Anglais" );

    private String label;

    private Matiere( String label ) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel( String label ) {
        this.label = label;
    }

}
