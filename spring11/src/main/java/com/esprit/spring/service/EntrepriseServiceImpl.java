package com.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entity.Departement;
import com.esprit.spring.entity.Entreprise;
import com.esprit.spring.repository.DepartementRepository;
import com.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {
	@Autowired
	EntrepriseRepository entrepriseRepository;
	@Autowired
	DepartementRepository  departementRepository ;
	 private static final Logger L = LogManager.getLogger(EntrepriseServiceImpl.class);
	
	
	@Override
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		Entreprise entreprise = entrepriseRepository.findById((long)entrepriseId).get();
		Departement departement = departementRepository.findById((long)depId).get();
		departement.setEntreprise(entreprise);
		departementRepository.save(departement);
	}
	
	@Override
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		Entreprise entreprise = entrepriseRepository.findById((long)entrepriseId).get();
		List<Departement> deps=(List<Departement>)entreprise.getDepartements();
		List<String> names = new ArrayList<>();
		for(Departement d : deps){
			names.add(d.getName());
		}
		
		return names;
	}

	@Override
	public int ajouterEntreprise(Entreprise entreprise) {
		entrepriseRepository.save(entreprise);
		return 1;
	}

	@Override
	public int ajouterDepartement(Departement departement) {
		departementRepository.save(departement);
		return 1;
	}
	

}
