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
		System.err.println("INFO---- test toujours en cours");


		//System.err.println("entre prog");
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String confString = bundle.getString("dao.impl");
		Integer dao = Integer.valueOf(confString);
		//System.err.println(dao);
		// HashCodeBuilder a = new HashCodeBuilder(12,44);
		System.err.println("INFO---- Valeur du parametre dao : "+dao+"    (0 = mémoire/1 = fichier)");
		System.err.println("INFO---- Stockage sur fichier en cours de developpement");

		try (Scanner sc = new Scanner(System.in)) {
			switch (dao) {
			case (0):
				System.err.println("INFO---- Stockage des données en mémoire");
				daoImpl = new PizzaDaoImpl();
				break;
			case (1):
				System.err.println("INFO---- Stockage des données dans les fichiers");

				daoImpl = new PizzaDaoFichier();
				break;
			default:
				System.err.println("INFO---- Aucun parametre de config");


			}


			Menu menu = new Menu(sc, daoImpl);
			menu.afficher();
		}

	}
}
