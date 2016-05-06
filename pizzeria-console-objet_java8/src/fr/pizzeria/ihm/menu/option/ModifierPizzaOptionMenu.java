package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends AbstractOptionMenu {

	private static final String MODIFIER_PIZZAS_LIBELLE_MENU = "modifier une Pizzas";
	private Scanner sc;

	public ModifierPizzaOptionMenu(Scanner sc,IPizzaDao pizzaDao) {
		super(MODIFIER_PIZZAS_LIBELLE_MENU, pizzaDao);
		this.sc = sc;
	}

	@Override
	public boolean execute() {
		Pizza Pizza = new Pizza();
		System.out.println("entré le code de la pizza a modifier");
		String codePizza = sc.next();
		System.out.println("entré le code de la nouvelle pizza");
		Pizza.code = sc.next();
		System.out.println("entré le nom de la nouvelle pizza");
		Pizza.nom = sc.next();
		System.out.println("entré le prix de la nouvelle pizza");
		Pizza.prix = sc.nextDouble();
		
		
		
		
		//System.out.println("entré le nom");
		//newPizza.nom = sc.next();
		//System.out.println("entré le prix");
		//newPizza.prix = sc.nextDouble();
		
		
		
		try {
			pizzaDao.updatePizza( codePizza, Pizza);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
		
	}

}