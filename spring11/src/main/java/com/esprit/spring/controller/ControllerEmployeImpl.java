package com.esprit.spring.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.esprit.spring.entity.Employe;
import com.esprit.spring.entity.Role;
import com.esprit.spring.service.IEmployeService;

@Scope(value = "session")
@Controller(value = "employeController")
@ELBeanName(value = "employeController")
@Join(path = "/", to = "/login.jsf")
public class ControllerEmployeImpl {
	
@Autowired
IEmployeService employeService;

private String login;
private String password;
private Employe employe;
private Boolean loggedIn;
private Employe authenticatedUser;
private String prenom; 
private String nom; 
private String email; 
private boolean actif; 
private Role role;
private List<Employe> employes;
private Integer employeIdToBeUpdated; 

public String doLogin() {
String navigateTo = "null";
authenticatedUser=employeService.authenticate(login, password);
 if (authenticatedUser != null && authenticatedUser.getRole() == Role.ADMINISTRATEUR) { 
navigateTo = "/pages/admin/welcome.xhtml?faces-redirect=true";
loggedIn = true; }
else {
FacesMessage facesMessage = new FacesMessage("Login Failed: please check your username/password and try again.");
FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
}
return navigateTo;
}
public String doLogout() {
FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
return "/login.xhtml?faces-redirect=true";
}

public void addEmploye() {
employeService.addOrUpdateEmploye(new Employe(nom, prenom, email, password, actif, role)); 
}

public Role[] getRoles() { return Role.values(); }


public List<Employe> getAllEmployes() {
employes = employeService.getAllEmployes(); 
return employes;
}


public void removeEmploye(int employeId)
{
employeService.removeEmploye(employeId);
}



public void displayEmploye(Employe empl) 
{
this.setPrenom(empl.getPrenom());
this.setNom(empl.getNom());
this.setActif(empl.isActif()); 
this.setEmail(empl.getEmail());
this.setRole(empl.getRole());
this.setPassword(empl.getPassword());
this.setEmployeIdToBeUpdated((int)empl.getId());
}


public void updateEmploye() 
{ employeService.addOrUpdateEmploye(new Employe(employeIdToBeUpdated, nom, prenom, email, password, actif, role)); } 




public String ajouterEmploye() {
String navigateTo = "null";

 if (authenticatedUser==null || !loggedIn) return "/login.xhtml";
 employeService.addOrUpdateEmploye(new Employe(nom, prenom, email, password, actif, role)); 
return navigateTo; 
} 





public String getLogin() {
	return login;
}

public IEmployeService getEmployeService() {
	return employeService;
}
public void setEmployeService(IEmployeService employeService) {
	this.employeService = employeService;
}
public void setLogin(String login) {
	this.login = login;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public Employe getEmploye() {
	return employe;
}

public void setEmploye(Employe employe) {
	this.employe = employe;
}

public Boolean getLoggedIn() {
	return loggedIn;
}

public void setLoggedIn(Boolean loggedIn) {
	this.loggedIn = loggedIn;
}
public Employe getAuthenticatedUser() {
	return authenticatedUser;
}
public void setAuthenticatedUser(Employe authenticatedUser) {
	this.authenticatedUser = authenticatedUser;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public boolean isActif() {
	return actif;
}
public void setActif(boolean actif) {
	this.actif = actif;
}
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}
public List<Employe> getEmployes() {
	return employes;
}
public void setEmployes(List<Employe> employes) {
	this.employes = employes;
}
public Integer getEmployeIdToBeUpdated() {
	return employeIdToBeUpdated;
}
public void setEmployeIdToBeUpdated(Integer employeIdToBeUpdated) {
	this.employeIdToBeUpdated = employeIdToBeUpdated;
}






}
