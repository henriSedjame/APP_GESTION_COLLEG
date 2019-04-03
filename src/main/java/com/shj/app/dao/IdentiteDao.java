package com.shj.app.dao;

import com.shj.app.entities.Adresse;
import com.shj.app.entities.Identifiant;
import com.shj.app.entities.Identite;

public interface IdentiteDao extends Dao<Identite, Long> {

    Identite findByIdentifiant( Identifiant identifiant );

    Identite findByNomAndPrenom( String nom, String prenom );

    void updateAdresse( Adresse adresse, String nom, String prenom );

    void updateIdentifiant( Identifiant identifiant, String nom, String prenom );

}
