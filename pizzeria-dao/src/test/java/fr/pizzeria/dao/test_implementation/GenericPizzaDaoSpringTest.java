package fr.pizzeria.dao.test_implementation;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.dao.config.PizzaDaoConfigJDBC;
import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoDBSpring;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public abstract class GenericPizzaDaoSpringTest {

	private static final int NB_PIZZA_DE_DEPART = 4;

	protected IPizzaDao pizzaDao;

	@Test
	public void testfindAllPizzas() throws DaoException, SQLException {
		List<Pizza> pizzas = pizzaDao.findAllPizzas();
		Assert.assertEquals(NB_PIZZA_DE_DEPART, pizzas.size());
	}
	
	@Test
	public void testsavePizza() throws DaoException, SQLException {
//		System.out.println("Pizza de depart : " + NB_PIZZA_DE_DEPART);
//		Pizza testAjout = new Pizza("PEP 1","test", BigDecimal.valueOf(12.50), CategoriePizza.VIANDE);
//		System.out.println(testAjout);
//		List<Pizza> pizzas = pizzaDao.findAllPizzas();
//		System.out.println(pizzas.size());
//		pizzaDao.savePizza(testAjout);
//		List<Pizza> pizzas2 = pizzaDao.findAllPizzas();
//		System.out.println("nombre de Pizzas après ajout : " + pizzas2.size());
//		Assert.assertEquals((NB_PIZZA_DE_DEPART + 1), pizzas2.size());
	}
	

	@Test
	public void testimportPizza() throws DaoException, SQLException {
//		System.out.println("Pizza de depart : " + NB_PIZZA_DE_DEPART);
//		List<Pizza> pizzas = pizzaDao.findAllPizzas();
//		pizzaDao.importPizza();
//		List<Pizza> pizzas2 = pizzaDao.findAllPizzas();
//		System.out.println("nombre de Pizzas après import : " + pizzas2.size());
//		Assert.assertEquals((NB_PIZZA_DE_DEPART + 5), pizzas2.size());
	}

	@Test
	public void testrollback() throws DaoException, SQLException {
//		List<Pizza> pizzas = getListePizzasWithErrors();
////		System.out.println("Pizza de depart : " + NB_PIZZA_DE_DEPART);
//
//		try {
//			pizzaDao.saveAllPizzas(pizzas);
//		} catch (DataAccessException e) {
//
//		}
//
////		pizzaDao.importPizza();
//		List<Pizza> pizzas2 = pizzaDao.findAllPizzas();
//		System.out.println("nombre de Pizzas après la save : " + pizzas2.size());
//		Assert.assertEquals((NB_PIZZA_DE_DEPART + 3), pizzas2.size());
	}

	private List<Pizza> getListePizzas() {
		return null;
//		List<Pizza> pizzas = new ArrayList<>();
//		pizzas.add(new Pizza(null, "PEP 1", BigDecimal.valueOf(12.50), CategoriePizza.VIANDE));
//		pizzas.add(new Pizza(null, "MAR 1", BigDecimal.valueOf(14.00), CategoriePizza.SANS_VIANDE));
//		pizzas.add(new Pizza(null, "IND 1", BigDecimal.valueOf(14.00), CategoriePizza.VIANDE));
//		pizzas.add(new Pizza(null, "SAU 1", BigDecimal.valueOf(14.00), CategoriePizza.POISSON));
//
//		return pizzas;
	}

	private List<Pizza> getListePizzasWithErrors() {
		List<Pizza> pizzas = getListePizzas();
		pizzas.add(new Pizza("120", "IND 1", BigDecimal.valueOf(14.00), CategoriePizza.VIANDE));

		return pizzas;
	}

}
