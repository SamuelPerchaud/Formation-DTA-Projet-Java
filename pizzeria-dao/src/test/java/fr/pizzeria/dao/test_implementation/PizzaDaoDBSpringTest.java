package fr.pizzeria.dao.test_implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;

import fr.pizzeria.dao.config.PizzaDaoConfigJDBC;
import fr.pizzeria.dao.pizza.IPizzaDao;

@ContextConfiguration(classes=PizzaDaoConfigJDBC.class)
public class PizzaDaoDBSpringTest extends GenericPizzaDaoSpringTest {
	
	@Autowired
	public void setPizzaDao(@Qualifier("pizzaDaoDBSpring") IPizzaDao pizzaDao) {
		this.pizzaDao = pizzaDao;
	}

}
