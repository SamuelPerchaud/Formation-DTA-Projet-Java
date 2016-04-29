package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaOptionMenu extends AbstractOptionMenu {

	private static final String AJOUTER_PIZZAS_LIBELLE_MENU = "ajouter une Pizzas";
	private Scanner sc;

	public AjouterPizzaOptionMenu(Scanner sc, IPizzaDao pizzaDao) {
		super(AJOUTER_PIZZAS_LIBELLE_MENU, pizzaDao);
		this.sc = sc;
	}

	@Override
	public boolean execute() {
		Pizza newPizza = new Pizza();
		System.out.println("entré le code de la nouvelle pizza");
		newPizza.code = sc.next();
		System.out.println("entré le nom de la nouvelle pizza");
		newPizza.nom = sc.next();
		System.out.println("entré le prix de la nouvelle pizza");
		newPizza.prix = sc.nextDouble();

		boolean resultat = true;

		try {
			pizzaDao.savePizza(newPizza);
		} catch (DaoException e) {
			System.err.println("erreur sur la methode savepizza");
			e.printStackTrace();
		}

		return resultat;
	}

}