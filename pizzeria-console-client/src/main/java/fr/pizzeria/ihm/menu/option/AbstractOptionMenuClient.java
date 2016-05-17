package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.DaoFactory;


public abstract class AbstractOptionMenuClient {
	private String libelle;
	protected DaoFactory daoFactory;
	protected Scanner sc;
	



	/**
	 * @param libelle
	 * @param daoFactory
	 * @param sc
	 */
	public AbstractOptionMenuClient(String libelle, DaoFactory daoFactory, Scanner sc) {
		super();
		this.libelle = libelle;
		this.daoFactory = daoFactory;
		this.sc = sc;
	}



	public abstract boolean execute();

	public String getLibelle() {
		return libelle;
	}
	
}
