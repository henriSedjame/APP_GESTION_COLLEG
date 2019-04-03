package com.shj.app.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.shj.app.entities.Classe;
import com.shj.app.entities.Cours;
import com.shj.app.entities.Eleve;
import com.shj.app.entities.Professeur;
import com.shj.app.service.EspaceProfService;

@Controller
@SessionAttributes( { "prof", "nom", "prenom", "classes" } )
public class EspaceProfController {

    // INJECTION DES SERVICES
    @Autowired
    EspaceProfService           espaceProfService;

    // VUES
    private static final String VUE_ESPACE_PROF_EMPLOI_DU_TEMPS        = "emploiDuTemps";
    private static final String VUE_ESPACE_PROF_EMPLOI_DU_TEMPS_CLASSE = "emploiDuTempsClasse";
    private static final String VUE_ESPACE_PROF_PROFIL                 = "profilProf";
    private static final String VUE_ESPACE_PROF                        = "espaceProf";
    private static final String VUE_ESPACE_PROF_CLASSES                = "classes";
    private static final String VUE_ESPACE_PROF_PROFIL_ELEVE           = "espaceProfProfilEleve";

    @GetMapping( "/profil" )
    public String afficherProfil() {
        return VUE_ESPACE_PROF_PROFIL;
    }

    @GetMapping( "/espace_utilisateur" )
    public String retourEspaceProf() {

        return VUE_ESPACE_PROF;

    }

    @GetMapping( "/emploi_du_temps" )
    public String afficherEmploiDuTemps( @SessionAttribute( "prof" ) Professeur prof, Model model ) {

        List<Cours> planningCours = espaceProfService
                .afficherEmploiDuTemps( espaceProfService.trouverProf( prof.getId() ) );

        List<Classe> classes = espaceProfService.trouverClasses( prof );

        model.addAttribute( "planning", planningCours );
        model.addAttribute( "classes", classes );

        return VUE_ESPACE_PROF_EMPLOI_DU_TEMPS;
    }

    @GetMapping( "/emploi_du_temps_{id}" )
    public String afficherEmploiDuTempsClasse( @PathVariable( "id" ) Long id,
            @SessionAttribute( "prof" ) Professeur prof,
            Model model ) {

        Classe classe = espaceProfService.trouverClasse( id );

        List<Cours> planningCoursClasse = espaceProfService
                .afficherEmploiDuTempsParClasse( prof, classe );

        List<Classe> classes = espaceProfService.trouverClasses( prof );

        model.addAttribute( "planningClasse", planningCoursClasse );
        model.addAttribute( "classes", classes );
        model.addAttribute( "classe", classe );

        return VUE_ESPACE_PROF_EMPLOI_DU_TEMPS_CLASSE;
    }

    @GetMapping( "/classes" )
    public String afficherClasse( @SessionAttribute( "prof" ) Professeur prof, Model model ) {

        List<Classe> classes = espaceProfService.trouverClasses( prof );

        Map<Classe, List<Eleve>> listEleve = new HashMap<>();

        for ( Classe classe : classes ) {
            List<Eleve> list = espaceProfService.afficherEleveParClasse( classe );
            listEleve.put( classe, list );
        }

        model.addAttribute( "classes", classes );
        model.addAttribute( "eleves", listEleve );

        return VUE_ESPACE_PROF_CLASSES;
    }

    @GetMapping( "/profil_eleve_{num}" )
    public String profilEleve( @PathVariable( "num" ) String numEleve, Model model ) {

        Eleve eleve = espaceProfService.trouverEleve( numEleve );

        model.addAttribute( "eleve", eleve );

        return VUE_ESPACE_PROF_PROFIL_ELEVE;
    }

}
