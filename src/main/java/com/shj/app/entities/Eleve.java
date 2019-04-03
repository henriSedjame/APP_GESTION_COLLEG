package com.shj.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.Pattern;

@Entity
public class Eleve {

    @Version
    private int      version;
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long     id;
    @Column( name = "numero_Eleve", length = 10, unique = true )
    @Pattern( regexp = "^[A-Z]{2}[0-9]{6}", message = "Le numero élève doit contenir 2 lettres majuscules suivi de 6 chiffres. " )
    private String   numEleve;
    @ManyToOne
    @JoinColumn( name = "id_classe" )
    private Classe   classe;
    @OneToOne
    @JoinColumn( name = "id_identite" )
    private Identite identite;

    public Eleve() {

    }

    public Eleve( String numEleve ) {
        super();

        this.numEleve = numEleve;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getNumEleve() {
        return numEleve;
    }

    public void setNumEleve( String numEleve ) {
        this.numEleve = numEleve;
    }

    public Identite getIdentite() {
        return identite;
    }

    public void setIdentite( Identite identite ) {
        this.identite = identite;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse( Classe classe ) {
        this.classe = classe;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion( int version ) {
        this.version = version;
    }

}
