package com.shj.app.dao;

import java.util.List;

import com.shj.app.entities.Classe;
import com.shj.app.entities.Cours;
import com.shj.app.entities.Professeur;

public interface CoursDao extends Dao<Cours, Long> {

    List<Cours> findByClasse( Classe classe );

    List<Cours> findByProfesseur( Professeur professeur );

    List<Cours> findByProfesseurAndClasse( Professeur professeur, Classe classe );

    List<Classe> findClasseByProfesseur( Professeur professeur );

}
