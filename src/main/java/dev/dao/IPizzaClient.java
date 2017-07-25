package dev.dao;

import java.util.List;

import dev.entity.Client;

public interface IPizzaClient {
	
	public boolean registerCustomer(Client client);
		
	public boolean logInCustomer(String email, String passwords);
	
	public List<String> allPizzasIdChoosenByCustomer(String indexPizzaChoosen);
	
	public void commandPizza();
	
		
	
	
}
