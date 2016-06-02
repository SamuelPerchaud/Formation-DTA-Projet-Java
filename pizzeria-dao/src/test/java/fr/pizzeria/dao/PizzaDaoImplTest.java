package fr.pizzeria.dao;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.pizzeria.dao.pizza.PizzaDaoImpl;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplTest {

	//private static final Class<? extends Throwable> SavePizzaException = null;
	private ArrayList<Pizza> pizzasTest;
	private PizzaDaoImpl pizzaDao;

	@Before
	public void setUp() {
		 pizzaDao = new PizzaDaoImpl();
		 pizzasTest = new ArrayList<Pizza>();
		 
		pizzasTest.add(new Pizza("PEP", "Pépéroni", BigDecimal.valueOf(12.50), CategoriePizza.VIANDE));
		pizzasTest.add( new Pizza("MAR", "Margherita", BigDecimal.valueOf(12.50), CategoriePizza.SANS_VIANDE));
		pizzasTest.add( new Pizza("REI", "La Reine", BigDecimal.valueOf(12.50), CategoriePizza.VIANDE));
		pizzasTest.add( new Pizza("FRO", "La 4 fromages",BigDecimal.valueOf(12.50), CategoriePizza.SANS_VIANDE));
		pizzasTest.add( new Pizza("CAN", "La cannibale", BigDecimal.valueOf(12.50), CategoriePizza.VIANDE));
		pizzasTest.add( new Pizza("SAV", "La savoyarde", BigDecimal.valueOf(12.50), CategoriePizza.VIANDE));
		pizzasTest.add( new Pizza("ORI", "L'orientale", BigDecimal.valueOf(12.50), CategoriePizza.VIANDE));
		pizzasTest.add( new Pizza("IND", "L'indienne", BigDecimal.valueOf(12.50), CategoriePizza.VIANDE));
		pizzasTest.add( new Pizza("SAU", "La Saumonéta", BigDecimal.valueOf(12.50), CategoriePizza.POISSON));
		pizzasTest.sort(Comparator.comparing(Pizza::getCode));

	}

	@Test
	public void testfindAllPizzas() {
		// pizzaDao.findAllPizzas().stream()
		// .forEach(listePizzas);

		/**List<Pizza> pizzas = pizzaDao.findAllPizzas();
		pizzas.sort(Comparator.comparing(Pizza::getCode));
		Pizza[] tabPizza = pizzas.<Pizza>toArray(new Pizza[0]);
		Pizza[] tabPizzaTest = pizzasTest.<Pizza>toArray(new Pizza[0]);
		assertArrayEquals(tabPizza, tabPizzaTest);
		//fail("Not yet implemented");
*/
	}




	/**
	 * private boolean asserEquals(List<Pizza> pizzas, Map<String, Pizza>
	 * pizzasTest2) { pizzas.toArray();
	 * 
	 * 
	 * return false; }
	 */
	//SavePizzaException
	@Test(expected = SavePizzaException.class)
	public void testPizzasavePizza_codeExistant() throws DaoException {
		Pizza newPizza =  new Pizza("PEP", "Pépéroni", BigDecimal.valueOf(12.50), CategoriePizza.VIANDE);
		pizzaDao.savePizza(newPizza);
		
		
		//fail("Not yet implemented");

	}

	@Test
	public void testupdatePizza() {
		//fail("Not yet implemented");

	}

	@Test
	public void testdeletePizza() {
		//fail("Not yet implemented");

	}

}
