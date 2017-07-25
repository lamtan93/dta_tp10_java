package dev.console;

import dev.dao.PizzaDAO;
import dev.dao.PizzaDaoJpa;
import service.PizzaManage;

public class AppConsole {

	public static void main (String [] args){
		

		//PizzaDAO dao = new PizzaDAOImpl();
		PizzaDAO daoJpa = new PizzaDaoJpa();
		PizzaManage pizzaManage = new PizzaManage(daoJpa);
//		Menu m = new Menu(pizzaManage);
//		m.afficher();
		

		
//		Pizza p0 = new Pizza("PEP", "Peperoni", 12.50, CategoriePizza.VIANDE);
//	    Pizza p1 = new Pizza("MAR", "Margherita", 14.00, CategoriePizza.VEGETARIEN);
//	    Pizza p2 = new Pizza("REI", "La Reine", 11.50, CategoriePizza.VIANDE);
//	    Pizza p3 = new Pizza("FRO", "Les 4 fromages", 12.00, CategoriePizza.FROMAGE);
//	    Pizza p4 = new Pizza("CAN", "La Cannibale", 12.50,CategoriePizza.VIANDE);
//	    Pizza p5 = new Pizza("SAV", "Savoyarde", 13.00, CategoriePizza.FROMAGE);
//	    Pizza p6 = new Pizza("ORI", "L'orientale", 13.50, CategoriePizza.VIANDE);
//	    Pizza p7 = new Pizza("IND", "L'indienne", 14.00, CategoriePizza.VEGETARIEN);
		
				
//		pizzaDaoJpa.addPizza(p1);
//		pizzaDaoJpa.addPizza(p2);
//		pizzaDaoJpa.addPizza(p3);
//		pizzaDaoJpa.addPizza(p4);
//		pizzaDaoJpa.addPizza(p5);
//		pizzaDaoJpa.addPizza(p6);
//		pizzaDaoJpa.addPizza(p7);
		
		

	}
	
}
