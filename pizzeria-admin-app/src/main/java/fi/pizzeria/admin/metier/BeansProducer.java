package fi.pizzeria.admin.metier;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoImpl;

public class BeansProducer {

	
	@Produces
	@ApplicationScoped
	public static IPizzaDao getImpl(){
		return new PizzaDaoImpl();
	}
}
