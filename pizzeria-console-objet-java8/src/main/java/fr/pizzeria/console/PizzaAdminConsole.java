package fr.pizzeria.console;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoFichier;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.ihm.menu.Menu;

public class PizzaAdminConsole {

	// static boolean dao_impl;
	static IPizzaDao daoImpl;

	public static void main(String[] args) throws IOException, DaoException {
		System.err.println("entre prog");
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String confString = bundle.getString("dao.impl");
		Integer dao = Integer.valueOf(confString);
		System.err.println(dao);
		// HashCodeBuilder a = new HashCodeBuilder(12,44);
		try (Scanner sc = new Scanner(System.in)) {
			switch (dao) {
			case (0):
				System.err.println("test 1");
				daoImpl = new PizzaDaoImpl();
				break;
			case (1):
				System.err.println("test 2");

				daoImpl = new PizzaDaoFichier();
				break;
			default:
				System.err.println("aucun parametre de config");


			}


			Menu menu = new Menu(sc, daoImpl);
			menu.afficher();
		}

	}
}
