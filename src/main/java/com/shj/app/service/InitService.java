package com.shj.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shj.app.dao.AdministratifDao;
import com.shj.app.dao.ClasseDao;
import com.shj.app.dao.CoursDao;
import com.shj.app.dao.EleveDao;
import com.shj.app.dao.IdentifiantDao;
import com.shj.app.dao.IdentiteDao;
import com.shj.app.dao.PersonnelDao;
import com.shj.app.dao.ProfesseurDao;
import com.shj.app.dao.SalleDao;
import com.shj.app.entities.Administratif;
import com.shj.app.entities.Adresse;
import com.shj.app.entities.Civilite;
import com.shj.app.entities.Classe;
import com.shj.app.entities.Cours;
import com.shj.app.entities.HeureCours;
import com.shj.app.entities.Identifiant;
import com.shj.app.entities.Identite;
import com.shj.app.entities.Jour;
import com.shj.app.entities.Matiere;
import com.shj.app.entities.Niveau;
import com.shj.app.entities.PosteAdmin;
import com.shj.app.entities.Professeur;
import com.shj.app.entities.Salle;

@Service
public class InitService {

    // INJECTION DES DAO
    @Autowired
    ClasseDao        classeDao;
    @Autowired
    CoursDao         coursDao;
    @Autowired
    EleveDao         eleveDao;
    @Autowired
    ProfesseurDao    professeurDao;
    @Autowired
    SalleDao         salleDao;
    @Autowired
    IdentiteDao      identiteDao;
    @Autowired
    AdministratifDao administratifDao;
    @Autowired
    PersonnelDao     personnelDao;
    @Autowired
    IdentifiantDao   identifiantDao;

