package com.shj.app.dao;

import com.shj.app.entities.Classe;
import com.shj.app.entities.Niveau;

public interface ClasseDao extends Dao<Classe, Long> {

    Classe findByNiveau( Niveau niveau );
}
