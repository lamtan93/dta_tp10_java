package dev.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Commande_Pizza implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private Pizza pizza;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Commande commande;
	
	public Commande_Pizza(){
		
	}

	public Commande_Pizza(Pizza pizza, Commande commande) {
		super();
		this.pizza = pizza;
		this.commande = commande;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	
}
