package fr.pizzeria.dao.pizza;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import fr.pizzeria.exception.*;
//import fr.pizzeria.exception.DeletePizzaException;
//import fr.pizzeria.exception.SavePizzaException;
//import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;


public class PizzaDaoImpl implements IPizzaDao {
	
	private Map<String, Pizza> pizzas = new HashMap<String, Pizza>();

	public PizzaDaoImpl() {
		pizzas.put("PEP", new Pizza("PEP", "Pépéroni", new BigDecimal("12.50"), CategoriePizza.VIANDE));
		pizzas.put("MAR", new Pizza("MAR", "Margherita",new BigDecimal("11.40"),  CategoriePizza.SANS_VIANDE));
		pizzas.put("REI", new Pizza("REI", "La Reine",new BigDecimal("12.50"), CategoriePizza.VIANDE));
		pizzas.put("FRO", new Pizza("FRO", "La 4 fromages",new BigDecimal("12.50"),  CategoriePizza.SANS_VIANDE));
		pizzas.put("CAN", new Pizza("CAN", "La cannibale",new BigDecimal("12.50"), CategoriePizza.VIANDE));
		pizzas.put("SAV", new Pizza("SAV", "La savoyarde",new BigDecimal("12.50"), CategoriePizza.VIANDE));
		pizzas.put("ORI", new Pizza("ORI", "L'orientale",new BigDecimal("12.50"), CategoriePizza.VIANDE));
		pizzas.put("IND", new Pizza("IND", "L'indienne",new BigDecimal("12.50"), CategoriePizza.VIANDE));
		pizzas.put("SAU", new Pizza("SAU", "La Saumonéta",new BigDecimal("12.40"), CategoriePizza.POISSON));
	}
	
	@Override
	public List<Pizza> findAllPizzas() {
		return new ArrayList<Pizza>(pizzas.values());
	}

	@Override
	public void savePizza(Pizza newPizza) throws DaoException {
		if(pizzas.containsKey(newPizza.getCode())) {
			throw new SavePizzaException("code pizza déjà présent");
		}
		pizzas.put(newPizza.getCode(), newPizza);
		
	}

	@Override
	public void updatePizza(String codePizza, Pizza updatePizza) throws DaoException {
		if(!pizzas.containsKey(codePizza)) {
			throw new UpdatePizzaException("code pizza non trouvé");
		}
		pizzas.put(codePizza, updatePizza);
	}

	@Override
	public void deletePizza(String codePizza) throws DaoException {
		if(!pizzas.containsKey(codePizza)) {
			throw new DeletePizzaException("code pizza non trouvé");
		}
		pizzas.remove(codePizza);
	}

	@Override
	public void importPizza() throws DaoException, SQLException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 */
	

}
