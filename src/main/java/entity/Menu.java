package entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import service.PizzaManage;


public class Menu {

	private static final Logger LOG = LoggerFactory.getLogger(Menu.class);

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
        
			LOG.info("====================================");
			LOG.info("******Pizzeria Administration******");
			LOG.info("====================================");


        Collection<OptionMenu> optionsMenu = actions.values();
        for (OptionMenu optionMenu : optionsMenu) {
				LOG.info(optionMenu.getLibelle());
		}
        
			LOG.info("99/ Sortir");
			LOG.info("====> Entrer votre choix : " + "\n");

		
        int choix = sc.nextInt();
        
        for (Integer mapKey : actions.keySet()) {
        	

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
					LOG.info("Au revoir !");
        		System.exit(0);
        		
        	}
        }
    }
	
	}
}
