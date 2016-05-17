package fr.pizzeria.dao;

import org.apache.commons.lang3.NotImplementedException;

import fr.pizzeria.dao.client.IClientDao;
import fr.pizzeria.dao.pizza.IPizzaDao;

public class GenericFactoryImpl implements DaoFactory {
	private IPizzaDao pizzaDao;
	private IClientDao clientDao;

	GenericFactoryImpl(IPizzaDao pizzaDao, IClientDao ClientDao) {
		super();
		this.pizzaDao = pizzaDao;
		this.clientDao = clientDao;
	}

	public IPizzaDao getPizzaDao() {
		check(pizzaDao);
		return pizzaDao;
	}

	@Override
	public IClientDao getClientDao() {
		check(clientDao);
		return clientDao;

	}

	private void check(Object implementation) {
		if (implementation == null) {
			throw new NotImplementedException("Dao non implémenté");
		}
	}

}
