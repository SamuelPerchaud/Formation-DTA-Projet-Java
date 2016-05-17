package fr.pizzeria.dao;

import fr.pizzeria.dao.client.IClientDao;
import fr.pizzeria.dao.pizza.IPizzaDao;

public interface DaoFactory {

	IClientDao getClientDao();
	IPizzaDao getPizzaDao();
}
