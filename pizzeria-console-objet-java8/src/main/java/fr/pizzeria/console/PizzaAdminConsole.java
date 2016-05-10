package fr.pizzeria.console;

import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoFichier;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.ihm.menu.Menu;

public class PizzaAdminConsole {

	public static void main(String[] args) throws IOException, DaoException {
		


		
		//HashCodeBuilder a = new HashCodeBuilder(12,44);
		try(Scanner sc = new Scanner(System.in)) {
			IPizzaDao dao = new PizzaDaoFichier();
			Menu menu = new Menu(sc,dao);
			menu.afficher();
			HashCodeBuilder a = new HashCodeBuilder(12,44);
		}
		
	}
	
	
}
