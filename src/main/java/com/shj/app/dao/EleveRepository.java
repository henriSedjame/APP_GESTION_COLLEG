package com.shj.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shj.app.entities.Classe;
import com.shj.app.entities.Eleve;

public interface EleveRepository extends JpaRepository<Eleve, Long> {

    @Query( "SELECT el "
            + "FROM Eleve el JOIN el.identite Iden JOIN Iden.identifiant Id "
            + "WHERE Id.login = ?1 AND Id.motDePasse = ?2" )
    Eleve findByLoginAndMotDePasse( String login, String motDePasse );

    @Query( "SELECT el "
            + "FROM Eleve el JOIN el.identite Iden "
            + "WHERE Iden.nom = ?1 " )
    List<Eleve> findByNom( String nom );

    @Query( "SELECT el "
            + "FROM Eleve el JOIN el.identite Iden "
            + "WHERE Iden.nom = ?1 AND Iden.prenom = ?2" )
    Eleve findByNomAndPrenom( String nom, String prenom );

    @Query( "SELECT el FROM Eleve el WHERE el.classe = ?1" )
    List<Eleve> findByClasse( Classe classe );

    Eleve findByNumEleve( String numEleve );

}
