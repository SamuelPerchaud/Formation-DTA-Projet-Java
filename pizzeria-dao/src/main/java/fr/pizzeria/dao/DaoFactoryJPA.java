package fr.pizzeria.dao;

import javax.persistence.EntityManagerFactory;

import fr.pizzeria.dao.client.ClientDaoJPA;
import fr.pizzeria.dao.client.IClientDao;
import fr.pizzeria.dao.pizza.IPizzaDao;

public class DaoFactoryJPA implements DaoFactory{
private IPizzaDao pizzaDao;
private IClientDao clientDao;

@Override
public IClientDao getClientDao() {
	return null;
}
@Override
public IPizzaDao getPizzaDao() {
	// TODO Auto-generated method stub
	return null;
}
}
