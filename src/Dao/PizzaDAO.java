package Dao;

import Entity.CategoriePizza;
import Entity.Pizza;
import Exception.DeletePizzaException;
import Exception.SavePizzaException;
import Exception.UpdatePizzaException;

public interface PizzaDAO {
	
	public void displayAllPizza();
	
	public void addPizza(Pizza pizza);
	
	public void addPizza(String code, String nom, double prix, CategoriePizza categoripiza);
	
	public void updatePizza(int index ,String code, String nom, double prix, CategoriePizza categoriePizza);
	
	public void deletePizza(int indexPizza);
}
