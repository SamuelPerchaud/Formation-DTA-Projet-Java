package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.DaoFactory;

public class ConnectionOptionMenu extends AbstractOptionMenuClient {

	private static final String CONNECTION_CLIENT_LIBELLE_MENU = "connection";

	public ConnectionOptionMenu(DaoFactory daoFactory, Scanner sc) {
		super(CONNECTION_CLIENT_LIBELLE_MENU, daoFactory, sc);
	}

	@Override
	public boolean execute() {
		System.out.println("");

		return true;
	}

}
