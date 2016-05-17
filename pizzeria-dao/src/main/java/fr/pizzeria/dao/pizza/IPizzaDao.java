package fr.pizzeria.dao.pizza;

import java.sql.SQLException;
import java.util.List;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao {

	List<Pizza> findAllPizzas() throws DaoException, SQLException;

	void savePizza(Pizza newPizza) throws DaoException, SQLException;

	void updatePizza(String codePizza, Pizza updatePizza) throws DaoException, SQLException;

	void deletePizza(String codePizza) throws DaoException, SQLException;

	void importPizza() throws DaoException, SQLException;

}
