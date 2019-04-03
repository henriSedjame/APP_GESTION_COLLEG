package com.shj.app.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.shj.app.entities.Adresse;
import com.shj.app.entities.Civilite;
import com.shj.app.entities.Classe;
import com.shj.app.entities.Eleve;
import com.shj.app.entities.Identifiant;
import com.shj.app.entities.Identite;
import com.shj.app.entities.Niveau;
import com.shj.app.exceptions.IdentiteExistantException;
import com.shj.app.service.AdminService;

@Controller
public class EspaceAdminController {

    // INJECTIONS
    @Autowired
    AdminService                adminService;

    // VIEWS
    private static final String VUE_AJOUT_IDENTITE_ELEVE    = "ajoutIdentiteEleve";
    private static final String VUE_AJOUT_ADRESSE_ELEVE     = "ajoutAdresseEleve";
    private static final String VUE_AJOUT_IDENTIFIANT_ELEVE = "ajoutIdentifiantEleve";
    private static final String VUE_AJOUT_NUM_ELEVE         = "ajoutNumEleve";
    private static final String VUE_AJOUT_CLASSE_ELEVE      = "ajoutClasseEleve";
    private static final String VUE_AJOUT_ELEVE_SUCCES      = "ajoutEleveSucces";

    // MODEL ATTRIBUTES
    private static final String ATT_IDENTITE                = "new_eleve_identite";
    private static final String ATT_ADRESSE                 = "new_eleve_adresse";
    private static final String ATT_ELEVE                   = "new_eleve";
    private static final String ATT_CLASSE                  = "new_eleve_classe";
    private static final String ATT_IDENTIFIANT             = "new_eleve_identifiant";
    private static final String ATT_CIVILITES               = "civilites";
    private static final String ATT_NIVEAUX                 = "niveaux";

    @InitBinder
    public void initBinder( WebDataBinder binder ) {
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
        binder.registerCustomEditor( Date.class, "dateNaissance", new CustomDateEditor( sdf, false ) );
    }

    @ModelAttribute
    public void postAfficherIdentiteForm( Model model ) {

        model.addAttribute( ATT_IDENTITE, new Identite() );
        model.addAttribute( ATT_CIVILITES, Civilite.values() );
        model.addAttribute( ATT_NIVEAUX, Niveau.values() );

    }

    @GetMapping( "/identiteForm" )
    public String afficherIdentiteForm( Model model ) {

        model.addAttribute( ATT_ADRESSE, new Adresse() );

        return VUE_AJOUT_IDENTITE_ELEVE;
    }

    @PostMapping( "/adresseForm" )
    public String afficherAdresseForm( @Valid @ModelAttribute( ATT_IDENTITE ) Identite identite, BindingResult result,
            Model model, HttpServletRequest req ) throws IdentiteExistantException {

        if ( result.hasErrors() ) {
            return VUE_AJOUT_IDENTITE_ELEVE;
        } else {

            if ( adminService.verifierIdentite( identite ) != null ) {
                result.addError( new ObjectError( "identiteError", "L'identite existe deja !" ) );
                model.addAttribute( "errors", result.getAllErrors() );
                return VUE_AJOUT_IDENTITE_ELEVE;
            } else {
                identite = adminService.ajouterIdentite( identite, req );

                System.out.println( identite.getNom() );

                HttpSession session = req.getSession();
                session.setAttribute( ATT_IDENTITE, identite );

                model.addAttribute( ATT_IDENTIFIANT, new Identifiant() );

                return VUE_AJOUT_ADRESSE_ELEVE;
            }

        }

    }

    @PostMapping( "/identifiantForm" )
    public String afficherIdentifantForm( @Valid @ModelAttribute( ATT_ADRESSE ) Adresse adresse, BindingResult result,
            Model model, HttpServletRequest req ) {

        if ( result.hasErrors() ) {
            return VUE_AJOUT_ADRESSE_ELEVE;
        } else {

            HttpSession session = req.getSession();
            Identite identite = (Identite) session.getAttribute( ATT_IDENTITE );
            identite.setAdresse( adresse );
            session.setAttribute( ATT_IDENTITE, identite );
            adminService.mettreAJour( identite );

            model.addAttribute( ATT_CLASSE, new Classe() );

            return VUE_AJOUT_IDENTIFIANT_ELEVE;
        }

    }

    @PostMapping( "/classeForm" )
    public String afficherClasseForm( @Valid @ModelAttribute( ATT_IDENTIFIANT ) Identifiant identifiant,
            BindingResult result,
            Model model, HttpServletRequest req ) {

        if ( result.hasErrors() ) {
            return VUE_AJOUT_IDENTIFIANT_ELEVE;
        } else {

            if ( adminService.verifierLogin( identifiant ) != null ) {
                result.addError( new ObjectError( "identifiantError",
                        "Le login choisi est dejà utilisé. Veuillez en choisir un autre !" ) );
                model.addAttribute( "errors", result.getAllErrors() );
                return VUE_AJOUT_IDENTIFIANT_ELEVE;
            } else {
                identifiant = adminService.ajouterIdentifiant( identifiant );

                HttpSession session = req.getSession();
                Identite identite = (Identite) session.getAttribute( ATT_IDENTITE );
                identite.setIdentifiant( identifiant );
                session.setAttribute( ATT_IDENTITE, identite );
                adminService.mettreAJour( identite );

                return VUE_AJOUT_CLASSE_ELEVE;
            }

        }

    }

    @PostMapping( "/eleveForm" )
    public String afficherEleveForm( @Valid @ModelAttribute( ATT_CLASSE ) Classe classe, BindingResult result,
            Model model, HttpServletRequest req ) {
        if ( result.hasErrors() ) {
            return VUE_AJOUT_CLASSE_ELEVE;
        } else {
            HttpSession session = req.getSession();
            session.setAttribute( ATT_CLASSE, classe );

            model.addAttribute( ATT_ELEVE, new Eleve() );

            return VUE_AJOUT_NUM_ELEVE;
        }
    }

    @PostMapping( "/resultAjoutEleve" )
    public String finaliserAjoutEleve( @Valid @ModelAttribute( ATT_ELEVE ) Eleve eleve, BindingResult result,
            Model model, HttpServletRequest req ) {
        if ( result.hasErrors() ) {
            return VUE_AJOUT_NUM_ELEVE;
        } else {
            if ( adminService.verifierNumEleve( eleve ) != null ) {
                result.addError( new ObjectError( "eleveError",
                        "Le numéro Eleve que vous avez choisi a déjà été attribué. Veuillez en choisir un autre !" ) );
                model.addAttribute( "errors", result.getAllErrors() );
                return VUE_AJOUT_NUM_ELEVE;
            } else {
                HttpSession session = req.getSession();
                Identite identite = (Identite) session.getAttribute( ATT_IDENTITE );
                Classe classe = (Classe) session.getAttribute( ATT_CLASSE );

                adminService.ajouterEleve( eleve, classe, identite );

                return VUE_AJOUT_ELEVE_SUCCES;
            }

        }
    }
}
