package entity;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import service.PizzaManage;

public class SupressionPizzaOptionMenu extends OptionMenu {

	private PizzaManage pizzaManager;
	Scanner sc;

	private static Logger LOG = LoggerFactory.getLogger(SupressionPizzaOptionMenu.class);

	public String getLibelle() {
		String libelle = "4/ Supression d'une pizza " + "\n";
		return libelle;

	}

	public SupressionPizzaOptionMenu(PizzaManage pizzaManager) {
		this.pizzaManager=pizzaManager;
		sc = new Scanner(System.in);

	}

	public void execute() {
		LOG.info("*****Supression d'une pizza******");
		LOG.info("Entrer l'index: ");
		int index = sc.nextInt();

		pizzaManager.deletePizza(index);
	}

}
