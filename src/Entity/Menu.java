package Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import Service.PizzaManage;

public class Menu {

	private Map<Integer,OptionMenu> actions;
	
	private ListerPizzasOptionMenu listerPizzaOptionMenu;
	private NouvellePizzaOptionMenu nouvellePizzaOptionMenu;
	private MisAJourOptionMenu misAJourOptionMenu;
	private SupressionPizzaOptionMenu supressionPizzaOtionMenu;
	private PizzaManage pizzaManager;
	
	
	public Menu() {
		pizzaManager = new PizzaManage();
		listerPizzaOptionMenu = new ListerPizzasOptionMenu(pizzaManager);
		nouvellePizzaOptionMenu = new NouvellePizzaOptionMenu(pizzaManager);
		misAJourOptionMenu = new MisAJourOptionMenu(pizzaManager);
		supressionPizzaOtionMenu = new SupressionPizzaOptionMenu(pizzaManager);
		
		actions = new HashMap<Integer,OptionMenu>();
		actions.put(1, listerPizzaOptionMenu);
		actions.put(2, nouvellePizzaOptionMenu);
		actions.put(3, misAJourOptionMenu);
		actions.put(4, supressionPizzaOtionMenu);
		 
	}
	
	
	public void afficher(){
		Scanner sc = new Scanner(System.in);
		
		while(true){
			
		System.out.println("====================================");
        System.out.println("******Pizzeria Administration******");
        System.out.println("====================================");
        
        Collection<OptionMenu> optionsMenu = actions.values();
        for (OptionMenu optionMenu : optionsMenu) {
			System.out.println(optionMenu.getLibelle());
		}
        
        
        System.out.println("99/ Sortir");
        System.out.print("====> Entrer votre choix : " + "\n");
		
        int choix = sc.nextInt();
        
        for (Integer mapKey : actions.keySet()) {
        	//actions.get(mapKey) => values;
        	
        	if(choix == 1){
        		actions.get(1).execute();
        		break;
        	}else if(choix == 2){
        		actions.get(2).execute();
        		break;
        	}else if(choix == 3){
        		actions.get(3).execute();
        		break;
        	}else if(choix == 4){
        		actions.get(4).execute();
        		break;
        	}else{
        		System.out.println("Au revoir");
        		System.exit(0);
        		
        	}
        }
    }
	
	}
}
