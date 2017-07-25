package dev.entity;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import service.PizzaManage;

public class NouvellePizzaOptionMenu extends OptionMenu {

	private PizzaManage pizzaManager;

	Scanner sc;

	private static final Logger LOG = LoggerFactory.getLogger(ListerPizzasOptionMenu.class);

	public String getLibelle() {
		String libelle = "2/ Ajouter une nouvelle pizza" + "\n";
		return libelle;

	}

	public NouvellePizzaOptionMenu(PizzaManage pizzaManage) {
		this.pizzaManager = pizzaManage;
		sc = new Scanner(System.in);

	}

	public void execute()  {

		LOG.info("******Ajouter une pizza*******");
		LOG.info("Entrer un code : ");
		String code = sc.next();
		LOG.info("Entrer un nom : ");
		String nom = sc.next();
		LOG.info("Entrer un prix : ");
		double prix = sc.nextDouble();
		LOG.info("Quel categorie de pizza (Viande, Fromage, Vegetarien) ?:");
		String categoriePizzaString = sc.next();
		CategoriePizza categoriePizza = CategoriePizza.valueByLabel(categoriePizzaString);
		

		pizzaManager.addPizza(code, nom, prix, categoriePizza);
	}

}
