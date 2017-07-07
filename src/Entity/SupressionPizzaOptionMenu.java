package Entity;

import java.util.Scanner;

import Dao.PizzaDAOImpl;
import Service.PizzaManage;

public class SupressionPizzaOptionMenu extends OptionMenu {

	private PizzaManage pizzaManager;
	Scanner sc;

	public String getLibelle() {
		String libelle = "4/ Supression d'une pizza " + "\n";
		return libelle;

	}

	public SupressionPizzaOptionMenu(PizzaManage pizzaManager) {
		this.pizzaManager=pizzaManager;
		sc = new Scanner(System.in);

	}

	public void execute() {
		System.out.println("*****Supression d'une pizza******");
		System.out.print("Entrer l'index: ");
		int index = sc.nextInt();

		pizzaManager.deletePizza(index);
	}

}
