package com.shj.app.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shj.app.entities.Adresse;
import com.shj.app.entities.Identifiant;
import com.shj.app.entities.Identite;

@Repository
@Transactional
public class IdentiteDaoImpl implements IdentiteDao {

    @Autowired
    IdentiteRepository identiteRepository;

    @Override
    public Identite create( Identite t ) {
        return identiteRepository.saveAndFlush( t );
    }

    @Override
    public Identite update( Identite t ) {

        Identite identite = identiteRepository.findOne( t.getId() );

        identite.setAdresse( t.getAdresse() );
        identite.setCivilite( t.getCivilite() );
        identite.setDateNaissance( t.getDateNaissance() );
        identite.setEleve( t.getEleve() );
        identite.setIdentifiant( t.getIdentifiant() );
        identite.setNom( t.getNom() );
        identite.setPersonnel( t.getPersonnel() );
        identite.setPrenom( t.getPrenom() );

        return identiteRepository.save( identite );
    }

    @Override
    public Identite find( Long s ) {

        return identiteRepository.findOne( s );
    }

    @Override
    public List<Identite> findAll() {

        return identiteRepository.findAll();
    }

    @Override
    public boolean delete( Identite t ) {
        identiteRepository.delete( identiteRepository.findOne( t.getId() ) );
        return true;
    }

    @Override
    public Identite findByIdentifiant( Identifiant identifiant ) {

        return identiteRepository.findByIdentifiant( identifiant );
    }

    @Override
    public Identite findByNomAndPrenom( String nom, String prenom ) {

        return identiteRepository.findByNomAndPrenom( nom, prenom );
    }

    @Override
    public void updateAdresse( Adresse adresse, String nom, String prenom ) {
        identiteRepository.updateAdresse( adresse, nom, prenom );

    }

    @Override
    public void updateIdentifiant( Identifiant identifiant, String nom, String prenom ) {
        identiteRepository.updateIdentifiant( identifiant, nom, prenom );

    }
}
