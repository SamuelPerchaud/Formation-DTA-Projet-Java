package fr.pizzeria.dao.pizza;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@Component
@Qualifier("PizzaDaoDB")
@Lazy
public class PizzaDaoDB implements IPizzaDao {
	//private Path repertoire = Paths.get("data");

	static {
		// java.sql.DriverManager.registerDriver(jdbc:mysql:/localhost:3306/pizzeria);

	}
	private static final String REPERTOIRE_DATA = "data";
	private static List<Pizza> pizzas = new ArrayList<Pizza>();
	private static List<List<Pizza>> test = new ArrayList<List<Pizza>>();

	/**
	 * 
	 */
	public PizzaDaoDB() {
		super();
		System.err.println("INFO---- Utilisation du l'implémentation JDBC");
	}

	@Override
	public List<Pizza> findAllPizzas() throws DaoException, SQLException {

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria", "root", "");
		Statement statement = connection.createStatement();
		// jdbc:mysql://localhost:3306/pizzeria
		// Connection connection =
		// DriverManager.getConnection(//localhost:3306/pizzeria);
		ResultSet resultats = statement.executeQuery("SELECT * FROM PIZZA");
		List<Pizza> listResultat = new ArrayList<Pizza>();

		while (resultats.next()) {

			Pizza pizza = new Pizza();

			pizza.setCode(resultats.getString("CODE"));
			pizza.setNom(resultats.getString("NOM"));
			pizza.setPrix(resultats.getBigDecimal("PRIX"));
			pizza.setCategorie(CategoriePizza.valueOf(resultats.getString("CATEGORIE")));
			listResultat.add(pizza);

		}

		// List<Pizza> ListResultat = resultats.;
		/**
		 * try { return Files.list(repertoire) .map(path -> { Pizza p = new
		 * Pizza(); p.setCode(path.getFileName().toString().replaceAll(".txt",
		 * "")); try { String ligne = Files.readAllLines(path).get(0); String[]
		 * ligneTab = ligne.split(";"); p.setNom(ligneTab[0]);
		 * p.setPrix(Double.valueOf(ligneTab[1]));
		 * p.setCategorie(CategoriePizza.valueOf(ligneTab[2])); } catch
		 * (Exception e) { e.printStackTrace(); }
		 * 
		 * return p; }) .collect(Collectors.toList()); } catch (IOException e) {
		 * throw new DaoException(e); }
		 */
		return listResultat;
	}

	@Override
	public void savePizza(Pizza newPizza) throws DaoException, SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria", "root", "");
		Statement statement = connection.createStatement();
		// ResultSet resultats = statement.executeQuery("INSERT INTO `pizza`
		// (`ID`, `CODE`, `NOM`, `PRIX`, `CATEGORIE`) VALUES
		// (NULL,'"+newPizza.getId()+"','"+newPizza.getNom()+"','"+newPizza.getNouveauPrix()+"','"+newPizza.getCategorie().toString()+"'");

		int nbpizzas = statement.executeUpdate(String.format(
				"INSERT INTO `pizza` (`ID`, `CODE`, `NOM`, `PRIX`, `CATEGORIE`) VALUES (NULL, '%s', '%s', '%s', '%s')",
				newPizza.getCode(), newPizza.getNom(), newPizza.getPrix(), newPizza.getCategorie().toString()));

		System.out.println(nbpizzas + " pizza inséré");

	}

	@Override
	public void updatePizza(String codePizza, Pizza updatePizza) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePizza(String codePizza) throws DaoException, SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria", "root", "");
		Statement statement = connection.createStatement();
		// ResultSet resultats = statement.executeQuery("INSERT INTO `pizza`
		// (`ID`, `CODE`, `NOM`, `PRIX`, `CATEGORIE`) VALUES
		// (NULL,'"+newPizza.getId()+"','"+newPizza.getNom()+"','"+newPizza.getNouveauPrix()+"','"+newPizza.getCategorie().toString()+"'");

		int nbpizzas = statement.executeUpdate(String.format("DELETE FROM `pizza` WHERE CODE = '%s'", codePizza));
		// newPizza.getCode(), newPizza.getNom(), newPizza.getNouveauPrix(),
		// newPizza.getCategorie().toString()));

		System.out.println(nbpizzas + " pizza supprimé");

		// DELETE FROM `pizza` WHERE `pizza`.`ID` = 4

	}

	@Override
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

				return p;
			}).collect(Collectors.toList());
		} catch (IOException e) {
			throw new DaoException(e);
		}
		test = ListUtils.partition(pizzas, 3);

		for (List<Pizza> listPizza : test) {
			for (Pizza pizza : listPizza) {
				System.out.println("TEST" + pizza);
				savePizza(pizza);
			}
		}
	}

}
