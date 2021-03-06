package fr.pizzeria.ihm.menu.option;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.Scanner;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoDB;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

public class AjoutMassifOptionMenu  extends AbstractOptionMenu {

	private static final String LISTER_PIZZAS_LIBELLE_MENU = "ajout MASSIF";

	
	
	public AjoutMassifOptionMenu(IPizzaDao pizzaDao) {
		super(LISTER_PIZZAS_LIBELLE_MENU, pizzaDao);
	}

	@Override
	public boolean execute() throws DaoException, SQLException {
		pizzaDao.importPizza();
		
		
		
		
		
		
		return true;
	}

}
