package fr.pizzeria.dao.test_implementation;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.dao.performance.IPerformanceDao;
import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Performance;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class PerformanceDaoAspectTest {

	protected IPizzaDao pizzaDao;
	protected IPerformanceDao performanceDao;

	@Test
	public void testfindAllPerformance() throws DaoException, SQLException {
		pizzaDao.findAllPizzas();
		List<Performance> performances = performanceDao.findAllPerformance();
		performances.forEach(System.out::println);

		assertEquals(1, performances.size());
		assertEquals("IPizzaDao.findAllPizzas()", performances.get(0).getService());
	}
}
