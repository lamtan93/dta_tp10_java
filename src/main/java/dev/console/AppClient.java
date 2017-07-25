package dev.console;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.dao.PizzaDaoJpa;
import dev.entity.Client;
import dev.utils.CrypterPasswords;

public class AppClient {

	private static final Logger LOG = LoggerFactory.getLogger(AppClient.class);
	
	
	
	public static void main(String [] args){
		
		PizzaDaoJpa jpa = new PizzaDaoJpa();
		Scanner sc  = new Scanner(System.in);
		
		int choix;
		String nom;
		String prenom;
		String email;
		String passwords;
		String indexPizzaChoosen;
		
		do{
			
			LOG.info("********Pizzeria Client********");
			LOG.info("1. S'incrire");
			LOG.info("2. Se connecter");
			LOG.info("99. Sortir");
			
			choix = sc.nextInt();
			
			switch (choix) {
			case 1:
				LOG.info("Quel est votre nom ?");
				nom = sc.next();
				LOG.info("Quel est votre prenom ?");
				prenom = sc.next();
				LOG.info("Quel est votre email ?");
				email = sc.next();
				LOG.info("Quel est votre mot de passe ?");
				passwords = sc.next();
				jpa.registerCustomer(new Client(nom, prenom, email, CrypterPasswords.md5(passwords)));
				break;
			case 2:
				LOG.info("Quel est votre email ?");
				email = sc.next();
				LOG.info("Quel est votre mot de passe ?");
				passwords = sc.next();
				
				if(jpa.logInCustomer(email, passwords)){
					jpa.commandPizza();
					
					do{
						LOG.info("Quelle(s) pizza(s) que vous voulez commander ? (Taper 'Fin' pour terminer)");
						indexPizzaChoosen = sc.next();
						jpa.allPizzasIdChoosenByCustomer(indexPizzaChoosen);
					}while(!indexPizzaChoosen.equalsIgnoreCase("Fin"));
					
				}
				
				break;
			case 3:
				break;

			default:
				break;
			}
			
		}while(choix != 99);
		
		
	}
}
