package com.shj.app.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shj.app.dao.ClasseDao;
import com.shj.app.dao.EleveDao;
import com.shj.app.dao.IdentifiantDao;
import com.shj.app.dao.IdentiteDao;
import com.shj.app.dao.ProfesseurDao;
import com.shj.app.entities.Classe;
import com.shj.app.entities.Eleve;
import com.shj.app.entities.Identifiant;
import com.shj.app.entities.Identite;
import com.shj.app.exceptions.IdentiteExistantException;

@Service
public class AdminService {

    // INJECTION
    @Autowired
    EleveDao       eleveDao;
    @Autowired
    ProfesseurDao  professeurDao;
    @Autowired
    IdentifiantDao identifiantDao;
    @Autowired
    IdentiteDao    identiteDao;
    @Autowired
    ClasseDao      classeDao;

    // METHODES DE VERIFICATION
    public Identite verifierIdentite( Identite identite ) {
        return identiteDao.findByNomAndPrenom( identite.getNom(), identite.getPrenom() );
    }

    public Identifiant verifierLogin( Identifiant identifiant ) {
        return identifiantDao.findByLogin( identifiant.getLogin() );
    }

    public Eleve verifierNumEleve( Eleve eleve ) {
        return eleveDao.findByNumEleve( eleve.getNumEleve() );
    }

    // METHODES D'AJOUT
    public Identite ajouterIdentite( Identite identite, HttpServletRequest req ) throws IdentiteExistantException {

        // checkIdentite( identite.getNom(), identite.getPrenom() );
        return identiteDao.create( identite );

    }

    public Identifiant ajouterIdentifiant( Identifiant identifiant ) {

        return identifiantDao.create( identifiant );
    }

    public void ajouterEleve( Eleve eleve, Classe classe, Identite identite ) {

        classe = classeDao.findByNiveau( classe.getNiveau() );
        identite = identiteDao.find( identite.getId() );
        eleve.setClasse( classe );
        eleve.setIdentite( identite );
        eleveDao.create( eleve );

    }

    public void mettreAJour( Identite identite ) {

        identiteDao.update( identite );

    }

}
