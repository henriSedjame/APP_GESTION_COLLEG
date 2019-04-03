package com.shj.app.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings( "serial" )
@Embeddable
public class HeureCours implements Serializable {

    @Enumerated( EnumType.STRING )
    private Jour jour;
    @Temporal( TemporalType.TIME )
    private Date heureDebut;
    @Temporal( TemporalType.TIME )
    private Date heureFin;

    public HeureCours() {

    }

    public HeureCours( Jour jour, Date heureDebut, Date heureFin ) {
        super();
        this.jour = jour;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }

    public Date getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut( Date heureDebut ) {
        this.heureDebut = heureDebut;
    }

    public Date getHeureFin() {
        return heureFin;
    }

    public void setHeureFin( Date heureFin ) {
        this.heureFin = heureFin;
    }

    public Jour getJour() {
        return jour;
    }

    public void setJour( Jour jour ) {
        this.jour = jour;
    }

}
