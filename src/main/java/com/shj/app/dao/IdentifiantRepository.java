package com.shj.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shj.app.entities.Identifiant;

public interface IdentifiantRepository extends JpaRepository<Identifiant, Long> {

    Identifiant findByLoginAndMotDePasse( String login, String motDePasse );

    Identifiant findByLogin( String Login );

}
