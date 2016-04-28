package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class SupprimerPizzaOptionMenu extends AbstractOptionMenu {

	private static final String SUPPRIMER_PIZZAS_LIBELLE_MENU = "supprimer une Pizzas";
	private Scanner sc;

	public SupprimerPizzaOptionMenu(Scanner sc,IPizzaDao pizzaDao) {
		super(SUPPRIMER_PIZZAS_LIBELLE_MENU, pizzaDao);
		this.sc = sc;
	}

	@Override
	public boolean execute() {
		Pizza newPizza = new Pizza();
		System.out.println("entré le code");
		newPizza.code = sc.next();
		System.out.println("entré le nom");
		newPizza.nom = sc.next();
		System.out.println("entré le prix");
		newPizza.prix = sc.nextDouble();
		
		boolean resultat = pizzaDao.savePizza(newPizza);
		
		return resultat;
	}

}