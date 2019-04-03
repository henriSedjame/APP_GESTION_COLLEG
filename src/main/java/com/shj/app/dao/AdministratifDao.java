package com.shj.app.dao;

import java.util.List;

import com.shj.app.entities.Administratif;

public interface AdministratifDao extends Dao<Administratif, Long> {

    Administratif findByLoginAndMotDePasse( String login, String motDePasse );

    List<Administratif> findByNom( String nom );

    Administratif findByNomAndPrenom( String nom, String prenom );
}
