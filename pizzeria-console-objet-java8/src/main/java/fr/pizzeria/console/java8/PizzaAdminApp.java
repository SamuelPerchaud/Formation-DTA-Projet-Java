package fr.pizzeria.console.java8;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaofichier;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.ihm.menu.Menu;

public class PizzaAdminApp {

	public static void main(String[] args) throws DaoException {
		try(Scanner sc = new Scanner(System.in)) {
			IPizzaDao dao = new PizzaDaofichier();
			Menu menu = new Menu(sc,dao);
			menu.afficher();
		}
		
	}

}
//test