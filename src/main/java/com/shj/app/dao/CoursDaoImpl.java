package com.shj.app.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shj.app.entities.Classe;
import com.shj.app.entities.Cours;
import com.shj.app.entities.Professeur;

@Repository
@Transactional
public class CoursDaoImpl implements CoursDao {

    @Autowired
    CoursRepository      coursRepository;
    @Autowired
    ClasseRepository     classeRepository;
    @Autowired
    ProfesseurRepository professeurRepository;

    @Override
    public Cours create( Cours t ) {

        Classe classe = t.getClasse();
        Professeur prof = (Professeur) t.getProfesseur();

        if ( classe != null && classe.getId() != null ) {

            if ( prof != null && prof.getId() != null ) {

                classe = classeRepository.findOne( classe.getId() );

                prof = (Professeur) professeurRepository.findOne( prof.getId() );

            } else if ( prof != null ) {
                classe = classeRepository.findOne( classe.getId() );
                prof = (Professeur) professeurRepository.saveAndFlush( prof );
            }

        } else if ( classe != null ) {

            if ( prof != null && prof.getId() != null ) {
                classe = classeRepository.saveAndFlush( classe );
                prof = (Professeur) professeurRepository.findOne( prof.getId() );

            } else if ( prof != null ) {
                classe = classeRepository.saveAndFlush( classe );
                prof = (Professeur) professeurRepository.saveAndFlush( prof );
            }
        }

        t.setClasse( classe );
        t.setProfesseur( prof );
        return coursRepository.saveAndFlush( t );
    }

    @Override
    public Cours update( Cours t ) {

        Cours cours = coursRepository.findOne( t.getId() );

        cours.setClasse( t.getClasse() );
        cours.setHeureCours( t.getHeureCours() );
        cours.setNumCours( t.getNumCours() );
        cours.setProfesseur( t.getProfesseur() );
        cours.setSalle( t.getSalle() );

        return coursRepository.save( cours );
    }

    @Override
    public Cours find( Long s ) {

        return coursRepository.findOne( s );
    }

    @Override
    public List<Cours> findAll() {

        return coursRepository.findAll();
    }

    @Override
    public boolean delete( Cours t ) {
        coursRepository.delete( coursRepository.findOne( t.getId() ) );
        return true;
    }

    @Override
    public List<Cours> findByClasse( Classe classe ) {

        return coursRepository.findByClasse( classe );
    }

    @Override
    public List<Cours> findByProfesseur( Professeur professeur ) {

        return coursRepository.findByProfesseur( professeur );
    }

    @Override
    public List<Cours> findByProfesseurAndClasse( Professeur professeur, Classe classe ) {

        return coursRepository.findByProfesseurAndClasse( professeur, classe );
    }

    @Override
    public List<Classe> findClasseByProfesseur( Professeur professeur ) {

        return coursRepository.findClasseByProfesseur( professeur );
    }

}
