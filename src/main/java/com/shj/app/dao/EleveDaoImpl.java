package com.shj.app.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shj.app.entities.Classe;
import com.shj.app.entities.Eleve;

@Repository
@Transactional
public class EleveDaoImpl implements EleveDao {

    @Autowired
    EleveRepository eleveRepository;

    @Override
    public Eleve create( Eleve t ) {
        return eleveRepository.saveAndFlush( t );
    }

    @Override
    public Eleve update( Eleve t ) {

        Eleve eleve = eleveRepository.findOne( t.getId() );
        eleve.setClasse( t.getClasse() );
        eleve.setIdentite( t.getIdentite() );
        eleve.setNumEleve( t.getNumEleve() );

        return eleveRepository.save( eleve );
    }

    @Override
    public Eleve find( Long s ) {

        return eleveRepository.findOne( s );
    }

    @Override
    public List<Eleve> findAll() {

        return eleveRepository.findAll();
    }

    @Override
    public boolean delete( Eleve t ) {
        eleveRepository.delete( eleveRepository.findOne( t.getId() ) );
        return true;
    }

    @Override
    public Eleve findByLoginAndMotDePasse( String login, String motDePasse ) {

        return eleveRepository.findByLoginAndMotDePasse( login, motDePasse );
    }

    @Override
    public List<Eleve> findByNom( String nom ) {

        return eleveRepository.findByNom( nom );
    }

    @Override
    public Eleve findByNomAndPrenom( String nom, String prenom ) {

        return eleveRepository.findByNomAndPrenom( nom, prenom );
    }

    @Override
    public List<Eleve> findByClasse( Classe classe ) {

        return eleveRepository.findByClasse( classe );
    }

    @Override
    public Eleve findByNumEleve( String numEleve ) {

        return eleveRepository.findByNumEleve( numEleve );
    }
}
