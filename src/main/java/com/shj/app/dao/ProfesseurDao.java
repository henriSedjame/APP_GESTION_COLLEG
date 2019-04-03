package com.shj.app.dao;

import java.util.List;

import com.shj.app.entities.Classe;
import com.shj.app.entities.Identite;
import com.shj.app.entities.Matiere;
import com.shj.app.entities.Professeur;

public interface ProfesseurDao extends Dao<Professeur, Long> {

    Professeur findByLoginAndMotDePasse( String login, String motDePasse );

    List<Professeur> findByNom( String nom );

    Professeur findByNomAndPrenom( String nom, String prenom );

    List<Professeur> findByMatiere( Matiere matiere );

    Professeur findByNumPersonnel( String numPersonnel );

    Professeur findByIdentite( Identite identite );

    List<Professeur> findByClasse( Classe classe );
}
