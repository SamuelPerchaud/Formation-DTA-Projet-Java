package fr.pizzeria.dao;

import javax.persistence.EntityManagerFactory;

import fr.pizzeria.dao.client.ClientDaoJPA;
import fr.pizzeria.dao.pizza.PizzaDaoJPA;

public class DaoProducer {

	
	public DaoFactory getDaoFactoryJPA(EntityManagerFactory emf){
		return new GenericFactoryImpl(new PizzaDaoJPA(emf), new ClientDaoJPA(emf));
	}
	
}
