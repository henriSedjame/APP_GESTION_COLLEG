package com.shj.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shj.app.entities.Identite;
import com.shj.app.entities.Matiere;
import com.shj.app.entities.Professeur;

public interface ProfesseurRepository extends JpaRepository<Professeur, Long> {

    @Query( "SELECT prof "
            + "FROM Professeur prof JOIN prof.identite Iden JOIN Iden.identifiant Id "
            + "WHERE Id.login = ?1 AND Id.motDePasse = ?2" )
    Professeur findByLoginAndMotDePasse( String login, String motDePasse );

    @Query( "SELECT prof "
            + "FROM Professeur prof JOIN prof.identite Iden "
            + "WHERE Iden.nom = ?1 " )
    List<Professeur> findByNom( String nom );

    @Query( "SELECT prof "
            + "FROM Professeur prof JOIN prof.identite Iden "
            + "WHERE Iden.nom = ?1 AND Iden.prenom = ?2" )
    Professeur findByNomAndPrenom( String nom, String prenom );

    @Query( "SELECT prof "
            + "FROM Professeur prof "
            + "WHERE prof.matiere = ?1" )
    List<Professeur> findByMatiere( Matiere matiere );

    Professeur findByNumPersonnel( String numPersonnel );

    Professeur findByIdentite( Identite identite );

}
