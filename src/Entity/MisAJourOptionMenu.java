package Entity;

import java.util.Scanner;

import Dao.PizzaDAOImpl;
import Service.PizzaManage;

public class MisAJourOptionMenu extends OptionMenu {

	private PizzaManage pizzaManager;
	public Scanner sc;

	public String getLibelle() {
		String libelle = "3/ Misa a jour d'une pizza" + "\n";
		return libelle;

	}

	public MisAJourOptionMenu(PizzaManage pizzaManage) {
		this.pizzaManager = pizzaManage;
		sc = new Scanner(System.in);
	}

	public void execute() {

		System.out.println("******Mise" + " \00e0 " + "jour d'une pizza*******");
		System.out.println("Entrer l'index :");
		int index = sc.nextInt();
		System.out.println("Entrer un code :");
		String code = sc.next();
		System.out.println("Entrer un nom :");
		String nom = sc.next();
		System.out.println("Entrer prix :");
		double prix = sc.nextDouble();
		System.out.println("Categorie: ");
		String categorieString = sc.next();
		
		CategoriePizza categoriePizza = CategoriePizza.valueByLabel(categorieString);
		
		pizzaManager.updatePizza(index, code, nom, prix, categoriePizza);

	}

}
