package com.shj.app.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue( "Admin" )
public class Administratif extends Personnel {

    public Administratif() {
        super();

    }

    public Administratif( String numPersonnel, PosteAdmin poste, Identite identite ) {
        super( numPersonnel, poste, identite );

    }

}