    @PostConstruct
    public void init() throws ParseException {
        // INSTANCIATION DES ENTITES

        SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
        SimpleDateFormat sdf2 = new SimpleDateFormat( "HH:mm" );

        Date hD1 = sdf2.parse( "08:00" );
        Date hD2 = sdf2.parse( "10:00" );
        Date hD3 = sdf2.parse( "12:00" );
        Date hD4 = sdf2.parse( "14:00" );
        Date hD5 = sdf2.parse( "16:00" );

        Classe sixieme = new Classe( Niveau.N_6EME );
        Classe cinquieme = new Classe( Niveau.N_5EME );
        Classe quatrieme = new Classe( Niveau.N_4EME );
        Classe troisieme = new Classe( Niveau.N_3EME );

        Adresse adresse1 = new Adresse( "18 impasse des Coquelicots",
                "33000", "Bordeaux" );
        Adresse adresse2 = new Adresse( "69 bis rue des Etables", "33000",
                "Bordeaux" );
        Adresse adresse3 = new Adresse( "12 boulevard des pois casses",
                "33000", "Bordeaux" );
        Adresse adresse4 = new Adresse( "27 rue des couleurs fleuries",
                "33000", "Bordeaux" );
        Adresse adresse5 = new Adresse( "33 rue des cloches", "33000",
                "Bordeaux" );
        Adresse adresse6 = new Adresse( "29 allee du pre vert", "33000",
                "Bordeaux" );
        Adresse adresse7 = new Adresse( "14 rue David Charvey", "33000",
                "Bordeaux" );
        Adresse adresse8 = new Adresse( "27 allee des jolies filles",
                "33000", "Bordeaux" );
        Adresse adresse9 = new Adresse( "24 rue des regards de braise",
                "33000", "Bordeaux" );
        Adresse adresse10 = new Adresse( "13 rue des tulipes", "33000",
                "Bordeaux" );
        Adresse adresse11 = new Adresse( "08 boulevard des grands pieds",
                "33000", "Bordeaux" );
        Adresse adresse12 = new Adresse( "28 faubourg des gros yeux",
                "33000", "Bordeaux" );
        Adresse adresse13 = new Adresse( "07 rue de la vallee", "33000",
                "Bordeaux" );
        Adresse adresse14 = new Adresse( "10 rue des poilus", "33000",
                "Bordeaux" );

        Identifiant id1 = new Identifiant( "AAlpha", "Aa!800502" );
        Identifiant id2 = new Identifiant( "AOmega", "Ao!790718" );
        Identifiant id3 = new Identifiant( "GMoustachu", "Gm!720914" );
        Identifiant id4 = new Identifiant( "PHero", "Ph!840112" );
        Identifiant id5 = new Identifiant( "EBardouin", "Eb!650221" );
        Identifiant id6 = new Identifiant( "AProton", "Ap!791112" );
        Identifiant id7 = new Identifiant( "EEffort", "Ee!670514" );
        Identifiant id8 = new Identifiant( "AManche", "Am!860621" );
        Identifiant id9 = new Identifiant( "VCarto", "Vc!970101" );
        Identifiant id10 = new Identifiant( "AWatson", "Aw!590502" );
        Identifiant id11 = new Identifiant( "CVoltaire", "Cv!920225" );
        Identifiant id12 = new Identifiant( "JPSherlock", "JPs!820427" );
        Identifiant id13 = new Identifiant( "MAbecedaire", "Ma!891024" );
        Identifiant id14 = new Identifiant( "APetitPapier", "Ap!650704" );

        Identite alaisId = new Identite( Civilite.MME, "Alais", "Alpha",
                sdf.parse( "02/05/1980" ), adresse1, id1 );
        Identite omegaId = new Identite( Civilite.MR, "Omega", "aristide",
                sdf.parse( "18/07/1979 " ), adresse2, id2 );
        Identite moustId = new Identite( Civilite.MME, "Moustachu",
                "Genevieve", sdf.parse( "14/09/1972" ), adresse3, id3 );
        Identite heroId = new Identite( Civilite.MR, "Hero", "Patrick",
                sdf.parse( "12/01/1984" ), adresse4, id4 );
        Identite bardoinId = new Identite( Civilite.MR, "Bardoin", "Elias",
                sdf.parse( "21/02/1965" ), adresse5, id5 );
        Identite protonId = new Identite( Civilite.MR, "Proton", "Ali",
                sdf.parse( "12/11/1979" ), adresse6, id6 );
        Identite effortId = new Identite( Civilite.MME, "Effort", "Elea",
                sdf.parse( "14/05/1967" ), adresse7, id7 );
        Identite mancheId = new Identite( Civilite.MME, "Manche", "Ambroise",
                sdf.parse( "21/06/1986" ), adresse8, id8 );
        Identite cartoId = new Identite( Civilite.MME, "Carto", "Victoria",
                sdf.parse( "01/01/1997" ), adresse9, id9 );
        Identite watsonId = new Identite( Civilite.MME, "Watson",
                "Angelique", sdf.parse( "02/05/1959" ), adresse10, id10 );
        Identite voltaireId = new Identite( Civilite.MME, "Voltaire",
                "christelle", sdf.parse( "25/02/1992" ),
                adresse11, id11 );
        Identite sherlockId = new Identite( Civilite.MR, "Sherlock",
                "Jean-Philippe", sdf.parse( "27/04/1982" ),
                adresse12, id12 );
        Identite abeceId = new Identite( Civilite.MR, "Abecedaire", "Maxime",
                sdf.parse( "24/10/1989" ), adresse13, id13 );
        Identite petitPId = new Identite( Civilite.MLLE, "Petit-Papier",
                "Adelaide", sdf.parse( "04/07/1965" ),
                adresse14, id14 );

        Professeur alphaProf = new Professeur( "AA8005",
                PosteAdmin.Professeur, alaisId, Matiere.Maths );
        Professeur aristideProf = new Professeur( "AO7907",
                PosteAdmin.Professeur, omegaId, Matiere.Maths );
        Professeur genProf = new Professeur( "GM7209", PosteAdmin.Professeur,
                moustId, Matiere.SVT );
        Professeur patrickProf = new Professeur( "PH8401",
                PosteAdmin.Professeur, heroId, Matiere.SVT );
        Professeur eliasProf = new Professeur( "EB6502",
                PosteAdmin.Professeur, bardoinId, Matiere.PC );
        Professeur aliProf = new Professeur( "AP7911", PosteAdmin.Professeur,
                protonId, Matiere.PC );
        Professeur eleaProf = new Professeur( "EE6705",
                PosteAdmin.Professeur, effortId, Matiere.Sport );
        Professeur ambroiseProf = new Professeur( "AM8606",
                PosteAdmin.Professeur, mancheId, Matiere.HG );
        Professeur victoriaProf = new Professeur( "VC9701",
                PosteAdmin.Professeur, cartoId, Matiere.HG );
        Professeur angelProf = new Professeur( "AW5905",
                PosteAdmin.Professeur, watsonId, Matiere.Anglais );
        Professeur christelleProf = new Professeur( "CV9202",
                PosteAdmin.Professeur, voltaireId, Matiere.Français );
        Professeur jpProf = new Professeur( "JP8204", PosteAdmin.Professeur,
                sherlockId, Matiere.Anglais );
        Professeur maximeProf = new Professeur( "MA8910",
                PosteAdmin.Directeur, abeceId, Matiere.Français );
        Administratif adelaAdmin = new Administratif( "AP6507",
                PosteAdmin.Secretaire, petitPId );

        HeureCours hcL1 = new HeureCours( Jour.J1, hD1, hD2 );
        HeureCours hcL2 = new HeureCours( Jour.J1, hD2, hD3 );
        HeureCours hcL3 = new HeureCours( Jour.J1, hD4, hD5 );
        HeureCours hcMa1 = new HeureCours( Jour.J2, hD1, hD2 );
        HeureCours hcMa2 = new HeureCours( Jour.J2, hD2, hD3 );
        HeureCours hcMa3 = new HeureCours( Jour.J2, hD4, hD5 );
        HeureCours hcMe1 = new HeureCours( Jour.J3, hD1, hD2 );
        HeureCours hcMe2 = new HeureCours( Jour.J3, hD2, hD3 );
        HeureCours hcMe3 = new HeureCours( Jour.J3, hD4, hD5 );
        HeureCours hcJ1 = new HeureCours( Jour.J4, hD1, hD2 );
        HeureCours hcJ2 = new HeureCours( Jour.J4, hD2, hD3 );
        HeureCours hcJ3 = new HeureCours( Jour.J4, hD4, hD5 );
        HeureCours hcV1 = new HeureCours( Jour.J5, hD1, hD2 );
        HeureCours hcV2 = new HeureCours( Jour.J5, hD2, hD3 );
        HeureCours hcV3 = new HeureCours( Jour.J5, hD4, hD5 );

        Salle salle1 = new Salle( "S01", 20 );
        Salle salle2 = new Salle( "S02", 20 );
        Salle salle3 = new Salle( "S03", 20 );
        Salle salle4 = new Salle( "S04", 20 );

        Cours cFr6eL1 = new Cours( "FR6.1", christelleProf, sixieme, hcL1, salle1 );
        Cours cFr6eJ3 = new Cours( "FR6.2", christelleProf, sixieme, hcJ3, salle1 );
        Cours cFr6eV2 = new Cours( "FR6.3", christelleProf, sixieme, hcV2, salle1 );

        Cours cMaths6eL2 = new Cours( "M6.1", alphaProf, sixieme, hcL2, salle1 );
        Cours cMaths6eMa3 = new Cours( "M6.2", alphaProf, sixieme, hcMa3, salle1 );
        Cours cMaths6eV1 = new Cours( "M6.3", alphaProf, sixieme, hcV1, salle1 );

        Cours cSVT6eMa2 = new Cours( "SVT6.1", genProf, sixieme, hcMa2, salle1 );
        Cours cSVT6eMe1 = new Cours( "SVT6.2", genProf, sixieme, hcMe1, salle1 );

        Cours cPC6eL3 = new Cours( "PC6.1", eliasProf, sixieme, hcL3, salle1 );
        Cours cPC6eMa1 = new Cours( "PC6.2", eliasProf, sixieme, hcMa1, salle1 );

        Cours coursSport6e = new Cours( "SP6.1", eleaProf, sixieme, hcMe3, salle1 );

        Cours cHG6eJ1 = new Cours( "HG6.1", ambroiseProf, sixieme, hcJ1, salle1 );
        Cours cHG6eV3 = new Cours( "HG6.2", ambroiseProf, sixieme, hcV3, salle1 );

        Cours cAng6eMe2 = new Cours( "ANG6.1", angelProf, sixieme, hcMe2, salle1 );
        Cours cAng6eJ2 = new Cours( "ANG6.2", angelProf, sixieme, hcJ2, salle1 );

        Cours cFr5eL1 = new Cours( "FR5.1", maximeProf, cinquieme, hcL1, salle2 );
        Cours cFr5eMa2 = new Cours( "FR5.2", maximeProf, cinquieme, hcMa2, salle2 );
        Cours cFr5eJ2 = new Cours( "FR5.3", maximeProf, cinquieme, hcJ2, salle2 );

        Cours cMaths5eL2 = new Cours( "M5.1", aristideProf, cinquieme, hcL2, salle2 );
        Cours cMaths5eJ1 = new Cours( "M5.2", aristideProf, cinquieme, hcJ1, salle2 );
        Cours cMaths5eV2 = new Cours( "M5.3", aristideProf, cinquieme, hcV2, salle2 );

        Cours cSVT5eMa3 = new Cours( "SVT5.1", patrickProf, cinquieme, hcMa3, salle2 );
        Cours cSVT5eV3 = new Cours( "SVT5.2", patrickProf, cinquieme, hcV3, salle2 );

        Cours cPC5eL3 = new Cours( "PC5.1", aliProf, cinquieme, hcL3, salle2 );
        Cours cPC5eV1 = new Cours( "PC5.2", aliProf, cinquieme, hcV1, salle2 );

        Cours cSport5eMe2 = new Cours( "SP5.1", eleaProf, cinquieme, hcMe2, salle2 );

        Cours cHG5eMe1 = new Cours( "HG5.1", victoriaProf, cinquieme, hcMe1, salle2 );
        Cours cHG5eJ3 = new Cours( "HG5.2", victoriaProf, cinquieme, hcJ3, salle2 );

        Cours cAng5eMa1 = new Cours( "ANG5.1", jpProf, cinquieme, hcMa1, salle2 );
        Cours cAng5eMe3 = new Cours( "ANG5.2", jpProf, cinquieme, hcMe3, salle2 );

        Cours cFr4eL2 = new Cours( "FR4.1", christelleProf, quatrieme, hcL2, salle3 );
        Cours cFr4eMa3 = new Cours( "FR4.2", christelleProf, quatrieme, hcMa3, salle3 );
        Cours cFr4eV1 = new Cours( "FR4.3", christelleProf, quatrieme, hcV1, salle3 );

        Cours cMaths4eL1 = new Cours( "M4.1", alphaProf, quatrieme, hcL1, salle3 );
        Cours cMaths4eJ3 = new Cours( "M4.2", alphaProf, quatrieme, hcJ3, salle3 );
        Cours cMaths4eV2 = new Cours( "M4.3", alphaProf, quatrieme, hcV2, salle3 );

        Cours cSVT4eL3 = new Cours( "SVT4.1", genProf, quatrieme, hcL3, salle3 );
        Cours cSVT4eMa1 = new Cours( "SVT4.2", genProf, quatrieme, hcMa1, salle3 );

        Cours cPC4eMa2 = new Cours( "PC4.1", eliasProf, quatrieme, hcMa2, salle3 );
        Cours cPC4eMe3 = new Cours( "PC4.2", eliasProf, quatrieme, hcMe3, salle3 );

        Cours cSport4eMe1 = new Cours( "SP4.1", eleaProf, quatrieme, hcMe1, salle3 );

        Cours cHG4eMe2 = new Cours( "HG4.1", ambroiseProf, quatrieme, hcMe2, salle3 );
        Cours cHG4eJ2 = new Cours( "HG4.2", ambroiseProf, quatrieme, hcJ2, salle3 );

        Cours cAng4eJ1 = new Cours( "ANG4.1", angelProf, quatrieme, hcJ1, salle3 );
        Cours cAng4eV3 = new Cours( "ANG4.2", angelProf, quatrieme, hcV3, salle3 );

        Cours cFr3eL2 = new Cours( "FR3.1", maximeProf, troisieme, hcL2, salle4 );
        Cours cFr3eJ1 = new Cours( "FR3.2", maximeProf, troisieme, hcJ1, salle4 );
        Cours cFr3eV2 = new Cours( "FR3.3", maximeProf, troisieme, hcV2, salle4 );

        Cours cMaths3eL1 = new Cours( "M3.1", aristideProf, troisieme, hcL1, salle4 );
        Cours cMaths3eMa2 = new Cours( "M3.2", aristideProf, troisieme, hcMa2, salle4 );
        Cours cMaths3eJ2 = new Cours( "M3.3", aristideProf, troisieme, hcJ2, salle4 );

        Cours cSVT3eL3 = new Cours( "SVT3.1", patrickProf, troisieme, hcL3, salle4 );

        Cours cPC3eMa3 = new Cours( "PC3.1", aliProf, troisieme, hcMa3, salle4 );

        Cours cSport3eV3 = new Cours( "SP3.1", eleaProf, troisieme, hcV3, salle4 );

        Cours cHG3eMa1 = new Cours( "HG3.1", victoriaProf, troisieme, hcMa1, salle4 );
        Cours cHG3eMe3 = new Cours( "HG3.2", victoriaProf, troisieme, hcMe3, salle4 );
        Cours cHG3eJ3 = new Cours( "HG3.3", victoriaProf, troisieme, hcJ3, salle4 );

        Cours cAng3eMe1 = new Cours( "ANG3.1", jpProf, troisieme, hcMe1, salle4 );
        Cours cAng3eMe2 = new Cours( "ANG3.2", jpProf, troisieme, hcMe2, salle4 );
        Cours cAng3eV1 = new Cours( "ANG3.3", jpProf, troisieme, hcV1, salle4 );

        // INSERTION DES ENTITES

        // identifiantDao.create( id1 );
        // identifiantDao.create( id2 );
        // identifiantDao.create( id3 );
        // identifiantDao.create( id4 );
        // identifiantDao.create( id5 );
        // identifiantDao.create( id6 );
        // identifiantDao.create( id7 );
        // identifiantDao.create( id8 );
        // identifiantDao.create( id9 );
        // identifiantDao.create( id10 );
        // identifiantDao.create( id11 );
        // identifiantDao.create( id12 );
        // identifiantDao.create( id13 );
        // identifiantDao.create( id14 );
        //
        // identiteDao.create( alaisId );
        // identiteDao.create( omegaId );
        // identiteDao.create( moustId );
        // identiteDao.create( heroId );
        // identiteDao.create( bardoinId );
        // identiteDao.create( protonId );
        // identiteDao.create( effortId );
        // identiteDao.create( mancheId );
        // identiteDao.create( cartoId );
        // identiteDao.create( sherlockId );
        // identiteDao.create( voltaireId );
        // identiteDao.create( watsonId );
        // identiteDao.create( abeceId );
        // identiteDao.create( petitPId );

        professeurDao.create( alphaProf );
        professeurDao.create( aristideProf );
        professeurDao.create( genProf );
        professeurDao.create( patrickProf );
        professeurDao.create( eliasProf );
        professeurDao.create( aliProf );
        professeurDao.create( eleaProf );
        professeurDao.create( ambroiseProf );
        professeurDao.create( victoriaProf );
        professeurDao.create( angelProf );
        professeurDao.create( christelleProf );
        professeurDao.create( jpProf );
        professeurDao.create( maximeProf );

        administratifDao.create( adelaAdmin );

        salleDao.create( salle1 );
        salleDao.create( salle2 );
        salleDao.create( salle3 );
        salleDao.create( salle4 );

        classeDao.create( sixieme );
        classeDao.create( cinquieme );
        classeDao.create( quatrieme );
        classeDao.create( troisieme );

        coursDao.create( cFr6eL1 );
        coursDao.create( cFr6eJ3 );
        coursDao.create( cFr6eV2 );

        coursDao.create( cMaths6eL2 );
        coursDao.create( cMaths6eMa3 );
        coursDao.create( cMaths6eV1 );

        coursDao.create( cSVT6eMa2 );
        coursDao.create( cSVT6eMe1 );

        coursDao.create( cPC6eL3 );
        coursDao.create( cPC6eMa1 );

        coursDao.create( coursSport6e );

        coursDao.create( cHG6eJ1 );
        coursDao.create( cHG6eV3 );

        coursDao.create( cAng6eMe2 );
        coursDao.create( cAng6eJ2 );

        coursDao.create( cFr5eL1 );
        coursDao.create( cFr5eMa2 );
        coursDao.create( cFr5eJ2 );

        coursDao.create( cMaths5eL2 );
        coursDao.create( cMaths5eJ1 );
        coursDao.create( cMaths5eV2 );

        coursDao.create( cSVT5eMa3 );
        coursDao.create( cSVT5eV3 );

        coursDao.create( cPC5eL3 );
        coursDao.create( cPC5eV1 );

        coursDao.create( cSport5eMe2 );

        coursDao.create( cHG5eMe1 );
        coursDao.create( cHG5eJ3 );

        coursDao.create( cAng5eMa1 );
        coursDao.create( cAng5eMe3 );

        coursDao.create( cFr4eL2 );
        coursDao.create( cFr4eMa3 );
        coursDao.create( cFr4eV1 );

        coursDao.create( cMaths4eL1 );
        coursDao.create( cMaths4eJ3 );
        coursDao.create( cMaths4eV2 );

        coursDao.create( cSVT4eL3 );
        coursDao.create( cSVT4eMa1 );

        coursDao.create( cPC4eMa2 );
        coursDao.create( cPC4eMe3 );

        coursDao.create( cSport4eMe1 );

        coursDao.create( cHG4eMe2 );
        coursDao.create( cHG4eJ2 );

        coursDao.create( cAng4eJ1 );
        coursDao.create( cAng4eV3 );

        coursDao.create( cFr3eL2 );
        coursDao.create( cFr3eJ1 );
        coursDao.create( cFr3eV2 );

        coursDao.create( cMaths3eL1 );
        coursDao.create( cMaths3eMa2 );
        coursDao.create( cMaths3eJ2 );

        coursDao.create( cSVT3eL3 );

        coursDao.create( cPC3eMa3 );

        coursDao.create( cSport3eV3 );

        coursDao.create( cHG3eMa1 );
        coursDao.create( cHG3eMe3 );
        coursDao.create( cHG3eJ3 );

        coursDao.create( cAng3eMe1 );
        coursDao.create( cAng3eMe2 );
        coursDao.create( cAng3eV1 );

        alphaProf.getListClasse().add( sixieme );
        alphaProf.getListClasse().add( quatrieme );

        christelleProf.getListClasse().add( sixieme );
        christelleProf.getListClasse().add( quatrieme );

        genProf.getListClasse().add( sixieme );
        genProf.getListClasse().add( quatrieme );

        eliasProf.getListClasse().add( sixieme );
        eliasProf.getListClasse().add( quatrieme );

        eleaProf.getListClasse().add( sixieme );
        eleaProf.getListClasse().add( cinquieme );
        eleaProf.getListClasse().add( quatrieme );
        eleaProf.getListClasse().add( troisieme );

        ambroiseProf.getListClasse().add( sixieme );
        ambroiseProf.getListClasse().add( quatrieme );

        angelProf.getListClasse().add( sixieme );
        angelProf.getListClasse().add( quatrieme );

        maximeProf.getListClasse().add( cinquieme );
        maximeProf.getListClasse().add( troisieme );

        aristideProf.getListClasse().add( cinquieme );
        aristideProf.getListClasse().add( troisieme );

        patrickProf.getListClasse().add( cinquieme );
        patrickProf.getListClasse().add( troisieme );

        aliProf.getListClasse().add( cinquieme );
        aliProf.getListClasse().add( troisieme );

        victoriaProf.getListClasse().add( cinquieme );
        victoriaProf.getListClasse().add( troisieme );

        jpProf.getListClasse().add( cinquieme );
        jpProf.getListClasse().add( troisieme );

        professeurDao.update( alphaProf );
        professeurDao.update( christelleProf );
        professeurDao.update( genProf );
        professeurDao.update( eliasProf );
        professeurDao.update( eleaProf );
        professeurDao.update( ambroiseProf );
        professeurDao.update( angelProf );
        professeurDao.update( maximeProf );
        professeurDao.update( aristideProf );
        professeurDao.update( patrickProf );
        professeurDao.update( aliProf );
        professeurDao.update( victoriaProf );
        professeurDao.update( jpProf );

    }

}
