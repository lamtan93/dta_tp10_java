
package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.PizzaDAOImpl;
import entity.CategoriePizza;
import entity.Pizza;


public class PizzaManage {

	private PizzaDAOImpl pizzaDAOImpl;
	
	private static final Logger LOG = LoggerFactory.getLogger(PizzaManage.class);
	

	public PizzaManage() {
		pizzaDAOImpl = new PizzaDAOImpl();
	}

	// Check infos
	public boolean checkInfos(String code, String nom, double prix) {
		boolean infosOK = true;
		if ((code.trim().isEmpty()) || (nom.trim().isEmpty()) || (prix == 0.0f)) {

			LOG.info("Infos incorrectes, veuillez resaisir !");
			infosOK = false;

		}
		return infosOK;

	}

	public void displayListPizza() {
		pizzaDAOImpl.displayAllPizza();

	}

	
	public void addPizza(Pizza pizza)  {
		
			pizzaDAOImpl.addPizza(pizza);
		
	}
	
	public void addPizza(String code, String nom, double prix, CategoriePizza categoriePizza) {
		if (checkInfos(code, nom, prix)) {
			pizzaDAOImpl.addPizza( code, nom, prix, categoriePizza);
		}


	
	
	}

	public void updatePizza(int index, String code, String nom, double prix, CategoriePizza categoriePizza) {
		if (checkInfos(code, nom, prix)) {
			pizzaDAOImpl.updatePizza(index, code, nom, prix, categoriePizza);
		}

	}

	public void deletePizza(int indexPizza) {
		pizzaDAOImpl.deletePizza(indexPizza);

	}

}
