package com.esprit.spring.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.spring.entity.Contrat;

import com.esprit.spring.entity.Employe;

import com.esprit.spring.service.IEmployeService;

@RestController
public class EmployeRestController {
	@Autowired
	IEmployeService employeService;
	
	
	
	// http://localhost:8081/SpringMVC/servlet/affecterEmployeADepartement
		@PostMapping("/affecterEmployeADepartement")
		@ResponseBody
		public void affecterEmployeADepartement(@RequestParam("employeId") String employeId,@RequestParam("depId")String depId) {
			employeService.affecterEmployeADepartement(Integer.parseInt(depId), Integer.parseInt(employeId));
		}
		
		
		// http://localhost:8081/SpringMVC/servlet/add-employe
		
				@PostMapping("/add-employe")
				@ResponseBody
				public int ajouterEmploye(@RequestBody Employe employe) {
					employeService.ajouterEmploye(employe);
					return 1;
					
				}
				// http://localhost:8081/SpringMVC/servlet/affecterContratAEmploye
				@PostMapping("/affecterContratAEmploye")
				@ResponseBody
				public void affecterContratAEmploye(@RequestParam("contratId")String contratId,@RequestParam("employeId")String employeId) {
					employeService.affecterContratAEmploye(Integer.parseInt(contratId), Integer.parseInt(employeId));
					}
				
				// http://localhost:8081/SpringMVC/servlet/getEmployePrenomById/{employeId}
				@GetMapping("/getEmployePrenomById/{employeId}")
				@ResponseBody
				public String getEmployePrenomById(@PathVariable("employeId")String employeId) {
					return  employeService.getEmployePrenomById(Integer.parseInt(employeId));
				}
				
				// http://localhost:8081/SpringMVC/servlet/add-contrat
				
				@PostMapping("/add-contrat")
				@ResponseBody
				public int ajouterContrat(@RequestBody Contrat contrat) {
					employeService.ajouterContrat(contrat);
					return 1;}
				
			/*
				// http://localhost:8081/SpringMVC/servlet/retrieveEmploye/{employe-id}
				@GetMapping("/retrieveEmploye/{employe-id}")
				@ResponseBody
				
				public long retrieveEmploye(@PathVariable("employeId") Long employeId) {
				return employeService.findById(employeId).orElseThrow(( -> new EmployeNotFoundException(employeId)));
				}
				*/
				
				/*
				// http://localhost:8081/SpringMVC/servlet/Optional/{employe-id}
				@GetMapping("/Optional/{employe-id}")
				@ResponseBody
				 public Optional<Employe> findById(Long employeId){
					 return employeService.findById(employeId);
				 }
				*/
}
