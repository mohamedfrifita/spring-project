package com.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="T_Employe")
public class Employe implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id ;
	@Column(name="prenom")
	private String prenom;
	@Column(name="nom")
	private String nom;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="actif")
	private boolean actif;
	@Enumerated(EnumType.STRING)
	Role role;
	
	@OneToOne(mappedBy="employe")
	private Contrat contrat; 
	
	@ManyToMany(mappedBy="employes",cascade=CascadeType.ALL)
	private List<Departement> departements;
	
	@ManyToMany(mappedBy="employes",cascade=CascadeType.ALL)
	private Set<Mission> missions;
	
	
	public Set<Mission> getMissions() {
		return missions;
	}
	public void setMissions(Set<Mission> missions) {
		this.missions = missions;
	}

	
	
	
	
	public List<Departement> getDepartements() {
		return departements;
	}
	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}
	public Contrat getContrat() {
		return contrat;
	}
	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	
	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Employe(long id, String prenom, String nom, String email, String password, boolean actif, Role role) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.password=password;
		this.actif = actif;
		this.role = role;
		
	}
	
	
	public Employe(String prenom, String nom, String email, String password, boolean actif, Role role) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.password = password;
		this.actif = actif;
		this.role = role;
	}
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
