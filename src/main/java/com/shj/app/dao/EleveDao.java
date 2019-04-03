package com.shj.app.dao;

import java.util.List;

import com.shj.app.entities.Classe;
import com.shj.app.entities.Eleve;

public interface EleveDao extends Dao<Eleve, Long> {

    Eleve findByLoginAndMotDePasse( String login, String motDePasse );

    List<Eleve> findByNom( String nom );

    Eleve findByNomAndPrenom( String nom, String prenom );

    List<Eleve> findByClasse( Classe classe );

    Eleve findByNumEleve( String numEleve );

}
