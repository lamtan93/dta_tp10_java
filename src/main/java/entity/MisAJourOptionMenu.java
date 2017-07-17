package entity;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import service.PizzaManage;

public class MisAJourOptionMenu extends OptionMenu {

	private PizzaManage pizzaManager;
	public Scanner sc;

	private static final Logger LOG = LoggerFactory.getLogger(MisAJourOptionMenu.class);

	public String getLibelle() {
		String libelle = "3/ Misa a jour d'une pizza" + "\n";
		return libelle;

	}

	public MisAJourOptionMenu(PizzaManage pizzaManage) {
		this.pizzaManager = pizzaManage;
		sc = new Scanner(System.in);
	}

	public void execute() {

		LOG.info("******Mise" + " \00e0 " + "jour d'une pizza*******");
		LOG.info("Entrer l'index :");
		int index = sc.nextInt();
		LOG.info("Entrer un code :");
		String code = sc.next();
		LOG.info("Entrer un nom :");
		String nom = sc.next();
		LOG.info("Entrer prix :");
		double prix = sc.nextDouble();
		LOG.info("Categorie: ");
		String categorieString = sc.next();
		
		CategoriePizza categoriePizza = CategoriePizza.valueByLabel(categorieString);
		
		pizzaManager.updatePizza(index, code, nom, prix, categoriePizza);

	}

}
