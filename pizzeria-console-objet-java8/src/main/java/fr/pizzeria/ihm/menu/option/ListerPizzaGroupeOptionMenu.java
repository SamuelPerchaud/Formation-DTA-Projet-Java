package fr.pizzeria.ihm.menu.option;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.stream.Collectors;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

public class ListerPizzaGroupeOptionMenu extends AbstractOptionMenu {

	private static final String LISTER_PIZZAS_LIBELLE_MENU = "Lister Pizzas group�";

	
	
	public ListerPizzaGroupeOptionMenu(IPizzaDao pizzaDao) {
		super(LISTER_PIZZAS_LIBELLE_MENU, pizzaDao);
	}

	@Override
	public boolean execute() throws DaoException, SQLException {
		
		
		
		pizzaDao.findAllPizzas().stream()
		.collect(Collectors.groupingBy(Pizza::getCategorie))
		.forEach((categorie,listePizzas) ->{
			System.out.println("*****"+categorie.getLibelle().toUpperCase()+"*****");
			listePizzas.stream()
				.sorted(Comparator.comparing(Pizza::getCode).thenComparing(Pizza::getPrix))
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
