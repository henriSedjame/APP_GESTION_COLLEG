package com.shj.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table( name = "Identifiants_de_connexion" )
public class Identifiant {

    @Version
    private int      version;
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long     id;
    @Column( unique = true )
    @Size( min = 4, message = "Le login doit contenir au moins 4 caractères" )
    private String   login;
    @Pattern( regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[^A-Z^a-z^\\d]).{8,}", message = "Le mot de passe doit contenir au moins 8 caractères dont 1 chiffre, 1 majuscule, 1 minuscule et un caractère spécial." )
    private String   motDePasse;
    @OneToOne( mappedBy = "identifiant" )
    private Identite identite;

    public Identifiant() {

    }

    public Identifiant( String login, String motDePasse ) {
        super();
        this.login = login;
        this.motDePasse = motDePasse;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin( String login ) {
        this.login = login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse( String motDePasse ) {
        this.motDePasse = motDePasse;
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

    public Identite getIdentite() {
        return identite;
    }

    public void setIdentite( Identite identite ) {
        this.identite = identite;
    }

}
