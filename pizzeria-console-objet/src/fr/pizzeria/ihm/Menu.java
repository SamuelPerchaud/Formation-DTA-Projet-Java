package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.ihm.menu.option.AbstractOptionMenu;
import fr.pizzeria.ihm.menu.option.AjouterPizzaOptionMenu;
import fr.pizzeria.ihm.menu.option.ListerPizzaOptionMenu;
import fr.pizzeria.ihm.menu.option.QuitterOptionMenu;
import fr.pizzeria.ihm.menu.option.SupprimerPizzaOptionMenu;

public class Menu {

	private AbstractOptionMenu[] options;
	private Scanner sc;
	/**
	 * @param sc 
	 * 
	 */
	public Menu(Scanner sc,IPizzaDao pizzaDao) {
		super();
		initializeOptions(sc,pizzaDao);
		this.sc = sc;
	}

	private void initializeOptions(Scanner sc,IPizzaDao pizzaDao) {
		options = new AbstractOptionMenu[] { 
				new ListerPizzaOptionMenu(pizzaDao), 
				new AjouterPizzaOptionMenu(sc,pizzaDao),
				new SupprimerPizzaOptionMenu(sc, pizzaDao),
				new QuitterOptionMenu()
				};
	}

public void afficher(){
	boolean continuer = true;
	while(continuer){
		System.out.println("*****"+"titre");
		for(int i =0; i<options.length;i++){
			AbstractOptionMenu opt = options[i];
			System.out.println(i+" -> "+opt.getLibelle());

		}
		int saisie = sc.nextInt();
		continuer = options[saisie].execute();
	}
	
}

}
