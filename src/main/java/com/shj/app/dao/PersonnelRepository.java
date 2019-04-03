package com.shj.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shj.app.entities.Personnel;

public interface PersonnelRepository extends JpaRepository<Personnel, Long> {

}
