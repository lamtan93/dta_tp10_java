package Dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Entity.CategoriePizza;
import Entity.Pizza;

public class PizzaDAOImpl implements PizzaDAO{

	private List<Pizza> listPizza;
	
	public PizzaDAOImpl (){
		
		listPizza = new ArrayList<>();
		Pizza p0 = new Pizza(0, "PEP", "Peperoni", 12.50, CategoriePizza.VIANDE);
	    Pizza p1 = new Pizza(1, "MAR", "Margherita", 14.00, CategoriePizza.VEGETARIEN);
	    Pizza p2 = new Pizza(2, "REI", "La Reine", 11.50, CategoriePizza.VIANDE);
	    Pizza p3 = new Pizza(3, "FRO", "Les 4 fromages", 12.00, CategoriePizza.FROMAGE);
	    Pizza p4 = new Pizza(4, "CAN", "La Cannibale", 12.50,CategoriePizza.VIANDE);
	    Pizza p5 = new Pizza(5, "SAV", "Savoyarde", 13.00, CategoriePizza.FROMAGE);
	    Pizza p6 = new Pizza(6, "ORI", "L'orientale", 13.50, CategoriePizza.VIANDE);
	    Pizza p7 = new Pizza(7, "IND", "L'indienne", 14.00, CategoriePizza.VEGETARIEN);
		
	   listPizza.add(p0);
	   listPizza.add(p1);
	   listPizza.add(p2);
	   listPizza.add(p3);
	   listPizza.add(p4);
	   listPizza.add(p5);
	   listPizza.add(p6);
	   listPizza.add(p7);
	}
	
	
	public List<Pizza> getTableauPizza(){
		return listPizza;
	}
	
	
	@Override
	public void displayAllPizza() {
		System.out.println(" code "+ "  nom  "+ "     prix  "+ " categ "+"\n");
		for (Pizza pizza : listPizza) {
			System.out.println(pizza);
		}
	}
	
	
	@Override
	public void addPizza(Pizza pizza) {
		listPizza.add(pizza);
		
	}

	@Override
	public void addPizza(String code, String nom, double prix, CategoriePizza categoriePizza) {
		Pizza newPizza = new Pizza(code, nom, prix, categoriePizza);
		listPizza.add(newPizza);
		
	}

	
	@Override
	public void updatePizza(int index, String code, String nom, double prix, CategoriePizza categoriePizza) {
		for (Pizza pizza : listPizza) {
			if(pizza.getIndex() == index){
				pizza.setCode(code);
				pizza.setNom(nom);
				pizza.setPrix(prix);
			}
		}
		
		
	}

	@Override
	public void deletePizza(int indexPizza) {
		
		for (Iterator<Pizza> it = listPizza.iterator(); it.hasNext(); ) {

		    Pizza pizzaNul = it.next();
		    if (pizzaNul.getIndex()==  indexPizza) {
		       it.remove();
		    }
		}
		
		
	}
}
