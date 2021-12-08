package com.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.spring.entity.Departement;
import com.esprit.spring.entity.Entreprise;

import com.esprit.spring.service.IEntrepriseService;
@RestController
public class EntrepriseRestController {
	@Autowired
	IEntrepriseService entrepriseService;
	
	// http://localhost:8081/SpringMVC/servlet/affecterDepartementAEntreprise
	@PostMapping("/affecterDepartementAEntreprise")
	@ResponseBody
	public void affecterDepartementAEntreprise(@RequestParam("depId")String depId,@RequestParam("entrepriseId") String entrepriseId) {
		entrepriseService.affecterDepartementAEntreprise(Integer.parseInt(depId), Integer.parseInt(entrepriseId));
	}
	
	
	// http://localhost:8081/SpringMVC/servlet/affecterDepartementAEntreprise/{entrepriseId}
		@GetMapping("/affecterDepartementAEntreprise/{entrepriseId}")
		@ResponseBody
		public List<String> getAllDepartementsNamesByEntreprise(@PathVariable ("entrepriseId")int entrepriseId ){
			return entrepriseService.getAllDepartementsNamesByEntreprise(entrepriseId);
			
			
		}
		
		
		// http://localhost:8081/SpringMVC/servlet/add-entreprise
		
		@PostMapping("/add-entreprise")
		@ResponseBody
		public int ajouterEntreprise(@RequestBody Entreprise e) {
			entrepriseService.ajouterEntreprise(e);
			return 1;
			
		}
		
		// http://localhost:8081/SpringMVC/servlet/add-departement
		
				@PostMapping("/add-departement")
				@ResponseBody
				public int ajouterDepartement(@RequestBody Departement d) {
					entrepriseService.ajouterDepartement(d);
					return 1;
					
				}
		
		
}
