package com.shj.app.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shj.app.entities.Classe;
import com.shj.app.entities.Niveau;

@Repository
@Transactional
public class ClasseDaoImpl implements ClasseDao {

    @Autowired
    ClasseRepository classeRepository;

    @Override
    public Classe create( Classe t ) {
        return classeRepository.saveAndFlush( t );
    }

    @Override
    public Classe update( Classe t ) {

        Classe classe = classeRepository.findOne( t.getId() );
        classe.setNiveau( t.getNiveau() );
        classe.setListCours( t.getListCours() );
        classe.setListEleve( t.getListEleve() );
        classe.setListProfesseur( t.getListProfesseur() );
        return classeRepository.save( classe );
    }

    @Override
    public Classe find( Long s ) {

        return classeRepository.findOne( s );
    }

    @Override
    public List<Classe> findAll() {

        return classeRepository.findAll();
    }

    @Override
    public boolean delete( Classe t ) {
        classeRepository.delete( classeRepository.findOne( t.getId() ) );
        return true;
    }

    @Override
    public Classe findByNiveau( Niveau niveau ) {

        return classeRepository.findByNiveau( niveau );
    }

}
