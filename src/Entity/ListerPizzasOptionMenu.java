package Entity;

import Service.PizzaManage;

public class ListerPizzasOptionMenu extends OptionMenu {

	private PizzaManage pizzaManager;

	public String getLibelle() {
		String libelle = "1/ Lister les pizzas" + "\n";
		return libelle;

	}

	public ListerPizzasOptionMenu(PizzaManage pizzaManage) {
		this.pizzaManager = pizzaManage;

	}

	public void execute() {
		System.out.println("*******Les Pizzas*******" + "\n");
		pizzaManager.displayListPizza();
	}

}
