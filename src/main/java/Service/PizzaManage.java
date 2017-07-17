package Service;

import Dao.PizzaDAOImpl;
import Entity.CategoriePizza;
import Entity.Pizza;
import Exception.SavePizzaException;
import Exception.StockageException;

public class PizzaManage {

	private PizzaDAOImpl pizzaDAOImpl;

	public PizzaManage() {
		pizzaDAOImpl = new PizzaDAOImpl();
	};

	// Check infos
	public boolean checkInfos(String code, String nom, double prix) {
		boolean infosOK = true;
		if ((code.trim().isEmpty()) || (nom.trim().isEmpty()) || (prix == 0)) {

			System.out.println("Infos incorrectes, veuillez resaisir !");
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
		if (checkInfos(code, nom, prix) == true) {
			pizzaDAOImpl.addPizza(code, nom, prix, categoriePizza);
		}


	
	
	}

	public void updatePizza(int index, String code, String nom, double prix, CategoriePizza categoriePizza) {
		if (checkInfos(code, nom, prix) == true) {
			pizzaDAOImpl.updatePizza(index, code, nom, prix, categoriePizza);
		}

	}

	public void deletePizza(int indexPizza) {
		pizzaDAOImpl.deletePizza(indexPizza);

	}

}
