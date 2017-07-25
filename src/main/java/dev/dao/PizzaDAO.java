package dev.dao;

import dev.entity.CategoriePizza;
import dev.entity.Pizza;
import dev.exception.DeletePizzaException;

public interface PizzaDAO {
	
	public void displayAllPizza();
	
	public void addPizza(Pizza pizza);
	
	public void addPizza( String code, String nom, double prix, CategoriePizza categoriePizza);
	
	public void updatePizza(int index ,String code, String nom, double prix, CategoriePizza categoriePizza);
	
	public void deletePizza(int indexPizza)throws DeletePizzaException;
	
}
