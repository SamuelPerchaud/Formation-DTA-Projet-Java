package fr.pizzeria.ihm.menu;

import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.ihm.menu.option.AbstractOptionMenu;
import fr.pizzeria.ihm.menu.option.AjoutMassifOptionMenu;
import fr.pizzeria.ihm.menu.option.AjouterNouvellePizzaOptionMenu;
import fr.pizzeria.ihm.menu.option.ListerPizzaGroupeOptionMenu;
import fr.pizzeria.ihm.menu.option.ListerPizzaOptionMenu;
import fr.pizzeria.ihm.menu.option.MettreAJourPizzaOptionMenu;
import fr.pizzeria.ihm.menu.option.QuitterOptionMenu;
import fr.pizzeria.ihm.menu.option.SupprimerPizzaOptionMenu;
import fr.pizzeria.ihm.menu.option.TrouverPizzaMaxOptionMenu;

@Component
public class Menu {

	private static final String MENU_TITRE_LIBELLE = "Application Pizzeria Console";
	private Map<Integer, AbstractOptionMenu> options = new TreeMap<Integer, AbstractOptionMenu>();
	private Scanner sc;
	@Autowired
	public Menu(Scanner sc, IPizzaDao pizzaDao) {
		super();
		initialiserOptions(sc, pizzaDao);
		this.sc = sc;
	}

	private void initialiserOptions(Scanner scanner, IPizzaDao pizzaDao) {
		options.put(1, new ListerPizzaOptionMenu(pizzaDao));
		options.put(5, new ListerPizzaGroupeOptionMenu(pizzaDao));
		options.put(2, new AjouterNouvellePizzaOptionMenu(scanner, pizzaDao));
		options.put(3, new MettreAJourPizzaOptionMenu(scanner, pizzaDao));
		options.put(4, new SupprimerPizzaOptionMenu(scanner, pizzaDao));
		options.put(6, new TrouverPizzaMaxOptionMenu(pizzaDao));
		options.put(7, new AjoutMassifOptionMenu(pizzaDao));
		options.put(99, new QuitterOptionMenu());
	}

	public void afficher() throws DaoException, SQLException {
		boolean continuer = true;
		while (continuer) {
			System.out.println("**** " + MENU_TITRE_LIBELLE + " ****");
			
			options.entrySet().stream()
			.forEach(optionMenuEntry -> System.out.println(optionMenuEntry.getKey()+" : "+optionMenuEntry.getValue().getLibelle()));


			int saisie = sc.nextInt();
			continuer = options.get(saisie).execute();
		}
	}

}
