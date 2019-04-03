package com.shj.app.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shj.app.entities.Identifiant;

@Repository
@Transactional
public class IdentifiantDaoImpl implements IdentifiantDao {

    @Autowired
    IdentifiantRepository identifiantRepository;

    @Override
    public Identifiant create( Identifiant t ) {
        return identifiantRepository.saveAndFlush( t );
    }

    @Override
    public Identifiant update( Identifiant t ) {

        Identifiant identifiant = identifiantRepository.findOne( t.getId() );

        identifiant.setIdentite( t.getIdentite() );
        identifiant.setLogin( t.getLogin() );
        identifiant.setMotDePasse( t.getMotDePasse() );

        return identifiantRepository.save( identifiant );
    }

    @Override
    public Identifiant find( Long s ) {

        return identifiantRepository.findOne( s );
    }

    @Override
    public List<Identifiant> findAll() {

        return identifiantRepository.findAll();
    }

    @Override
    public boolean delete( Identifiant t ) {
        identifiantRepository.delete( identifiantRepository.findOne( t.getId() ) );
        return true;
    }

    @Override
    public Identifiant findIdentifiant( String login, String motDePasse ) {

        return identifiantRepository.findByLoginAndMotDePasse( login, motDePasse );
    }

    @Override
    public Identifiant findByLogin( String Login ) {

        return identifiantRepository.findByLogin( Login );
    }

}
