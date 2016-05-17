package fr.pizzeria.console;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoFichier;
import fr.pizzeria.dao.PizzaDaoDB;

import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.dao.PizzaDaoJPA;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.ihm.menu.Menu;

//test modif
public class PizzaAdminConsole {

	// static boolean dao_impl;
	static IPizzaDao daoImpl;

	public static void main(String[] args) throws IOException, DaoException, ClassNotFoundException, SQLException {
		// System.err.println("INFO---- test toujours en cours");
		System.err.println("INFO---- test toujours en cours");
		Locale.setDefault(Locale.FRENCH);
		// System.err.println("entre prog");
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String confString = bundle.getString("dao.impl");
		Integer dao = Integer.valueOf(confString);
		// System.err.println(dao);
		// HashCodeBuilder a = new HashCodeBuilder(12,44);
		System.err.println("INFO---- Valeur du parametre dao : " + dao);
		System.err.println("INFO---- Stockage sur fichier en cours de developpement");

		try (Scanner sc = new Scanner(System.in)) {
			EntityManagerFactory entityManagerFactory;
			switch (dao) {
			case (2):
				System.err.println("INFO---- Stockage des données en mémoire");
				daoImpl = new PizzaDaoImpl();
				break;
			case (1):
				System.err.println("INFO---- Stockage des données dans les fichiers");

				daoImpl = new PizzaDaoFichier();
				break;

			case (3):
				System.err.println("INFO---- Stockage des données sur la BDD");
				Class.forName("com.mysql.jdbc.Driver");
				daoImpl = new PizzaDaoDB();
				break;
			case (0):
				System.err.println("INFO---- Stockage des données sur la BDD avec JPA");
				//Class.forName("com.mysql.jdbc.Driver");
			java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.WARNING);
			//java.util.logging.Logger.getLogger("SSL").setLevel(Level.SEVERE);
			//System.setProperty("jsse.enableSNIExtension", "false");
		    entityManagerFactory = Persistence.createEntityManagerFactory( "pizzeria-console-objet-java8" );

				daoImpl = new PizzaDaoJPA(entityManagerFactory);
				break;
				
				
			default:
				System.err.println("INFO---- Aucun parametre de config");

			}

			Menu menu = new Menu(sc, daoImpl);
			menu.afficher();
		}

	}
}
