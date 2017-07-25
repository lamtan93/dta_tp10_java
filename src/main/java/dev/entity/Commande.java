package dev.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Commande implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String numeroDeCommande;
	private String statut;
	
	//@Temporal(java.util.Date.TemporalType.TIMESTAMP)
	private Date dateDeCommande;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private Livreur livreur;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private Client client;
	
	
	@OneToMany(mappedBy = "commande")
	private Collection<Commande_Pizza> listCommande_Pizza ;
	
	
	public Commande(){
		
	}


	public Commande(Integer id, String numeroDeCommande, String statut, Date dateDeCommande, Livreur livreur,
			Client client, Collection<Commande_Pizza> listCommande_Pizza) {
		super();
		this.id = id;
		this.numeroDeCommande = numeroDeCommande;
		this.statut = statut;
		this.dateDeCommande = dateDeCommande;
		this.livreur = livreur;
		this.client = client;
		this.listCommande_Pizza = listCommande_Pizza;
	}


	public Commande(String numeroDeCommande, String statut, Date dateDeCommande, Livreur livreur, Client client,
			Collection<Commande_Pizza> listCommande_Pizza) {
		super();
		this.numeroDeCommande = numeroDeCommande;
		this.statut = statut;
		this.dateDeCommande = dateDeCommande;
		this.livreur = livreur;
		this.client = client;
		this.listCommande_Pizza = listCommande_Pizza;
	}
	
	
	public Commande(String numeroDeCommande, String statut, Date dateDeCommande, Livreur livreur, Client client) {
		super();
		this.numeroDeCommande = numeroDeCommande;
		this.statut = statut;
		this.dateDeCommande = dateDeCommande;
		this.livreur = livreur;
		this.client = client;
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNumeroDeCommande() {
		return numeroDeCommande;
	}


	public void setNumeroDeCommande(String numeroDeCommande) {
		this.numeroDeCommande = numeroDeCommande;
	}


	public String getStatut() {
		return statut;
	}


	public void setStatut(String statut) {
		this.statut = statut;
	}


	public Date getDateDeCommande() {
		return dateDeCommande;
	}


	public void setDateDeCommande(Date dateDeCommande) {
		this.dateDeCommande = dateDeCommande;
	}


	public Livreur getLivreur() {
		return livreur;
	}


	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Collection<Commande_Pizza> getListCommande_Pizza() {
		return listCommande_Pizza;
	}


	public void setListCommande_Pizza(Collection<Commande_Pizza> listCommande_Pizza) {
		this.listCommande_Pizza = listCommande_Pizza;
	}
	
	
	
}
