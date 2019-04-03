package com.shj.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.shj.app.entities.Adresse;
import com.shj.app.entities.Identifiant;
import com.shj.app.entities.Identite;

public interface IdentiteRepository extends JpaRepository<Identite, Long> {

    Identite findByIdentifiant( Identifiant identifiant );

    Identite findByNomAndPrenom( String nom, String prenom );

    @Modifying
    @Query( "update Identite ident set ident.adresse = ?1 where ident.nom = ?2 and ident.prenom = ?3" )
    void updateAdresse( Adresse adresse, String nom, String prenom );

    @Modifying
    @Query( "update Identite ident set ident.identifiant = ?1 where ident.nom = ?2 and ident.prenom = ?3" )
    void updateIdentifiant( Identifiant identifiant, String nom, String prenom );

}
