package fr.pizzeria.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import fr.pizzeria.dao.pizza.IPizzaDao;

public class PizzaDaoDbSpringTemplateTest extends PizzaDaoDBSpringTest {
	
	@Autowired
	public void setPizzaDao(@Qualifier("pizzaDaoDBSpring") IPizzaDao pizzaDao){
		this.pizzaDao = pizzaDao;
	}

}
