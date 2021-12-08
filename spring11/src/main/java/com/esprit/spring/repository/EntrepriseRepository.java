package com.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entity.Entreprise;
@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise , Long>{
static Entreprise findEntrepriseById(long parseLong) {
	return null;
}
}
