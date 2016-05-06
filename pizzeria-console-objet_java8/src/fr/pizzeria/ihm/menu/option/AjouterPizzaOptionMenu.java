package fr.pizzeria.ihm.menu.option;

import java.util.Locale.Category;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.TypePizza;

public class AjouterPizzaOptionMenu extends AbstractOptionMenu {

	private static final String AJOUTER_PIZZAS_LIBELLE_MENU = "ajouter une Pizzas";
	private Scanner sc;

	public AjouterPizzaOptionMenu(Scanner sc, IPizzaDao pizzaDao) {
		super(AJOUTER_PIZZAS_LIBELLE_MENU, pizzaDao);
		this.sc = sc;
	}

	@Override
	public boolean execute() {
		Pizza newPizza = new Pizza();
		System.out.println("entré le code de la nouvelle pizza");
		newPizza.code = sc.next();
		System.out.println("entré le nom de la nouvelle pizza");
		newPizza.nom = sc.next();
		System.out.println("entré le prix de la nouvelle pizza");
		newPizza.prix = sc.nextDouble();
		System.out.println("entré le type de la nouvelle pizza");
		TypePizza[]newType = TypePizza.values();
		for ( TypePizza cat : newType){
			System.out.println(cat.ordinal()+"->"+cat.getLibelle());

		}
		int saisieType = sc.nextInt();
		//System.out.println(TypePizza.valueOf("Viande"));
		//System.out.println("2 : poisson");
		//System.out.println("3 : sans viande");
		newPizza.type = newType[saisieType];
		
		//newPizza.type= 
		boolean resultat = true;

		try {
			pizzaDao.savePizza(newPizza);
		} catch (DaoException e) {
			System.err.println("erreur sur la methode savepizza");
			e.printStackTrace();
		}

		return resultat;
	}

}