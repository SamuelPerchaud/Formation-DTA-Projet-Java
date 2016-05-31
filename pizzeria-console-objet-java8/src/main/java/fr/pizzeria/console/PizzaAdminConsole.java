package fr.pizzeria.console;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.pizzeria.dao.DaoFactory;
import fr.pizzeria.dao.DaoProducer;
import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoDB;
import fr.pizzeria.dao.pizza.PizzaDaoFichier;
import fr.pizzeria.dao.pizza.PizzaDaoImpl;
import fr.pizzeria.dao.pizza.PizzaDaoJPA;
import fr.pizzeria.dao.pizza.PizzaDaoRest;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.ihm.menu.Menu;

public class PizzaAdminConsole {

	static IPizzaDao daoImpl;

	public static void main(String[] args) throws IOException, DaoException, ClassNotFoundException, SQLException {

		Locale.setDefault(Locale.FRENCH);
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String confString = bundle.getString("dao.impl");
		String confString2 = bundle.getString("dao.profile");
		System.err.println("INFO---- Valeur du parametre dao : " + confString +" valeur du profile : " +confString2);
		
		try (Scanner sc = new Scanner(System.in);
				ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(confString,
						"application-config.xml")) {
			Menu menu = context.getBean(Menu.class);
			java.util.logging.Logger.getLogger("SSL").setLevel(Level.SEVERE);
			menu.afficher();
		}

	}
}
