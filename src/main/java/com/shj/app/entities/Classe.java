package com.shj.app.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Classe {

    @Version
    private int                    version;
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long                   id;
    @Enumerated( EnumType.STRING )
    @Column( unique = true )
    private Niveau                 niveau;
    @ManyToMany( mappedBy = "listClasse", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST } )
    private Collection<Professeur> listProfesseur = new ArrayList<>();
    @OneToMany( mappedBy = "classe", cascade = { CascadeType.PERSIST } )
    private Collection<Eleve>      listEleve      = new ArrayList<>();
    @OneToMany( mappedBy = "classe", cascade = { CascadeType.PERSIST } )
    private Collection<Cours>      listCours      = new ArrayList<>();

    public Classe() {
        super();
    }

    public Classe( Niveau niveau ) {
        super();
        this.niveau = niveau;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau( Niveau niveau ) {
        this.niveau = niveau;
    }

    public Collection<Professeur> getListProfesseur() {
        return listProfesseur;
    }

    public void setListProfesseur( Collection<Professeur> listProfesseur ) {
        this.listProfesseur = listProfesseur;
    }

    public Collection<Eleve> getListEleve() {
        return listEleve;
    }

    public void setListEleve( Collection<Eleve> listEleve ) {
        this.listEleve = listEleve;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion( int version ) {
        this.version = version;
    }

    public Collection<Cours> getListCours() {
        return listCours;
    }

    public void setListCours( Collection<Cours> listCours ) {
        this.listCours = listCours;
    }

}
