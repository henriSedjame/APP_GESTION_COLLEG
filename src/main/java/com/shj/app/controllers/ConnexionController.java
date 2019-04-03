package com.shj.app.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.shj.app.entities.Administratif;
import com.shj.app.entities.Eleve;
import com.shj.app.entities.Identifiant;
import com.shj.app.entities.Professeur;
import com.shj.app.service.ConnexionService;
import com.shj.app.service.EspaceProfService;

@Controller
@SessionAttributes( { "identifiant", "eleve", "prof", "admin", "nom", "prenom" } )
public class ConnexionController {

    // INJECTION DES SERVICES
    @Autowired
    ConnexionService            connexionService;
    @Autowired
    EspaceProfService           espaceProfService;

    // VUES
    private static final String VUE_CONNEXION        = "connexion";
    private static final String VUE_ESPACE_PROF      = "espaceProf";
    private static final String VUE_ESPACE_ELEVE     = "espaceEleve";
    private static final String VUE_ESPACE_ADMIN     = "espaceAdmin";
    private static final String VUE_REDIRECTION_HOME = "redirect:/";

    private static final int    MAX_AGE              = 365 * 24 * 60 * 60;

    // STOCKER L'OBJET IDENTIFIANT QUI VA ETRE REMPLI AVEC LE FORMULAIRE

    @ModelAttribute
    public void seConnecter( Model model ) {
        Identifiant identifiant = new Identifiant();
        model.addAttribute( "identifiant", identifiant );

    }

    // METHODE APPELEE POUR SE CONNECTER

    @GetMapping( "/connexion" )
    public String seConnecter() {

        return VUE_CONNEXION;
    }

    // METHODE APPELEE LORS DE L'ENVOI DU FORMULAIRE
    
    @PostMapping( "/espace_utilisateur" )
    public String afficherEspaceProf( @ModelAttribute( "identifiant" ) Identifiant identifiant,
            HttpServletRequest request, HttpServletResponse response, Model model ) {

        identifiant = connexionService.verifierIdentifiants(
                identifiant.getLogin(), identifiant.getMotDePasse() );

        if ( identifiant == null ) {
            ObjectError error = new ObjectError( "errorIdentifiant",
                    "Identifiants incorrects, veuillez ressaisir vos identifiants." );
            model.addAttribute( "errorIdentifiant", error );
            return VUE_CONNEXION;
        } else {

            connexionService.ajouterCookie( request, response, MAX_AGE, identifiant.getLogin(),
                    identifiant.getMotDePasse() );

            model.addAttribute( "identifiant", identifiant );

            if ( identifiant.getIdentite().getEleve() != null ) {
                Eleve eleve = connexionService.trouverEleve( identifiant.getLogin(), identifiant.getMotDePasse() );
                model.addAttribute( "eleve", eleve );
                model.addAttribute( "nom", eleve.getIdentite().getNom().toUpperCase() );
                model.addAttribute( "prenom", eleve.getIdentite().getPrenom() );

                return VUE_ESPACE_ELEVE;

            } else if ( identifiant.getIdentite().getPersonnel() instanceof Professeur ) {
                Professeur prof = connexionService.trouverProf(
                        identifiant.getLogin(), identifiant.getMotDePasse() );
                model.addAttribute( "prof", prof );
                model.addAttribute( "nom", prof.getIdentite().getNom().toUpperCase() );
                model.addAttribute( "prenom", prof.getIdentite().getPrenom() );

                return VUE_ESPACE_PROF;

            } else if ( identifiant.getIdentite().getPersonnel() instanceof Administratif ) {
                Administratif admin = connexionService.trouverAdmin( identifiant.getLogin(),
                        identifiant.getMotDePasse() );
                model.addAttribute( "admin", admin );
                model.addAttribute( "nom", admin.getIdentite().getNom().toUpperCase() );
                model.addAttribute( "prenom", admin.getIdentite().getPrenom() );

                return VUE_ESPACE_ADMIN;
            } else {
                ObjectError error = new ObjectError( "errorIdentifiant",
                        "Un problème est survenu lors de la vérification de vos identifiants, veuillez réessayer ultérieurement." );
                model.addAttribute( "errorIdentifiant", error );

                return VUE_CONNEXION;
            }

        }

    }

    // METHODE APPELEE POUR SE DECONNECTER

    @GetMapping( "/deconnexion" )
    public String seDeconnecter( HttpServletRequest request ) {

        HttpSession session = request.getSession();
        session.invalidate();

        return VUE_REDIRECTION_HOME;
    }

}
