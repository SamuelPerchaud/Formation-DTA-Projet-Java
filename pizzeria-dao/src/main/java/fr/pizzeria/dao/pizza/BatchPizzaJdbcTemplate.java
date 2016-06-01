package fr.pizzeria.dao.pizza;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

@Component
@Lazy
public class BatchPizzaJdbcTemplate {

	private  JdbcTemplate jdbcTemplate;

	/**
	 * 
	 */
	@Autowired
	public BatchPizzaJdbcTemplate(javax.sql.DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void savePizzaMultiple(List<Pizza> newPizza) throws DaoException, SQLException {

		try {
			for (Pizza pizza : newPizza) {
				String sql = String.format(
						"INSERT INTO `pizza` (`ID`, `CODE`, `NOM`, `PRIX`, `CATEGORIE`) VALUES (NULL, '%s', '%s', '%s', '%s')",
						pizza.getCode(), pizza.getNom(), pizza.getPrix(), pizza.getCategorie().toString());
				int nbpizzas = jdbcTemplate.update(sql);

			}
			System.out.println(newPizza.size() + " pizza inséré");
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			System.err.println("erreur lors dune insertion");
			e.printStackTrace();
		}

	}

}
