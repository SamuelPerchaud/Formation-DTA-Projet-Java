package fr.pizzeria.console.configSpring;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.pizzeria.config.PizzeriaAppSpringDataConfig;
import fr.pizzeria.dao.pizza.BatchPizzaJdbcTemplate;
import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoRest;
import fr.pizzeria.dao.pizza.PizzaDaoSpringData;

@Configuration
@ComponentScan({"fr.pizzeria.ihm","fr.pizzeria.aspects"})//"fr.pizzeria.dao"
@EnableTransactionManagement
@Import(PizzeriaAppSpringDataConfig.class)
@EnableAspectJAutoProxy
public class PizzeriaAppSpringConfig {

	@Bean
	@Lazy
	public EntityManagerFactory entityManagerFactory() {
		return javax.persistence.Persistence.createEntityManagerFactory("pizzeria-console-objet-java8");
	}

	@Bean
	public Scanner getScanner() {
		return new Scanner(System.in);
	}
	
	@Bean
	public IPizzaDao pizzaDao() {
		return new PizzaDaoSpringData();
	}


		
	
	
	
	
}
