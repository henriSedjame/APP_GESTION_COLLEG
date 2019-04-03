package com.shj.app.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shj.app.entities.Classe;
import com.shj.app.entities.Identite;
import com.shj.app.entities.Matiere;
import com.shj.app.entities.Professeur;

@Repository
@Transactional
public class ProfesseurDaoImpl implements ProfesseurDao {

    @Autowired
    ProfesseurRepository professeurRepository;

    @Autowired
    ClasseRepository     classeRepository;

    @Override
    public Professeur create( Professeur t ) {
        return professeurRepository.saveAndFlush( t );
    }

    @Override
    public Professeur update( Professeur t ) {

        Professeur professeur = professeurRepository.findOne( t.getId() );
        professeur.setIdentite( t.getIdentite() );
        professeur.setListClasse( t.getListClasse() );
        professeur.setListCours( t.getListCours() );
        professeur.setMatiere( t.getMatiere() );
        professeur.setNumPersonnel( t.getNumPersonnel() );
        professeur.setPoste( t.getPoste() );
        return professeurRepository.save( professeur );
    }

    @Override
    public Professeur find( Long s ) {

        return professeurRepository.findOne( s );
    }

    @Override
    public List<Professeur> findAll() {

        return professeurRepository.findAll();
    }

    @Override
    public boolean delete( Professeur t ) {
        professeurRepository.delete( professeurRepository.findOne( t.getId() ) );
        return true;
    }

    @Override
    public Professeur findByLoginAndMotDePasse( String login, String motDePasse ) {

        return professeurRepository.findByLoginAndMotDePasse( login, motDePasse );
    }

    @Override
    public List<Professeur> findByNom( String nom ) {

        return professeurRepository.findByNom( nom );
    }

    @Override
    public Professeur findByNomAndPrenom( String nom, String prenom ) {

        return professeurRepository.findByNomAndPrenom( nom, prenom );
    }

    @Override
    public List<Professeur> findByMatiere( Matiere matiere ) {

        return professeurRepository.findByMatiere( matiere );
    }

    @Override
    public Professeur findByNumPersonnel( String numPersonnel ) {

        return professeurRepository.findByNumPersonnel( numPersonnel );
    }

    @Override
    public Professeur findByIdentite( Identite identite ) {

        return professeurRepository.findByIdentite( identite );
    }

    @Override
    public List<Professeur> findByClasse( Classe classe ) {

        return (List<Professeur>) classeRepository.findOne( classe.getId() ).getListProfesseur();
    }

}
