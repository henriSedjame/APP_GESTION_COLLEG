package com.shj.app.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shj.app.entities.Personnel;

@Repository
@Transactional
public class PersonnelDaoImpl implements PersonnelDao {

    @Autowired
    PersonnelRepository   personnelRepository;
    @Autowired
    IdentifiantRepository identifiantRepository;

    @Override
    public Personnel create( Personnel t ) {
        return personnelRepository.saveAndFlush( t );
    }

    @Override
    public Personnel update( Personnel t ) {

        Personnel personnel = personnelRepository.findOne( t.getId() );

        personnel.setIdentite( t.getIdentite() );
        personnel.setNumPersonnel( t.getNumPersonnel() );
        personnel.setPoste( t.getPoste() );

        return personnelRepository.save( personnel );
    }

    @Override
    public Personnel find( Long s ) {

        return personnelRepository.findOne( s );
    }

    @Override
    public List<Personnel> findAll() {

        return personnelRepository.findAll();
    }

    @Override
    public boolean delete( Personnel t ) {
        personnelRepository.delete( personnelRepository.findOne( t.getId() ) );
        return true;
    }

}
