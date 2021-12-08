package com.esprit.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="T_Departement")
public class Departement implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long	id;
private String name;

@ManyToMany(cascade= CascadeType.ALL)
private List<Employe> employes;

@ManyToOne
private Entreprise entreprise;

@OneToMany(mappedBy="departement", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER)
private List<Mission> missions = new ArrayList<>();


public List<Mission> getMissions() {
	return missions;
}
public void setMissions(List<Mission> missions) {
	this.missions = missions;
}
public Entreprise getEntreprise() {
	return entreprise;
}
public void setEntreprise(Entreprise entreprise) {
	this.entreprise = entreprise;
}
public List<Employe> getEmployes() {
	return employes;
}
public void setEmployes(List<Employe> employes) {
	this.employes = employes;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}




public Departement(long id, String name) {
	super();
	this.id = id;
	this.name = name;
}
public Departement() {
	super();
	// TODO Auto-generated constructor stub
}



}
