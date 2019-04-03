package com.shj.app.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shj.app.entities.Salle;

@Repository
@Transactional
public class SalleDaoImpl implements SalleDao {

    @Autowired
    SalleRepository salleRepository;

    @Override
    public Salle create( Salle t ) {
        return salleRepository.saveAndFlush( t );
    }

    @Override
    public Salle update( Salle t ) {

        Salle salle = salleRepository.findOne( t.getId() );
        salle.setCapacite( t.getCapacite() );
        salle.setListCours( t.getListCours() );
        salle.setNom( t.getNom() );
        return salleRepository.save( salle );
    }

    @Override
    public Salle find( Long s ) {

        return salleRepository.findOne( s );
    }

    @Override
    public List<Salle> findAll() {

        return salleRepository.findAll();
    }

    @Override
    public boolean delete( Salle t ) {
        salleRepository.delete( salleRepository.findOne( t.getId() ) );
        return true;
    }
}
