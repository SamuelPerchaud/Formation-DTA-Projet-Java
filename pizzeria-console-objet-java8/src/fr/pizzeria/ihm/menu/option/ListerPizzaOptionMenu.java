package fr.pizzeria.ihm.menu.option;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.DesactiverOptionMenu;
import fr.pizzeria.model.Pizza;

public class ListerPizzaOptionMenu extends AbstractOptionMenu {

	private static final String LISTER_PIZZAS_LIBELLE_MENU = "Lister Pizzas";

	
	
	public ListerPizzaOptionMenu(IPizzaDao pizzaDao) {
		super(LISTER_PIZZAS_LIBELLE_MENU, pizzaDao);
	}

	@Override
	public boolean execute() {
		
		
		pizzaDao.findAllPizzas().stream()
		.sorted(Comparator.comparing(Pizza::getNouveauPrix))
		
		.forEach(System.out::println);
		//.collect(Collectors.groupingBy(Pizza::getCategorie))
		//.forEach((categorie,listePizzas) ->{
			//System.out.println("*****"+categorie.getLibelle().toUpperCase()+"*****");
			//listePizzas.stream()
			//	.sorted(Comparator.comparing(Pizza::getCode))
			//	.forEach(System.out::println);
		//} );
		
		return true;
	}

}
