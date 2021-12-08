package com.esprit.spring.service;

import java.util.List;

import com.esprit.spring.entity.Departement;
import com.esprit.spring.entity.Entreprise;



public interface IEntrepriseService {
	void affecterDepartementAEntreprise(int depId, int entrepriseId);
	List<String> getAllDepartementsNamesByEntreprise(int entrepriseId);
	public int ajouterEntreprise(Entreprise entreprise);
    public int ajouterDepartement(Departement dep);

}
