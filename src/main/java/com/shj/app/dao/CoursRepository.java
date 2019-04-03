package com.shj.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shj.app.entities.Classe;
import com.shj.app.entities.Cours;
import com.shj.app.entities.Professeur;

public interface CoursRepository extends JpaRepository<Cours, Long> {

    @Query( "SELECT c "
            + "FROM Cours c "
            + "WHERE c.classe = ?1 "
            + "ORDER BY c.heureCours.jour ASC, c.heureCours.heureDebut ASC" )
    List<Cours> findByClasse( Classe classe );

    @Query( "SELECT c "
            + "FROM Cours c "
            + "WHERE c.professeur = ?1 "
            + "ORDER BY c.heureCours.jour ASC, c.heureCours.heureDebut ASC" )
    List<Cours> findByProfesseur( Professeur professeur );

    @Query( "SELECT c "
            + "FROM Cours c "
            + "WHERE c.professeur = ?1 "
            + "AND c.classe = ?2 "
            + "ORDER BY c.heureCours.jour ASC, c.heureCours.heureDebut ASC" )
    List<Cours> findByProfesseurAndClasse( Professeur professeur, Classe classe );

    @Query( "SELECT DISTINCT c.classe "
            + "FROM Cours c "
            + "WHERE c.professeur = ?1 " )
    List<Classe> findClasseByProfesseur( Professeur professeur );
}
