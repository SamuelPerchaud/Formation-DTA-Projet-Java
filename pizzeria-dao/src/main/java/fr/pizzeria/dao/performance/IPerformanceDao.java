package fr.pizzeria.dao.performance;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.NotImplementedException;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Performance;
import fr.pizzeria.model.Pizza;

public interface IPerformanceDao {


	List<Performance> findAllPerformance() throws DaoException, SQLException;



	void deletePerformance(String servicePerformance) throws DaoException, SQLException;

	void savePerformance(Performance newPerformance) throws DaoException, SQLException;


	void updatePerformance(String servicePerformance, Performance updatePerformance) throws DaoException, SQLException;

	
}
