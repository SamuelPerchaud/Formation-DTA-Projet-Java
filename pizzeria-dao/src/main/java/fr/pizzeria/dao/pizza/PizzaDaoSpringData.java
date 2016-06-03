package fr.pizzeria.dao.pizza;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.config.PizzeriaAppJPAConfig;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.repos.IPizzaRepository;

@Repository
@Lazy
// @Import(PizzeriaAppJPAConfig.class)
public class PizzaDaoSpringData implements IPizzaDao {
	// private Path repertoire = Paths.get("data");

	// @Autowired
	// public EntityManagerFactory emf;

	@PersistenceContext
	private EntityManager em;
	/**
	 * @param entityManagerFactory
	 */
	@Autowired
	private IPizzaRepository pizzarepository;

	/**
	 * 
	 */
	public PizzaDaoSpringData() {
		super();
		System.err.println("INFO---- Utilisation du l'implémentation Data Spring");
		}

	private static final String REPERTOIRE_DATA = "data";
	private static List<Pizza> pizzas = new ArrayList<Pizza>();
	private static List<List<Pizza>> test = new ArrayList<List<Pizza>>();

	@Override
	public List<Pizza> findAllPizzas() throws DaoException, SQLException {
		return pizzarepository.findAll();
	}

	@Override
	@Transactional
	public void savePizza(Pizza newPizza) throws DaoException, SQLException {
		Pizza pizza = null;
		try {
			pizza = em.createNamedQuery("pizza.getcode", Pizza.class).setParameter("code", newPizza.getCode())
					.getSingleResult();
			System.err.println("INFO---- Pizza deja presente");

		} catch (NoResultException e) {
			pizzarepository.save(newPizza);
			// System.err.println(newPizza);
			System.err.println("INFO---- pizza inséré  : " + newPizza);
			// EntityNotFoundException e
		}

	}

	@Override
	@Transactional
	public void updatePizza(String codePizza, Pizza updatePizza) throws DaoException {
		// EntityManager em = emf.createEntityManager();
		// pizzarepository.
		Pizza pizza = pizzarepository.findByCode(codePizza);
		// pizzarepository.save(updatePizza);
		if (pizza != null) {
			pizza.setCode(updatePizza.getCode());
			pizza.setNom(updatePizza.getNom());
			pizza.setPrix(updatePizza.getPrix());
			pizza.setCategorie(updatePizza.getCategorie());
		}

		pizzarepository.save(pizza);
		System.err.println("la pizza : " + pizza + "a été mise a jour");

	}

	@Override
	@Transactional
	public void deletePizza(String codePizza) throws DaoException, SQLException {
		// EntityManager em = emf.createEntityManager();
		Pizza pizza = pizzarepository.findByCode(codePizza);
		Integer nbPizzaSup = pizzarepository.deleteByCode(codePizza);
		if (nbPizzaSup == 1) {
			System.err.println("la pizza : " + pizza + "a été supprimé");
		} else {
			System.err.println("echec de la suppresion");
		}

		/**
		 * Connection connection =
		 * DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria",
		 * "root", ""); Statement statement = connection.createStatement(); //
		 * ResultSet resultats = statement.executeQuery("INSERT INTO `pizza` //
		 * (`ID`, `CODE`, `NOM`, `PRIX`, `CATEGORIE`) VALUES //
		 * (NULL,'"+newPizza.getId()+"','"+newPizza.getNom()+"','"+newPizza.getNouveauPrix()+"','"+newPizza.getCategorie().toString()+"'");
		 * 
		 * int nbpizzas = statement.executeUpdate(String.format("DELETE FROM
		 * `pizza` WHERE CODE = '%s'", codePizza)); // newPizza.getCode(),
		 * newPizza.getNom(), newPizza.getNouveauPrix(), //
		 * newPizza.getCategorie().toString()));
		 * 
		 * System.out.println(nbpizzas + " pizza supprimé");
		 * 
		 * // DELETE FROM `pizza` WHERE `pizza`.`ID` = 4
		 */
	}

	@Override
	@Transactional
	public void importPizza() throws DaoException, SQLException {
		try {
			pizzas = Files.list(Paths.get(REPERTOIRE_DATA)).map(path -> {
				Pizza p = new Pizza();
				p.setCode(path.getFileName().toString().replaceAll(".txt", ""));
				try {
					String ligne = Files.readAllLines(path).get(0);
					String[] ligneTab = ligne.split(";");
					p.setNom(ligneTab[0]);
					p.setPrix(new BigDecimal(ligneTab[1]));
					p.setCategorie(CategoriePizza.valueOf(ligneTab[2]));
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.err.println("INFO----IMPORT de " + p);

				return p;
			}).collect(Collectors.toList());
		} catch (IOException e) {
			throw new DaoException(e);
		}
		test = ListUtils.partition(pizzas, 3);

		for (List<Pizza> listPizza : test) {
			for (Pizza pizza : listPizza) {
				// System.err.println("INFO----IMPORT de " + pizza);
				savePizza(pizza);
			}
		}
	}

}
