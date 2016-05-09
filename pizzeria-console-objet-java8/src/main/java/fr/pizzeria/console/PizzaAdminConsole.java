package fr.pizzeria.console;

import java.io.IOException;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoFichier;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.ihm.menu.Menu;

public class PizzaAdminConsole {

	public static void main(String[] args) throws IOException, DaoException {
		


		
		
		try(Scanner sc = new Scanner(System.in)) {
			IPizzaDao dao = new PizzaDaoFichier();
			Menu menu = new Menu(sc,dao);
			menu.afficher();
		}
		
	}
	
	
}
