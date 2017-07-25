package dev.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import service.PizzaManage;

public class ListerPizzasOptionMenu extends OptionMenu {

	private static final Logger LOG = LoggerFactory.getLogger(ListerPizzasOptionMenu.class);

	private PizzaManage pizzaManager;

	public String getLibelle() {
		String libelle = "1/ Lister les pizzas" + "\n";
		return libelle;

	}

	public ListerPizzasOptionMenu(PizzaManage pizzaManage) {
		this.pizzaManager = pizzaManage;

	}

	public void execute() {
		LOG.info("*******Les Pizzas*******" + "\n");
		pizzaManager.displayListPizza();
	}

	
}
