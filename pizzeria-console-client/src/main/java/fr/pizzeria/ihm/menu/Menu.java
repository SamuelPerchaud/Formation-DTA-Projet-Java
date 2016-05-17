package fr.pizzeria.ihm.menu;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import fr.pizzeria.dao.DaoFactory;
import fr.pizzeria.ihm.menu.option.AbstractOptionMenuClient;
import fr.pizzeria.ihm.menu.option.ConnectionOptionMenu;
import fr.pizzeria.ihm.menu.option.InscriptionOptionMenu;
import fr.pizzeria.ihm.menu.option.QuitterOptionMenu;

public class Menu {
	private static final String MENU_TITRE_LIBELLE = "Application Client Console";
	private Map<Integer, AbstractOptionMenuClient> options = new TreeMap<Integer, AbstractOptionMenuClient>();

	private Scanner sc;

	
	public Menu(Scanner sc,DaoFactory daoFactory) {
		super();
		initialiserOptions(sc,daoFactory);
		this.sc = sc;

	}


	private void initialiserOptions(Scanner sc,DaoFactory daoFactory) {
		options.put(1, new ConnectionOptionMenu(daoFactory,sc));
		options.put(2, new InscriptionOptionMenu(daoFactory,sc));
		options.put(3, new QuitterOptionMenu());
		
	}
	
	public void afficher() {
		boolean continuer = true;
		while (continuer) {
			System.out.println("**** " + MENU_TITRE_LIBELLE + " ****");
			
			options.entrySet().stream()
			.forEach(optionMenuEntry -> System.out.println(optionMenuEntry.getKey()+" : "+optionMenuEntry.getValue().getLibelle()));


			int saisie = sc.nextInt();
			continuer = options.get(saisie).execute();
		}
	}
	
	
}
