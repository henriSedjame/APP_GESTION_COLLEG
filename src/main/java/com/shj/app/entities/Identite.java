package com.shj.app.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.Size;

@Entity
public class Identite {

    @Version
    private int         version;
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long        id;
    @Enumerated( EnumType.STRING )
    private Civilite    civilite;
    @Column( length = 50 )
    @Size( min = 2, max = 25, message = "Le nom doit contenir en 2 et 25 caractères." )
    private String      nom;
    @Column( length = 50 )
    @Size( min = 2, max = 25, message = "Le prenom doit contenir en 2 et 25 caractères." )
    private String      prenom;
    @Temporal( TemporalType.DATE )
    private Date        dateNaissance;
    @Embedded
    private Adresse     adresse;
    @OneToOne( cascade = { CascadeType.PERSIST, CascadeType.REMOVE } )
    @JoinColumn( name = "id_identifiant" )
    private Identifiant identifiant;
    @OneToOne( targetEntity = Personnel.class, mappedBy = "identite" )
    private Personnel   personnel;
    @OneToOne( targetEntity = Eleve.class, mappedBy = "identite" )
    private Eleve       eleve;

    public Identite() {

    }

    public Identite( Civilite civilite, String nom, String prenom, Date dateNaissance ) {
        super();
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;

    }

    public Identite( Civilite civilite, String nom, String prenom, Date dateNaissance, Adresse adresse,
            Identifiant identifiant ) {
        super();
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.identifiant = identifiant;
    }

    public Civilite getCivilite() {
        return civilite;
    }

    public void setCivilite( Civilite civilite ) {
        this.civilite = civilite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom( String prenom ) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance( Date dateNaissance ) {
        this.dateNaissance = dateNaissance;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse( Adresse adresse ) {
        this.adresse = adresse;
    }

    public Identifiant getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant( Identifiant identifiants ) {
        this.identifiant = identifiants;
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

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel( Personnel personnel ) {
        this.personnel = personnel;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve( Eleve eleve ) {
        this.eleve = eleve;
    }

}
