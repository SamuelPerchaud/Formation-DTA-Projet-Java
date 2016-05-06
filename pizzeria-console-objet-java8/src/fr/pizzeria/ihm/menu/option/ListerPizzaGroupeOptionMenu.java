package fr.pizzeria.ihm.menu.option;

import java.util.Comparator;
import java.util.stream.Collectors;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

public class ListerPizzaGroupeOptionMenu extends AbstractOptionMenu {

	private static final String LISTER_PIZZAS_LIBELLE_MENU = "Lister Pizzas groupé";

	
	
	public ListerPizzaGroupeOptionMenu(IPizzaDao pizzaDao) {
		super(LISTER_PIZZAS_LIBELLE_MENU, pizzaDao);
	}

	@Override
	public boolean execute() throws DaoException {
		
		
		
		pizzaDao.findAllPizzas().stream()
		.collect(Collectors.groupingBy(Pizza::getCategorie))
		.forEach((categorie,listePizzas) ->{
			System.out.println("*****"+categorie.getLibelle().toUpperCase()+"*****");
			listePizzas.stream()
				.sorted(Comparator.comparing(Pizza::getCode).thenComparing(Pizza::getNouveauPrix))
				.forEach(System.out::println);
		} );
		
		/**System.out.println("Lister Pizza Menu");
		List<Pizza> pizzas = pizzaDao.findAllPizzas();
		
		Collections.sort(pizzas, new Comparator<Pizza>() {

			@Override
			public int compare(Pizza o1, Pizza o2) {
				return o1.getCode().compareTo(o2.getCode());
			}
		});
		
		for (Pizza p : pizzas) {
			System.out.println(p);
		}
		*/
		return true;
	}

}
