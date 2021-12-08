package com.esprit.spring.service;




import java.util.List;



import com.esprit.spring.entity.Contrat;

import com.esprit.spring.entity.Employe;
import com.esprit.spring.entity.Entreprise;

public interface IEmployeService {
	 public int ajouterEmploye(Employe employe);
	 public void affecterEmployeADepartement(int employeId, int depId);
	 public int ajouterContrat(Contrat contrat);
	 public void affecterContratAEmploye(int contratId, int employeId);
	 public String getEmployePrenomById(int employeId);
	 public List <Employe> getAllEmployeByEntreprise(Entreprise entreprise);
	// public Double getSalaireMoyenByDepartementId(int departementId);
	 public long getNombreEmployeJPQL();
	 public List<String> getAllEmployeNamesJPQL();
	 
	// public Optional<Employe> findById(Long employeId);
	// public Employe retrieveEmploye(int employeId);

	 
	 
	 public Employe authenticate(String login, String password) ;
	 
	 public int addOrUpdateEmploye(Employe employe);
	 
	 public List<Employe> getAllEmployes();
	 public void removeEmploye(int employeId);

}
