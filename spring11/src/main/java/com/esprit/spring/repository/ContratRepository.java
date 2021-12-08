package com.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entity.Contrat;
@Repository
public interface ContratRepository extends JpaRepository<Contrat,Long> {

}
