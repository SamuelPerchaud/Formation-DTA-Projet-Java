package fr.pizzeria.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.test_implementation.GenericPizzaDaoSpringTest;

public class PizzaDaoDbSpringTemplateTest extends GenericPizzaDaoSpringTest {
	
	@Autowired
	public void setPizzaDao(@Qualifier("pizzaDaoJPASpring") IPizzaDao pizzaDao){
		this.pizzaDao = pizzaDao;
	}

}
