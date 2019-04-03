package com.shj.app.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@SuppressWarnings( "serial" )
@Entity
public class Cours implements Serializable {

    @Version
    private int        version;
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long       id;
    @Column( name = "Numero_cours", length = 10, unique = true )
    private String     numCours;
    @ManyToOne
    @JoinColumn( name = "id_salle" )
    private Salle      salle;
    @Embedded
    private HeureCours heureCours;
    @ManyToOne
    @JoinColumn( name = "id_professeur" )
    private Professeur professeur;
    @ManyToOne
    @JoinColumn( name = "id_classe" )
    private Classe     classe;

    public Cours() {

    }

    public Cours( String numCours ) {
        super();
        this.numCours = numCours;
    }

    public Cours( String numCours, Professeur professeur, Classe classe ) {
        this( numCours );
        this.professeur = professeur;
        this.classe = classe;
    }

    public Cours( String numCours, Professeur professeur, Classe classe, HeureCours heureCours, Salle salle ) {
        this( numCours, professeur, classe );
        this.salle = salle;
        this.heureCours = heureCours;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle( Salle salle ) {
        this.salle = salle;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur( Professeur professeur ) {
        this.professeur = professeur;
    }

    public String getNumCours() {
        return numCours;
    }

    public void setNumCours( String numCours ) {
        this.numCours = numCours;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion( int version ) {
        this.version = version;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse( Classe classe ) {
        this.classe = classe;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public HeureCours getHeureCours() {
        return heureCours;
    }

    public void setHeureCours( HeureCours heureCours ) {
        this.heureCours = heureCours;
    }

    @Override
    public String toString() {
        return this.heureCours.getJour().getLabel() + " " + this.heureCours.getHeureDebut() + " "
                + this.professeur.getMatiere();
    }

}
