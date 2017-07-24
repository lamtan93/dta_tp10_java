package dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.service.AppService;
import entity.CategoriePizza;
import entity.Pizza;
import exception.DeletePizzaException;

public class PizzaDAOImpl implements PizzaDAO{

	private static final Logger LOG = LoggerFactory.getLogger(Pizza.class);
	

	private List<Pizza> listPizza;
	
	

	public PizzaDAOImpl (){
		
		listPizza = new ArrayList<>();
		Pizza p0 = new Pizza(0, "PEP", "Peperoni", 12.50, CategoriePizza.VIANDE);
	    Pizza p1 = new Pizza(1, "MAR", "Margherita", 14.00, CategoriePizza.VEGETARIEN);
	    Pizza p2 = new Pizza(2, "REI", "La Reine", 11.50, CategoriePizza.VIANDE);
	    Pizza p3 = new Pizza(3, "FRO", "Les 4 fromages", 12.00, CategoriePizza.FROMAGE);
	    Pizza p4 = new Pizza(4, "CAN", "La Cannibale", 12.50,CategoriePizza.VIANDE);
	    Pizza p5 = new Pizza(5, "SAV", "Savoyarde", 13.00, CategoriePizza.FROMAGE);
	    Pizza p6 = new Pizza(6, "ORI", "L'orientale", 13.50, CategoriePizza.VIANDE);
	    Pizza p7 = new Pizza(7, "IND", "L'indienne", 14.00, CategoriePizza.VEGETARIEN);
		
	   listPizza.add(p0);
	   listPizza.add(p1);
	   listPizza.add(p2);
	   listPizza.add(p3);
	   listPizza.add(p4);
	   listPizza.add(p5);
	   listPizza.add(p6);
	   listPizza.add(p7);
	   
	   
	}
	
	
	public List<Pizza> getListPizza() {
		return listPizza;
	}
	
	
	@Override
	public void displayAllPizza() {
		LOG.info(" code " + "  nom  " + "     prix  " + " categ " + "\n");
		for (Pizza pizza : listPizza) {
			System.out.println(pizza);
		}
		
	
		
		new AppService().executer("Client a sélectionné 1 pour La liste !");
	}
	
	
	@Override
	public void addPizza(Pizza pizza) {
		listPizza.add(pizza);
		new AppService().executer("Client a ajouté une pizza dans la liste !");
	}

	@Override
	public void addPizza( String code, String nom, double prix, CategoriePizza categoriePizza) {
		Pizza newPizza = new Pizza(code, nom, prix, categoriePizza);
		newPizza.setIndex(listPizza.size());
		
		listPizza.add(newPizza);
		
		
		new AppService().executer(
				"Client a ajouté une pizza dans la liste !" + "\n" + newPizza.getIndex()
		+" " + newPizza.getCode()+" "+ newPizza.getNom() + " " + newPizza.getPrix() + " "+ newPizza.getCategoriePizza()
		);
	}

	
	@Override
	public void updatePizza(int index, String code, String nom, double prix, CategoriePizza categoriePizza) {
		for (Pizza pizza : listPizza) {
			if(pizza.getIndex() == index){
				pizza.setCode(code);
				pizza.setNom(nom);
				pizza.setPrix(prix);
				pizza.setCategoriePizza(categoriePizza);
			}
		}
		new AppService().executer("Client a mise à jour la liste de pizzas !" + " nouvelle pizza est: " + index + " "
				+ code + " " + nom + " " + prix + " " + categoriePizza);
	}

	@Override
	public void deletePizza(int indexPizza)throws DeletePizzaException {
		
		boolean indexFound = false;
		 for (Pizza pizza : listPizza) {
			if(pizza.getIndex() == indexPizza){
				indexFound = true;
			}
		}
		
		if(indexFound){
			listPizza.remove(indexPizza);
			new AppService().executer("Client a supprimé une pizza à l'index: " + indexPizza + " " + listPizza.get(indexPizza).getNom());
			LOG.info("Supression OK !");
		}else{
			new AppService().executer(String.valueOf(DeletePizzaException.ERRTYPE_DELETE_PIZZA));
			new AppService().executer(DeletePizzaException.DELETEPIZZA_INDEX_NOT_CORRECT);
			throw new DeletePizzaException(DeletePizzaException.DELETEPIZZA_INDEX_NOT_CORRECT, DeletePizzaException.ERRTYPE_DELETE_PIZZA);
			
		}
		
		
		
		
		
	}


}
