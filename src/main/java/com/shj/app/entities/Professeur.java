package com.shj.app.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue( "Prof" )
public class Professeur extends Personnel {

    @OneToMany( mappedBy = "professeur", cascade = { CascadeType.PERSIST } )
    private Collection<Cours>  listCours  = new ArrayList<>();
    @ManyToMany
    @JoinTable( name = "Prof_Classe", joinColumns = {
            @JoinColumn( name = "id_prof" ) }, inverseJoinColumns = {
                    @JoinColumn( name = "id_classe" ) } )
    private Collection<Classe> listClasse = new ArrayList<>();
    @Enumerated( EnumType.STRING )
    private Matiere            matiere;

    public Professeur() {
        super();
    }

    public Professeur( String numPersonnel, PosteAdmin poste ) {
        super( numPersonnel, poste );

    }

    public Professeur( String numPersonnel, PosteAdmin poste, Identite identite, Matiere matiere ) {
        super( numPersonnel, poste, identite );
        this.matiere = matiere;
    }

    public Collection<Cours> getListCours() {
        return listCours;
    }

    public void setListCours( Collection<Cours> listCours ) {
        this.listCours = listCours;
    }

    public Collection<Classe> getListClasse() {
        return listClasse;
    }

    public void setListClasse( Collection<Classe> listClasse ) {
        this.listClasse = listClasse;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere( Matiere matiere ) {
        this.matiere = matiere;
    }

}
