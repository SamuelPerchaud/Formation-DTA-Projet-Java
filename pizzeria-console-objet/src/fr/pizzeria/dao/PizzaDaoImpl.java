package fr.pizzeria.dao;

//import java.util.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaExeption;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.TypePizza;

public class PizzaDaoImpl implements IPizzaDao {

	private Map<String, Pizza> pizzas = new HashMap<String, Pizza>();

	public PizzaDaoImpl() {
		pizzas.put("MAR", new Pizza("PEP", "pepe", 12,TypePizza.VIANDE ));
		//pizzas.put("PEP", new Pizza("PEP", "P�p�roni", 12.50,));
		pizzas.put("MAR", new Pizza("MAR", "Margherita", 14.00,TypePizza.VIANDE));
		pizzas.put("REI", new Pizza("REI", "La Reine", 11.50,TypePizza.VIANDE));
		pizzas.put("FRO", new Pizza("FRO", "La 4 fromages", 12.00,TypePizza.VIANDE));
		pizzas.put("CAN", new Pizza("CAN", "La cannibale", 12.50,TypePizza.SANS_VIANDE));
		pizzas.put("SAV", new Pizza("SAV", "La savoyarde", 13.00,TypePizza.VIANDE));
		pizzas.put("ORI", new Pizza("ORI", "L'orientale", 13.50,TypePizza.POISSON));
		pizzas.put("IND", new Pizza("IND", "L'indienne", 14.00,TypePizza.VIANDE));
	}

	@Override
	public List<Pizza> findAllPizzas() {

		// List<Pizza> resultat = new Pizza[100];
		// System.arraycopy(pizzas, 0, resultat, 0, resultat.length);
		return new ArrayList<Pizza>(pizzas.values());
	}

	@Override
	public void savePizza(Pizza newPizza) throws SavePizzaExeption {
		if (!pizzas.containsKey(newPizza.code)) {
			pizzas.put(newPizza.code, newPizza);
		} else {
			throw new SavePizzaExeption("erreur de cr�ation: pizza deja presente");

		}
		/*
		 * boolean placeTrouve = false; int index = 0; while (!placeTrouve &&
		 * index < pizzas.length) { placeTrouve = pizzas[index] == null; if
		 * (!placeTrouve) { index++; } }
		 * 
		 * if (placeTrouve) { pizzas[index] = newPizza; }else { throw new
		 * SavePizzaExeption("erreur de cr�ation"); }
		 */
	}

	@Override
	public void updatePizza(String codePizza, Pizza updatePizza) throws UpdatePizzaException {

		try {
			this.deletePizza(codePizza);
		} catch (DeletePizzaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.savePizza(updatePizza);
		} catch (SavePizzaExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deletePizza(String codePizza) throws DeletePizzaException {

		if (pizzas.containsKey(codePizza)) {
			pizzas.remove(codePizza);
		} else {
			throw new DeletePizzaException("erreur de suppresion, pas de pizza trouv�");

		}
		/*
		 * boolean pizzaTrouve = false; int index = 0; while (!pizzaTrouve &&
		 * index < pizzas.length) { if(pizzas[index]!=null){ pizzaTrouve =
		 * codePizza.equals(pizzas[index].code); } if (!pizzaTrouve) { index++;
		 * } }
		 * 
		 * if (pizzaTrouve) { pizzas[index] = null; }else { throw new
		 * DeletePizzaException("erreur de suppresion"); }
		 */
	}

}
