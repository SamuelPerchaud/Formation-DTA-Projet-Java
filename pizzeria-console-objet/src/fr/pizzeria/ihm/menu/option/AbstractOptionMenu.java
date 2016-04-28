package fr.pizzeria.ihm.menu.option;

import fr.pizzeria.dao.IPizzaDao;

public abstract class AbstractOptionMenu {
	private String libelle;
	protected IPizzaDao pizzaDao;

	/**
	 * @param libelle
	 */
	public AbstractOptionMenu(String libelle) {
		super();
		this.libelle = libelle;
	}
	public AbstractOptionMenu(String libelle,IPizzaDao pizzaDao) {
		super();
		this.libelle = libelle;
		this.pizzaDao = pizzaDao;
	}

	public String getLibelle() {
		return libelle;
	}

	public abstract boolean execute();
}
