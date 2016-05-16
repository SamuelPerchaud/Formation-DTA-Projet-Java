package fr.pizzeria.dao;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJPA implements IPizzaDao {
	private Path repertoire = Paths.get("data");

	public EntityManagerFactory emf;

	/**
	 * @param entityManagerFactory
	 */
	public PizzaDaoJPA(EntityManagerFactory entityManagerFactory) {
		super();
		this.emf = entityManagerFactory;
	}
	
	
	

	@Override
	public List<Pizza> findAllPizzas() throws DaoException, SQLException {
		EntityManager em = emf.createEntityManager();
		List<Pizza> listPizza = em.createQuery("SELECT p FROM Pizza p", Pizza.class).getResultList();
		em.close();

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
		return listPizza;
	}

	@Override
	public void savePizza(Pizza newPizza) throws DaoException, SQLException {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(newPizza);
		System.err.println(newPizza);
		et.commit();
		em.close();
		
		System.err.println(" pizza inséré : "+newPizza);

	}

	@Override
	public void updatePizza(String codePizza, Pizza updatePizza) throws DaoException {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Pizza pizza = em.createNamedQuery("pizza.getcode", Pizza.class).setParameter("code",codePizza).getSingleResult();
		if(pizza != null){
			pizza.setCode(updatePizza.getCode());
			pizza.setNom(updatePizza.getNom());
			pizza.setPrix(updatePizza.getNouveauPrix());
			pizza.setCategorie(updatePizza.getCategorie());
		}
		
		em.merge(pizza);
		System.err.println("la pizza : "+pizza+"a été mise a jour");
		et.commit();
		em.close();

		
		
	}

	@Override
	public void deletePizza(String codePizza) throws DaoException, SQLException {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Pizza pizza = em.createNamedQuery("pizza.getcode", Pizza.class).setParameter("code",codePizza).getSingleResult();
		em.remove(pizza);
		System.err.println(pizza);
		et.commit();
		em.close();

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
	public void importPizza() throws DaoException, SQLException {
		// TODO Auto-generated method stub

	}

}
