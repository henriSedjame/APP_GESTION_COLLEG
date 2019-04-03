package com.shj.app.dao;

import com.shj.app.entities.Identifiant;

public interface IdentifiantDao extends Dao<Identifiant, Long> {

    Identifiant findIdentifiant( String login, String motDePasse );

    Identifiant findByLogin( String Login );
}
