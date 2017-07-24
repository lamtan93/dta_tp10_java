package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entity.CategoriePizza;
import entity.Pizza;
import exception.DeletePizzaException;

public class PizzaDaoJpa implements PizzaDAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	

	public PizzaDaoJpa() {
		emf = Persistence.createEntityManagerFactory("dta_tp10_java");
		
	}

	@Override
	public void displayAllPizza() {
		em = emf.createEntityManager();
		em.getTransaction();

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

}
