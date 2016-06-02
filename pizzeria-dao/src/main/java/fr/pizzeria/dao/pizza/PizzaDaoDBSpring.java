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

import javax.activation.DataSource;
import javax.inject.Inject;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@Component
@Lazy
@Transactional
public class PizzaDaoDBSpring implements IPizzaDao {

	@Autowired
	private BatchPizzaJdbcTemplate batch;

	private static final String REPERTOIRE_DATA = "data";
	private static List<Pizza> pizzas = new ArrayList<Pizza>();
	private static List<List<Pizza>> test = new ArrayList<List<Pizza>>();

	private TransactionTemplate txTemplate;
	private JdbcTemplate jdbcTemplate;

	/**
	 * 
	 */
	@Autowired
	public PizzaDaoDBSpring(javax.sql.DataSource dataSource, PlatformTransactionManager transactionManager) {
		super();
		System.err.println("INFO---- Utilisation du l'implémentation JDBC de Spring");
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.txTemplate = new TransactionTemplate(transactionManager);
	}

	@Override
	public List<Pizza> findAllPizzas() throws DaoException, SQLException {
		List<Pizza> listResultat = new ArrayList<Pizza>();
		String sql = "SELECT * FROM PIZZA";
		return jdbcTemplate.query(sql, new PizzaMapper());

	}

	@Override
	public void savePizza(Pizza newPizza) throws DaoException, SQLException {
		String sql = String.format(
				"INSERT INTO `pizza` (`ID`, `CODE`, `NOM`, `PRIX`, `CATEGORIE`) VALUES (NULL, '%s', '%s', '%s', '%s')",
				newPizza.getCode(), newPizza.getNom(), newPizza.getPrix(), newPizza.getCategorie().toString());
		int nbpizzas = jdbcTemplate.update(sql);
		System.out.println(nbpizzas + " pizza inséré");

	}

	@Override
	public void updatePizza(String codePizza, Pizza updatePizza) throws DaoException {
		// UPDATE `pizza` SET `categorie` = 'POISSON', `code` = 'RETEST', `nom`
		// = 'resdfsfs', `prix` = '1599.00' WHERE `pizza`.`id` = 2

		String sql = String.format(
				"UPDATE `pizza` SET `code` = '%s',`nom` = '%s', `prix` = '%s',`categorie` = '%s'    WHERE `pizza`.`code` = '%s'",
				updatePizza.getCode(), updatePizza.getNom(), updatePizza.getPrix(),
				updatePizza.getCategorie().toString(), codePizza);
		int nbpizzas = jdbcTemplate.update(sql);
		System.out.println(nbpizzas + " pizza modifié");

	}

	@Override
	public void deletePizza(String codePizza) throws DaoException, SQLException {
		// ResultSet resultats = statement.executeQuery("INSERT INTO `pizza`
		// (`ID`, `CODE`, `NOM`, `PRIX`, `CATEGORIE`) VALUES
		// (NULL,'"+newPizza.getId()+"','"+newPizza.getNom()+"','"+newPizza.getNouveauPrix()+"','"+newPizza.getCategorie().toString()+"'");
		String sql = String.format("DELETE FROM `pizza` WHERE CODE = '%s'", codePizza);
		int nbpizzas = jdbcTemplate.update(sql);
		// newPizza.getCode(), newPizza.getNom(), newPizza.getNouveauPrix(),
		// newPizza.getCategorie().toString()));

		System.out.println(nbpizzas + " pizza supprimé");

		// DELETE FROM `pizza` WHERE `pizza`.`ID` = 4

	}

	public Pizza findOnePizza(String code) {
		try {
			return this.jdbcTemplate.queryForObject("SELECT * from PIZZA where code=?", new PizzaMapper(), code);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	@Transactional
	public void importPizza() throws DaoException, SQLException {
		try {
			System.out.println(" entré dans l'import");

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
		// test = ListUtils.partition(pizzas, 3);
		saveAllPizzas(pizzas);
		// for (List<Pizza> listPizza : test) {
		// batch.savePizzaMultiple(listPizza);
		// }
	}

	public class PizzaMapper implements RowMapper<Pizza> {

		@Override
		public Pizza mapRow(ResultSet rs, int rowNum) throws SQLException {
			Pizza pizza = new Pizza();
			pizza.setId(rs.getInt("ID"));
			pizza.setCode(rs.getString("CODE"));
			pizza.setNom(rs.getString("NOM"));
			pizza.setPrix(new BigDecimal(rs.getString("PRIX")));
			pizza.setCategorie(CategoriePizza.valueOf(rs.getString("CATEGORIE")));
			return pizza;
		}
	}

	public void saveAllPizzas(List<Pizza> listPizzas) throws DaoException {
		ListUtils.partition(listPizzas, 3).forEach(list -> {

			/*
			 * this.txTemplate.execute(new TransactionCallback<Pizza>() {
			 * 
			 * @Override public Pizza doInTransaction(TransactionStatus status)
			 * { return null; } });
			 */
			this.txTemplate.execute(status -> {
				list.forEach(p -> {
					try {
						this.savePizza(p);
					} catch (DaoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
				return null;
			});

		});
	}

}
