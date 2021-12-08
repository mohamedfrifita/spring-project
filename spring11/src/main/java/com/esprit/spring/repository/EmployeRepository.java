package com.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.esprit.spring.entity.Employe;
import com.esprit.spring.entity.Entreprise;

@Repository
public interface EmployeRepository extends JpaRepository<Employe,Long> {
	@Query("SELECT count(*) FROM Employe ")
	 public int countemp() ;
	
	@Query("SELECT nom FROM Employe")
	List<String> EmployeNames();
	
	
	@Query("Select " + " DISTINCT emp from Employe emp " + " join emp.departements dep" + " join dep.entreprise entrep" + " where entreprise=:entreprise")
	public List<Employe> getAllEmployeByEntreprise(@Param("entreprise") Entreprise entreprise);
	
	
	

	
	
	
	@Query("SELECT e FROM Employe e WHERE e.email=:email and e.password=:password")
	public Employe getEmployeByEmailAndPassword(@Param("email")String login, @Param("password")String password);

}
