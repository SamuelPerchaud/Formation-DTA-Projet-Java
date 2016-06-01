package fr.pizzeria.dao;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.dao.pizza.PizzaDaoDBSpring;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PizzaDaoSpringTest.class)
public class PizzaDaoDBSpringTest {
	@Autowired
	private PizzaDaoDBSpring pizzaDaoDBSpring;

	@Test
	public void testfindAllPizzas() throws DaoException, SQLException {
		List<Pizza> pizzas = pizzaDaoDBSpring.findAllPizzas();
		Assert.assertEquals(4, pizzas.size());
	}
	
	@Test
	public void testimportPizza() throws DaoException, SQLException {
//		List<Pizza> pizzas = pizzaDaoDBSpring.findAllPizzas();
//		pizzaDaoDBSpring.importPizza();
//		List<Pizza> pizzas2 = pizzaDaoDBSpring.findAllPizzas();
//		System.out.println(pizzas.size() + "et "+pizzas2.size());
//		Assert.assertEquals(pizzas2.size(), pizzas.size());
	}

}
