package fr.pizzeria.ihm.menu.option;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.Optional;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

public class TrouverPizzaMaxOptionMenu extends AbstractOptionMenu {

	private static final String LISTER_PIZZAS_LIBELLE_MENU = "Pizzas Max";

	
	
	public TrouverPizzaMaxOptionMenu(IPizzaDao pizzaDao) {
		super(LISTER_PIZZAS_LIBELLE_MENU, pizzaDao);
	}

	@Override
	public boolean execute() throws DaoException, SQLException {
		
		
		Optional<Pizza> test =  pizzaDao.findAllPizzas().stream()
		.max(Comparator.comparing(Pizza::getNouveauPrix));
		//.sorted(Comparator.comparing(Pizza::getNouveauPrix))
		System.out.println(test);
		//.forEach(System.out::println);
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
