package Entity;

import java.util.Scanner;

import Dao.PizzaDAOImpl;
import Exception.StockageException;
import Service.PizzaManage;

public class NouvellePizzaOptionMenu extends OptionMenu {

	private PizzaManage pizzaManager;

	Scanner sc;

	public String getLibelle() {
		String libelle = "2/ Ajouter une nouvelle pizza" + "\n";
		return libelle;

	}

	public NouvellePizzaOptionMenu(PizzaManage pizzaManage) {
		this.pizzaManager = pizzaManage;
		sc = new Scanner(System.in);

	}

	public void execute()  {

		System.out.println("******Ajouter une pizza*******");
		System.out.print("Entrer un code : ");
		String code = sc.next();
		System.out.print("Entrer un nom : ");
		String nom = sc.next();
		System.out.print("Entrer un prix : ");
		double prix = sc.nextDouble();
		System.out.print("Quel categorie de pizza (Viande, Fromage, Vegetarien) ?:");
		String categoriePizzaString = sc.next();
		CategoriePizza categoriePizza = CategoriePizza.valueByLabel(categoriePizzaString);
		
		pizzaManager.addPizza(code, nom, prix, categoriePizza);
	}

}
