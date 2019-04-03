package com.shj.app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn( name = "Type", discriminatorType = DiscriminatorType.STRING )
public abstract class Personnel {

    @Version
    private int        version;
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long       id;
    @Column( length = 10, unique = true )
    private String     numPersonnel;
    @Enumerated( EnumType.STRING )
    private PosteAdmin poste;
    @OneToOne( cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE, CascadeType.REFRESH } )
    @JoinColumn( name = "id_identite" )
    private Identite   identite;

    public Personnel() {
        super();
    }

    public Personnel( String numPersonnel, PosteAdmin poste ) {
        super();
        this.numPersonnel = numPersonnel;
        this.poste = poste;
    }

    public Personnel( String numPersonnel, PosteAdmin poste, Identite identite ) {
        this( numPersonnel, poste );
        this.identite = identite;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion( int version ) {
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getNumPersonnel() {
        return numPersonnel;
    }

    public void setNumPersonnel( String numPersonnel ) {
        this.numPersonnel = numPersonnel;
    }

    public PosteAdmin getPoste() {
        return poste;
    }

    public void setPoste( PosteAdmin poste ) {
        this.poste = poste;
    }

    public Identite getIdentite() {
        return identite;
    }

    public void setIdentite( Identite identite ) {
        this.identite = identite;
    }

}
