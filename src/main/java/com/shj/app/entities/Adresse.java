package com.shj.app.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Pattern;

@SuppressWarnings( "serial" )
@Embeddable
public class Adresse implements Serializable {

    private String rue;
    @Column( name = "Code_Postal", length = 5 )
    @Pattern( regexp = "[0-9]{5}", message = "Le code postal doit contenir 5 chiffres" )
    private String codePostal;
    @Column( length = 50 )
    private String ville;

    public Adresse() {
        super();
    }

    public Adresse( String rue, String codePostal, String ville ) {
        super();
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public String getRue() {
        return rue;
    }

    public void setRue( String rue ) {
        this.rue = rue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal( String codePostal ) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille( String ville ) {
        this.ville = ville;
    }

}
