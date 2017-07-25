package dev.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Livreur implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String prenom;
	
	
	@OneToMany(mappedBy = "livreur")
	private Collection<Commande> listCommandes;
	
	public Livreur (){
		listCommandes = new ArrayList<>();
	}
	
	public Livreur(Integer id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}
	public Livreur(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Collection<Commande> getListCommandes() {
		return listCommandes;
	}

	public void setListCommandes(Collection<Commande> listCommandes) {
		this.listCommandes = listCommandes;
	}
	
	
}
