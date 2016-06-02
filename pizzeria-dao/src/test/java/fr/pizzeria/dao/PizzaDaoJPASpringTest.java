package fr.pizzeria.dao;

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

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoDBSpring;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PizzaDaoConfigTest.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public abstract class PizzaDaoJPASpringTest {

	private static final int NB_PIZZA_DE_DEPART = 4;
	@Autowired
	protected IPizzaDao pizzaDao;

	@Test
	public void testfindAllPizzas() throws DaoException, SQLException {
		List<Pizza> pizzas = pizzaDao.findAllPizzas();
		Assert.assertEquals(NB_PIZZA_DE_DEPART, pizzas.size());
	}

	@Test
	// @DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
	public void testimportPizza() throws DaoException, SQLException {
		System.out.println("Pizza de depart : " + NB_PIZZA_DE_DEPART);
		List<Pizza> pizzas = pizzaDao.findAllPizzas();
		pizzaDao.importPizza();
		List<Pizza> pizzas2 = pizzaDao.findAllPizzas();
		System.out.println("nombre de Pizzas après import : " + pizzas2.size());
		Assert.assertEquals((NB_PIZZA_DE_DEPART + 5), pizzas2.size());
	}

	@Test
	// @DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
	public void testrollback() throws DaoException, SQLException {
		List<Pizza> pizzas = getListePizzasWithErrors();
//		System.out.println("Pizza de depart : " + NB_PIZZA_DE_DEPART);

		try {
			pizzaDao.saveAllPizzas(pizzas);
		} catch (DataAccessException e) {

		}

//		pizzaDao.importPizza();
		List<Pizza> pizzas2 = pizzaDao.findAllPizzas();
		System.out.println("nombre de Pizzas après la save : " + pizzas2.size());
		Assert.assertEquals((NB_PIZZA_DE_DEPART + 3), pizzas2.size());
	}

	private List<Pizza> getListePizzas() {
		List<Pizza> pizzas = new ArrayList<>();
		pizzas.add(new Pizza(null, "PEP 1", BigDecimal.valueOf(12.50), CategoriePizza.VIANDE));
		pizzas.add(new Pizza(null, "MAR 1", BigDecimal.valueOf(14.00), CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza(null, "IND 1", BigDecimal.valueOf(14.00), CategoriePizza.VIANDE));
		pizzas.add(new Pizza(null, "SAU 1", BigDecimal.valueOf(14.00), CategoriePizza.POISSON));

		return pizzas;
	}

	private List<Pizza> getListePizzasWithErrors() {
		List<Pizza> pizzas = getListePizzas();
		pizzas.add(new Pizza("120", "IND 1", BigDecimal.valueOf(14.00), CategoriePizza.VIANDE));

		return pizzas;
	}

}
