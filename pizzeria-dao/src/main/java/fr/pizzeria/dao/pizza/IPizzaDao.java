package fr.pizzeria.dao.pizza;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.NotImplementedException;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	//IPizzaDao DEFAULT_IMPLEMENTATION = new PizzaDaoImpl();
	List<Pizza> findAllPizzas() throws DaoException, SQLException;

	void savePizza(Pizza newPizza) throws DaoException, SQLException;

	void updatePizza(String codePizza, Pizza updatePizza) throws DaoException, SQLException;

	void deletePizza(String codePizza) throws DaoException, SQLException;

	void importPizza() throws DaoException, SQLException;
	
	default public void saveAllPizzas(List<Pizza> listPizzas) throws DaoException {
		throw new NotImplementedException("saveAllPizzas non implémenté");
	}

}
