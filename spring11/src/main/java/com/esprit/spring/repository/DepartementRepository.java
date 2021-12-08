package com.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entity.Departement;
@Repository
public interface DepartementRepository extends JpaRepository<Departement,Long>{

}
