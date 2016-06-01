package fr.pizzeria.ihm.menu.option;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoDB;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

public class SuppresionMassifOptionMenu  extends AbstractOptionMenu {

	private static final String LISTER_PIZZAS_LIBELLE_MENU = "Suppresion MASSIF";

	
	
	public SuppresionMassifOptionMenu(IPizzaDao pizzaDao) {
		super(LISTER_PIZZAS_LIBELLE_MENU, pizzaDao);
	}

	@Override
	public boolean execute() throws DaoException, SQLException {
		pizzaDao.findAllPizzas()
		.forEach(p -> {
			try {
				pizzaDao.deletePizza(p.getCode());
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		
		
		
		
		
		
		return true;
	}

}
