package fr.pizzeria.dao;

import fr.pizzeria.dao.client.IClientDao;
import fr.pizzeria.dao.pizza.IPizzaDao;

public class DaoFactoryJPA implements DaoFactory{
private IPizzaDao pizzaDao;
private IClientDao clientDao;
@Override
public IClientDao getClientDao() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public IPizzaDao getPizzaDao() {
	// TODO Auto-generated method stub
	return null;
}
}
