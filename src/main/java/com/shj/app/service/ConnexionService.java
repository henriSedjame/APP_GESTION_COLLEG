package com.shj.app.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shj.app.dao.AdministratifDao;
import com.shj.app.dao.EleveDao;
import com.shj.app.dao.IdentifiantDao;
import com.shj.app.dao.ProfesseurDao;
import com.shj.app.entities.Administratif;
import com.shj.app.entities.Eleve;
import com.shj.app.entities.Identifiant;
import com.shj.app.entities.Professeur;

@Service
public class ConnexionService {

    @Autowired
    IdentifiantDao   identifiantDao;
    @Autowired
    ProfesseurDao    professeurDao;
    @Autowired
    EleveDao         eleveDao;
    @Autowired
    AdministratifDao adminDao;

    public Identifiant verifierIdentifiants( String login, String motDePasse ) {

        Identifiant identifiant = identifiantDao.findIdentifiant( login, motDePasse );

        return identifiant;

    }

    public Eleve trouverEleve( String login, String motDePasse ) {

        return eleveDao.findByLoginAndMotDePasse( login, motDePasse );
    }

    public Professeur trouverProf( String login, String motDePasse ) {

        return professeurDao.findByLoginAndMotDePasse( login, motDePasse );
    }

    public Administratif trouverAdmin( String login, String motDePasse ) {

        return adminDao.findByLoginAndMotDePasse( login, motDePasse );
    }

    public Cookie ajouterCookie( HttpServletRequest req, HttpServletResponse rep, int maxAge, String login,
            String motDePasse ) {

        String memoire = req.getParameter( "memoire" );

        Cookie cookie = null;

        if ( memoire != null ) {
            cookie = new Cookie( login, motDePasse );
            cookie.setMaxAge( maxAge );
            rep.addCookie( cookie );
        }

        return cookie;
    }
}
