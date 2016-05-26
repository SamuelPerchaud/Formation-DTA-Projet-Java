package fi.pizzeria.admin.metier;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

public class PizzaService  {
	@Inject private IPizzaDao pizzaDao;

	
	public List<Pizza> findAllPizzas() throws DaoException, SQLException {
		// TODO Auto-generated method stub
		return pizzaDao.findAllPizzas();
	}

	
	public void savePizza(Pizza newPizza) throws DaoException, SQLException {
		 pizzaDao.savePizza(newPizza);		
	}

	
	public void updatePizza(String codePizza, Pizza updatePizza) throws DaoException, SQLException {
		pizzaDao.updatePizza(codePizza, updatePizza);		
	}

	
	public void deletePizza(String codePizza) throws DaoException, SQLException {
		pizzaDao.deletePizza(codePizza);
		
	}

	
	public void importPizza() throws DaoException, SQLException {
		pizzaDao.importPizza();		
	}
}
