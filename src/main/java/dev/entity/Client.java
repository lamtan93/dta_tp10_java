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
public class Client implements Serializable{
	
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String nom;
private String prenom;
private String email;
private String passwords;


@OneToMany(mappedBy = "client")
private Collection<Commande> listCommandes;

public Client(){
	listCommandes = new ArrayList<>();
	
}

public Client(Integer id, String nom, String prenom, String email, String passwords) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.passwords = passwords;
}




public Client(String nom, String prenom, String email, String passwords) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.passwords = passwords;
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



public String getEmail() {
	return email;
}



public void setEmail(String email) {
	this.email = email;
}



public String getPasswords() {
	return passwords;
}



public void setPasswords(String passwords) {
	this.passwords = passwords;
}

	
public Collection<Commande> getListCommandes() {
	return listCommandes;
}




public void setListCommandes(Collection<Commande> listCommandes) {
	this.listCommandes = listCommandes;
}


}

