package fr.pizzeria.dao;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaExeption;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	
	Pizza[] findAllPizzas();
	void savePizza(Pizza newPizza) throws DaoException;
	void updatePizza(String codePizza, Pizza updatePizza) throws DaoException;
	void deletePizza(String codePizza) throws DaoException;

}