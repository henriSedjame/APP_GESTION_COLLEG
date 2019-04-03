package com.shj.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shj.app.entities.Classe;
import com.shj.app.entities.Niveau;

public interface ClasseRepository extends JpaRepository<Classe, Long> {

    Classe findByNiveau( Niveau niveau );
}
