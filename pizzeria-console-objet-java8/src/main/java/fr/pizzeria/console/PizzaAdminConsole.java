package fr.pizzeria.console;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.pizzeria.console.configSpring.PizzeriaAppSpringConfig;
import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.ihm.menu.Menu;

public class PizzaAdminConsole {

	static IPizzaDao daoImpl;

	public static void main(String[] args) throws IOException, DaoException, ClassNotFoundException, SQLException {
		java.util.logging.Logger.getLogger("SSL").setLevel(Level.SEVERE);
		java.util.logging.Logger.getLogger("org").setLevel(Level.SEVERE);
		Locale.setDefault(Locale.FRENCH);
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String confString = bundle.getString("dao.impl");
		String confString2 = bundle.getString("dao.profile");
		System.err.println("INFO---- Valeur du parametre dao : " + confString + " valeur du profile : " + confString2);
		// Scanner sc = new Scanner(System.in);
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PizzeriaAppSpringConfig.class)) {
			Menu menu = context.getBean(Menu.class);

			menu.afficher();
		}

	}
}
