package com.shj.app.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shj.app.entities.Administratif;

@Repository
@Transactional
public class AdministratifDaoImpl implements AdministratifDao {

    @Autowired
    AdministratifRepository administratifRepository;

    @Override
    public Administratif create( Administratif t ) {
        return administratifRepository.saveAndFlush( t );
    }

    @Override
    public Administratif update( Administratif t ) {

        Administratif admin = administratifRepository.findOne( t.getId() );
        admin.setIdentite( t.getIdentite() );
        admin.setNumPersonnel( t.getNumPersonnel() );
        admin.setPoste( t.getPoste() );
        return administratifRepository.save( admin );
    }

    @Override
    public Administratif find( Long s ) {

        return administratifRepository.findOne( s );
    }

    @Override
    public List<Administratif> findAll() {

        return administratifRepository.findAll();
    }

    @Override
    public boolean delete( Administratif t ) {
        administratifRepository.delete( administratifRepository.findOne( t.getId() ) );
        return true;
    }

    @Override
    public Administratif findByLoginAndMotDePasse( String login, String motDePasse ) {

        return administratifRepository.findByLoginAndMotDePasse( login, motDePasse );
    }

    @Override
    public List<Administratif> findByNom( String nom ) {

        return administratifRepository.findByNom( nom );
    }

    @Override
    public Administratif findByNomAndPrenom( String nom, String prenom ) {

        return administratifRepository.findByNomAndPrenom( nom, prenom );
    }

}
