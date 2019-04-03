package com.shj.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shj.app.dao.ClasseDao;
import com.shj.app.dao.CoursDao;
import com.shj.app.dao.EleveDao;
import com.shj.app.dao.ProfesseurDao;
import com.shj.app.entities.Classe;
import com.shj.app.entities.Cours;
import com.shj.app.entities.Eleve;
import com.shj.app.entities.Professeur;

@Service
public class EspaceProfService {

    @Autowired
    ProfesseurDao professeurDao;
    @Autowired
    CoursDao      coursDao;
    @Autowired
    ClasseDao     classeDao;
    @Autowired
    EleveDao      eleveDao;

    public Professeur trouverProf( Long id ) {

        return professeurDao.find( id );
    }

    public List<Classe> trouverClasses( Professeur professeur ) {

        return coursDao.findClasseByProfesseur( professeur );
    }

    public List<Cours> afficherEmploiDuTemps( Professeur professeur ) {

        return coursDao.findByProfesseur( professeur );
    }

    public Classe trouverClasse( Long id ) {
        return classeDao.find( id );
    }

    public List<Cours> afficherEmploiDuTempsParClasse( Professeur professeur, Classe classe ) {

        return coursDao.findByProfesseurAndClasse( professeur, classe );
    }

    public List<Eleve> afficherEleveParClasse( Classe classe ) {

        return eleveDao.findByClasse( classe );
    }

    public Eleve trouverEleve( String numEleve ) {

        return eleveDao.findByNumEleve( numEleve );
    }

}
