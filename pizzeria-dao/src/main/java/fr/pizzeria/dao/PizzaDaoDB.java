package fr.pizzeria.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoDB implements IPizzaDao {
	private Path repertoire = Paths.get("data");

	static {
		// java.sql.DriverManager.registerDriver(jdbc:mysql:/localhost:3306/pizzeria);

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
			pizza.setPrix(resultats.getDouble("PRIX"));
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
		connection.setAutoCommit(false);
		
		
		
		PreparedStatement statement = connection.prepareStatement("INSERT INTO `pizza` (`ID`, `CODE`, `NOM`, `PRIX`, `CATEGORIE`) VALUES (NULL, ?, ?, ?, ?)");
		statement.setString(1,newPizza.getCode());
		statement.setString(2, newPizza.getNom());
		statement.setDouble(3, newPizza.getNouveauPrix());
		statement.setString(4, newPizza.getCategorie().toString());
		// ResultSet resultats = statement.executeQuery("INSERT INTO `pizza`
		// (`ID`, `CODE`, `NOM`, `PRIX`, `CATEGORIE`) VALUES
		// (NULL,'"+newPizza.getId()+"','"+newPizza.getNom()+"','"+newPizza.getNouveauPrix()+"','"+newPizza.getCategorie().toString()+"'");
		int nbpizzas = statement.executeUpdate();
		/**
		int nbpizzas = statement.executeUpdate(String.format(
				"INSERT INTO `pizza` (`ID`, `CODE`, `NOM`, `PRIX`, `CATEGORIE`) VALUES (NULL, '%s', '%s', '%s', '%s')",
				newPizza.getCode(), newPizza.getNom(), newPizza.getNouveauPrix(), newPizza.getCategorie().toString()));
				*/
		if (nbpizzas == 1) {
			connection.commit();
			System.out.println(nbpizzas + " pizza inséré");

		} else {
			connection.rollback();
			System.err.println("pas de  pizza inséré");

		}

	}

	@Override
	public void updatePizza(String codePizza, Pizza updatePizza) throws DaoException, SQLException {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria", "root", "");
				Statement statement = connection.createStatement();) {
			// ResultSet resultats = statement.executeQuery("INSERT INTO `pizza`
			// (`ID`, `CODE`, `NOM`, `PRIX`, `CATEGORIE`) VALUES
			// (NULL,'"+newPizza.getId()+"','"+newPizza.getNom()+"','"+newPizza.getNouveauPrix()+"','"+newPizza.getCategorie().toString()+"'");

			int nbpizzas = statement.executeUpdate(
					String.format("UPDATE `pizza`SET CODE='%s',NOM='%s',PRIX='%s',CATEGORIE='%s' WHERE CODE = '%s'",
							updatePizza.getCode(), updatePizza.getNom(), updatePizza.getNouveauPrix(),
							updatePizza.getCategorie().toString(), codePizza));
			// newPizza.getCode(), newPizza.getNom(), newPizza.getNouveauPrix(),
			// newPizza.getCategorie().toString()));

			System.out.println(nbpizzas + " pizza mise a jour");

		} catch (SQLException e) {
			throw new SQLException(e);
		}
		// DELETE FROM `pizza` WHERE `pizza`.`ID` = 4

	}

	@Override
	public void deletePizza(String codePizza) throws DaoException, SQLException {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria", "root", "");
				Statement statement = connection.createStatement();) {
			// ResultSet resultats = statement.executeQuery("INSERT INTO `pizza`
			// (`ID`, `CODE`, `NOM`, `PRIX`, `CATEGORIE`) VALUES
			// (NULL,'"+newPizza.getId()+"','"+newPizza.getNom()+"','"+newPizza.getNouveauPrix()+"','"+newPizza.getCategorie().toString()+"'");

			int nbpizzas = statement.executeUpdate(String.format("DELETE FROM `pizza` WHERE CODE = '%s'", codePizza));
			// newPizza.getCode(), newPizza.getNom(), newPizza.getNouveauPrix(),
			// newPizza.getCategorie().toString()));

			System.out.println(nbpizzas + " pizza supprimé");

		} catch (SQLException e) {
			throw new SQLException(e);
		}
		// DELETE FROM `pizza` WHERE `pizza`.`ID` = 4

	}

}
