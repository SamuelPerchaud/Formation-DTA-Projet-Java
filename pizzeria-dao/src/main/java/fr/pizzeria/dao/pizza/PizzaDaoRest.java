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
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.apache.commons.collections4.ListUtils;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoRest implements IPizzaDao {
	// private Path repertoire = Paths.get("data");

	
	private static List<Pizza> pizzas = new ArrayList<Pizza>();
	private static List<List<Pizza>> test = new ArrayList<List<Pizza>>();

	@Override
	public List<Pizza> findAllPizzas() throws DaoException, SQLException {
		
		javax.ws.rs.client.Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		Invocation.Builder builder = target.path("pizzeria").path("pizzas").request();
		Response response = builder.get();
		System.err.println(response.toString());
		
		
		//EntityManager em = emf.createEntityManager();
		//List<Pizza> listPizza = em.createQuery("SELECT p FROM Pizza p", Pizza.class).getResultList();
		//em.close();

		/**
		 * Connection connection =
		 * DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria",
		 * "root", ""); Statement statement = connection.createStatement(); //
		 * jdbc:mysql://localhost:3306/pizzeria // Connection connection = //
		 * DriverManager.getConnection(//localhost:3306/pizzeria); ResultSet
		 * resultats = statement.executeQuery("SELECT * FROM PIZZA");
		 * List<Pizza> listResultat = new ArrayList<Pizza>();
		 * 
		 * while (resultats.next()) {
		 * 
		 * Pizza pizza = new Pizza();
		 * 
		 * pizza.setCode(resultats.getString("CODE"));
		 * pizza.setNom(resultats.getString("NOM"));
		 * pizza.setPrix(resultats.getDouble("PRIX"));
		 * pizza.setCategorie(CategoriePizza.valueOf(resultats.getString("CATEGORIE")));
		 * listResultat.add(pizza);
		 * 
		 * }
		 */
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
		return null;
	}

	@Override
	public void savePizza(Pizza newPizza) throws DaoException, SQLException {
		
		// et.commit();
		// em.close();

		// System.err.println(" pizza inséré : " + newPizza);

	}

	@Override
	public void updatePizza(String codePizza, Pizza updatePizza) throws DaoException {
		

	}

	@Override
	public void deletePizza(String codePizza) throws DaoException, SQLException {
		
	}

	@Override
	public void importPizza() throws DaoException, SQLException {
		// TODO Auto-generated method stub
		
	}



}
