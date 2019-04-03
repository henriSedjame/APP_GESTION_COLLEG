package com.shj.app.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Salle {

    @Version
    private int               version;
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long              id;
    @Column( length = 50 )
    private String            nom;
    private int               capacite;
    @OneToMany( mappedBy = "salle", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST } )
    private Collection<Cours> listCours = new ArrayList<>();

    public Salle() {
        super();
    }

    public Salle( String nom, int capacite ) {
        super();
        this.nom = nom;
        this.capacite = capacite;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite( int capacite ) {
        this.capacite = capacite;
    }

    public Collection<Cours> getListCours() {
        return listCours;
    }

    public void setListCours( Collection<Cours> listCours ) {
        this.listCours = listCours;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion( int version ) {
        this.version = version;
    }

}
