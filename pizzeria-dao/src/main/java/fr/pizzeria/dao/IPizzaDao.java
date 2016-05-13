package fr.pizzeria.dao;


import java.sql.SQLException;
import java.util.List;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	
	List<Pizza> findAllPizzas() throws DaoException, SQLException;
	void savePizza(Pizza newPizza) throws DaoException, SQLException;
	void updatePizza(String codePizza, Pizza updatePizza) throws DaoException;
	void deletePizza(String codePizza) throws DaoException, SQLException;

}
