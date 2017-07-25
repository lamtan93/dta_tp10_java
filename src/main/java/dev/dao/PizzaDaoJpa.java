package dev.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.entity.CategoriePizza;
import dev.entity.Client;
import dev.entity.Livreur;
import dev.entity.Pizza;
import dev.exception.DeletePizzaException;
import dev.utils.CrypterPasswords;
import dev.utils.GenerateNumberOrder;

public class PizzaDaoJpa implements PizzaDAO, IPizzaClient {

	private static final Logger LOG = LoggerFactory.getLogger(PizzaDaoJpa.class);
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public PizzaDaoJpa() {
		emf = Persistence.createEntityManagerFactory("dta_tp10_java");
		
		Pizza p0 = new Pizza("PEP", "Peperoni", 12.50, CategoriePizza.VIANDE);
	    Pizza p1 = new Pizza("MAR", "Margherita", 14.00, CategoriePizza.VEGETARIEN);
	    Pizza p2 = new Pizza("REI", "La Reine", 11.50, CategoriePizza.VIANDE);
	    Pizza p3 = new Pizza("FRO", "Les 4 fromages", 12.00, CategoriePizza.FROMAGE);
	    Pizza p4 = new Pizza("CAN", "La Cannibale", 12.50,CategoriePizza.VIANDE);
	    Pizza p5 = new Pizza("SAV", "Savoyarde", 13.00, CategoriePizza.FROMAGE);
	    Pizza p6 = new Pizza("ORI", "L'orientale", 13.50, CategoriePizza.VIANDE);
	    Pizza p7 = new Pizza("IND", "L'indienne", 14.00, CategoriePizza.VEGETARIEN);
		

	    addPizza(p0);
	    addPizza(p1);
	    addPizza(p2);
	    addPizza(p3);
	    addPizza(p4);
	    addPizza(p5);
	    addPizza(p6);
	    addPizza(p7);
	
	}

	@Override
	public void displayAllPizza() {
		em = emf.createEntityManager();
		

		TypedQuery<Pizza> query = em.createQuery("SELECT p from Pizza p", Pizza.class);
		query.getResultList().forEach(System.out::println);

		
		em.close();
		// emf.close();
	}

	@Override
	public void addPizza(Pizza pizza) {

		em = emf.createEntityManager();

		em.getTransaction().begin();

		em.persist(pizza);

		em.getTransaction().commit();

		em.close();
		//emf.close();
	}

	@Override
	public void addPizza(String code, String nom, double prix, CategoriePizza categoriePizza) {

	}

	@Override
	public void updatePizza(int index, String code, String nom, double prix, CategoriePizza categoriePizza) {
		em = emf.createEntityManager();

		String jpql = "SELECT p FROM Pizza p WHERE p.id=:x";
		Query query = em.createQuery(jpql);

		query.setParameter("x", index);
		Pizza pizza = (Pizza) query.getSingleResult();

		
		if (pizza != null) {
			 em.getTransaction().begin();
			
			pizza.setCode(code);
			pizza.setNom(nom);
			pizza.setPrix(prix);
			pizza.setCategoriePizza(categoriePizza);

			 em.getTransaction().commit();
			 
		}
		em.close();
	}

	@Override
	public void deletePizza(int indexPizza) throws DeletePizzaException {

		em = emf.createEntityManager();
		
		Pizza pizza = em.find(Pizza.class, indexPizza);
		if (pizza != null) {
			em.getTransaction().begin();
			em.remove(pizza);
			em.getTransaction().commit();
		}
		
		em.close();
	}

	@Override
	public boolean registerCustomer(Client client) {
		boolean registerOK = false;
		
		em = emf.createEntityManager();
		
		
		try {
			em.getTransaction().begin();
			em.persist(client);
			em.getTransaction().commit();
			registerOK = true;
			LOG.info("---> Registed OK !");
		} catch (Exception e) {
			LOG.info(""+ e);
		}
		
		em.close();
		
		return registerOK;
	}

	@Override
	public boolean logInCustomer(String email, String passwords) {
		boolean loginOk = false;
		String jpql = "SELECT cl FROM Client cl WHERE cl.email=:email AND cl.passwords=:passwords";
		em = emf.createEntityManager();
		
		Client client = null;
		Query query = em.createQuery(jpql);
		query.setParameter("email", email);
		query.setParameter("passwords", CrypterPasswords.md5(passwords));
		
		
		try {
			 client = (Client) query.getSingleResult();
			 loginOk = true;
			LOG.info("-->Login OK :D " + "\n" + client.getEmail());
		} catch (NoResultException e) {
			LOG.info("-->Login failed :( "+"\n" +e.getMessage());
		}
	
		em.close();
		
		return loginOk;
	}

	

	
	@Override
	public void commandPizza(){
		displayAllPizza();
		
		String numberOrder = GenerateNumberOrder.generateNumberOrder();
		Date dateDeCommande = new Date();
		String statut = "non traité";
		
		em = emf.createEntityManager();
		Client client = em.find(Client.class, 1);
		Livreur livreur = new Livreur("LIV", "Leon");
		
		//Commande commande = new Commande(numberOrder, statut, dateDeCommande, livreur, client);
		
		LOG.info("number order: " + numberOrder);
		
		//em.persist(commande);
		
		
		em.close();
	}

	@Override
	public List<String> allPizzasIdChoosenByCustomer(String indexPiizaIdChoosen) {
		List<String> listPizza = new ArrayList<>();
		listPizza.add(indexPiizaIdChoosen);
		return listPizza;
	}



	

}
