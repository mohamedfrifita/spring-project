package com.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entity.Contrat;
import com.esprit.spring.entity.Departement;
import com.esprit.spring.entity.Employe;
import com.esprit.spring.entity.Entreprise;
import com.esprit.spring.repository.ContratRepository;
import com.esprit.spring.repository.DepartementRepository;
import com.esprit.spring.repository.EmployeRepository;
@Service
public class EmployeServiceImpl implements IEmployeService {
	
	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	ContratRepository contratRepository;
	@Autowired
	DepartementRepository departementRepository;

	 private static final Logger L = LogManager.getLogger(EmployeServiceImpl.class);
	
	@Override
	public int ajouterEmploye(Employe employe) {
		employeRepository.save(employe);
		return 1;
	}
	/*
	@Override
	public void affecterEmployeADepartement(int employeId, int depId) {
		Departement departement=departementRepository.findById((long)depId).get();
		Employe employe=employeRepository.findById((long)employeId).get();
	    employe.getDepatements().add(departement);
	    employeRepository.save(employe);
	   
		
	}
	*/

	@Transactional
	public void affecterEmployeADepartement(int employeId, int depId) {
		Departement departement=departementRepository.findById((long)depId).get();
		Employe employe=employeRepository.findById((long)employeId).get();
	    
	     if(departement.getEmployes() == null){
				List<Employe> employes = new ArrayList<>();
				employes.add(employe);
				departement.setEmployes(employes);
			}else{
				departement.getEmployes().add(employe);
			}
		
	}
	
	
	
	/*
	public Optional<Employe> findById(Long employeId){
		return employeRepository.findById(employeId);
	}
	*/
	/*
@Override
	 public long retrieveEmploye(int employeId) {
		 
	Employe employe=employeRepository.findById((long)employeId).get();
	return employe.getId();
	 }
	*/
	@Override
	public int ajouterContrat(Contrat contrat) {
		contratRepository.save(contrat);
		return 1;
	}

	@Override
	public void affecterContratAEmploye(int contratId, int employeId) {
		Employe employe=employeRepository.findById((long)employeId).get();
		Contrat contrat=contratRepository.findById((long)contratId).get();
		contrat.setEmploye(employe);
		contratRepository.save(contrat);
		
	}

	@Override
	public String getEmployePrenomById(int employeId) {
		Employe employe=employeRepository.findById((long)employeId).get();
		
		return employe.getPrenom();
	}

	@Override
	public long getNombreEmployeJPQL() {
		
		return employeRepository.countemp();
	}

	@Override
	public List<String> getAllEmployeNamesJPQL() {
		
		return employeRepository.EmployeNames();
	}

	@Override
	public List<Employe> getAllEmployeByEntreprise(Entreprise entreprise) {
		
		return employeRepository.getAllEmployeByEntreprise(entreprise);
	}
/*
	@Override
	public Double getSalaireMoyenByDepartementId(int departementId) {
		// TODO Auto-generated method stub
		return null;
	}
	*/
	
	@Override
	public Employe authenticate(String login, String password) {
	return employeRepository.getEmployeByEmailAndPassword(login, password);
	}
	
	
	@Override
	public int addOrUpdateEmploye(Employe employe) {
	employeRepository.save(employe);
	return(int) employe.getId();
	}

	
	@Override
	public List<Employe> getAllEmployes() {
	return (List<Employe>) employeRepository.findAll();
	}

	@Override
	public void removeEmploye(int employeId) {
		employeRepository.deleteById((long)employeId);
		
	}

	

}
