package fr.pizzeria.dao.performance;

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
import fr.pizzeria.model.Performance;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.repos.IPerformanceRepository;
import fr.pizzeria.repos.IPizzaRepository;

@Repository
@Lazy
// @Import(PizzeriaAppJPAConfig.class)
public class PerformanceDaoSpringData implements IPerformanceDao {

	@Autowired private IPerformanceRepository performancerepository;
	
	@Override
	public List<Performance> findAllPerformance() throws DaoException, SQLException {

		
		return performancerepository.findAll();
	}

	@Override
	public void savePerformance(Performance newPerformance) throws DaoException, SQLException {
		performancerepository.save(newPerformance);

	}

	@Override
	public void updatePerformance(String servicePerformance, Performance updatePerformance)
			throws DaoException, SQLException {
		
		Performance performance = performancerepository.findByService(servicePerformance);
if (performance != null){
	performance.setService(updatePerformance.getService());;
	performance.setDate(updatePerformance.getDate());
	performance.setTempsExecution(updatePerformance.getTempsExecution());
}
	
		performancerepository.save(performance);
		System.err.println("la performance : " + performance + "a été mise a jour");

	}

	@Override
	public void deletePerformance(String servicePerformance) throws DaoException, SQLException {
		Performance performance = performancerepository.findByService(servicePerformance);
		Integer nbPerformanceSup = performancerepository.deleteByService(servicePerformance);
		if (nbPerformanceSup == 1) {
			System.err.println("la performance : " + performance + "a été supprimé");
		} else {
			System.err.println("echec de la suppresion");
		}

	}

}
