package com.shj.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shj.app.entities.Administratif;

public interface AdministratifRepository extends JpaRepository<Administratif, Long> {

    @Query( "SELECT admin "
            + "FROM Administratif admin JOIN admin.identite Iden JOIN Iden.identifiant Id "
            + "WHERE Id.login = ?1 AND Id.motDePasse = ?2" )
    Administratif findByLoginAndMotDePasse( String login, String motDePasse );

    @Query( "SELECT admin "
            + "FROM Administratif admin JOIN admin.identite Iden "
            + "WHERE Iden.nom = ?1 " )
    List<Administratif> findByNom( String nom );

    @Query( "SELECT admin "
            + "FROM Administratif admin JOIN admin.identite Iden "
            + "WHERE Iden.nom = ?1 AND Iden.prenom = ?2" )
    Administratif findByNomAndPrenom( String nom, String prenom );
}
