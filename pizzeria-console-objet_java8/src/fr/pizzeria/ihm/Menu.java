package fr.pizzeria.ihm;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.ihm.menu.option.AbstractOptionMenu;
import fr.pizzeria.ihm.menu.option.AjouterPizzaOptionMenu;
import fr.pizzeria.ihm.menu.option.ListerPizzaOptionMenu;
import fr.pizzeria.ihm.menu.option.ModifierPizzaOptionMenu;
import fr.pizzeria.ihm.menu.option.QuitterOptionMenu;
import fr.pizzeria.ihm.menu.option.SupprimerPizzaOptionMenu;

public class Menu {

	//private AbstractOptionMenu[] options;
	private Map<Integer,AbstractOptionMenu> options= new TreeMap<Integer,AbstractOptionMenu>();
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
		options.put(1, new ListerPizzaOptionMenu(pizzaDao));
		options.put(2, new AjouterPizzaOptionMenu(sc,pizzaDao));
		options.put(3, new ModifierPizzaOptionMenu(sc,pizzaDao));
		options.put(4, new SupprimerPizzaOptionMenu(sc,pizzaDao));
		options.put(99, new QuitterOptionMenu());
		/*options = new AbstractOptionMenu[] { 
				new ListerPizzaOptionMenu(pizzaDao), 
				new AjouterPizzaOptionMenu(sc,pizzaDao),
				new ModifierPizzaOptionMenu(sc, pizzaDao),
				new SupprimerPizzaOptionMenu(sc, pizzaDao),
				new QuitterOptionMenu()
				};*/
	}

public void afficher(){
	boolean continuer = true;
	while(continuer){
		System.out.println("*****"+"titre");
		for(Entry<Integer,AbstractOptionMenu> optionMenuEntry : options.entrySet()){
			System.out.println(optionMenuEntry.getKey()+" "+ optionMenuEntry.getValue().getLibelle());
 
		}
		
		
		
		//System.out.println("*****"+"titre");
		//for(int i =0; i<options.length;i++){
			//AbstractOptionMenu opt = options[i];
			//System.out.println(i+" -> "+opt.getLibelle());

		
		int saisie = sc.nextInt();
		
		continuer = options.get(saisie).execute();
}
	
	
}

}
