package fr.pizzeria.console;

import java.util.Scanner;
import java.util.logging.Level;

import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;

import fr.pizzeria.dao.DaoFactory;
import fr.pizzeria.dao.DaoProducer;
import fr.pizzeria.ihm.menu.Menu;

public class PizzeriaClientApp {

	
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory;
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.WARNING);

	    entityManagerFactory = Persistence.createEntityManagerFactory( "pizzeria-console-client" );

		DaoFactory dao = new DaoProducer().getDaoFactoryJPA(entityManagerFactory);
		
		try (Scanner sc = new Scanner(System.in)) {

			Menu menu = new Menu(sc,dao);
			menu.afficher();
		}
		
		
		
	}
	
	
	

	

}
