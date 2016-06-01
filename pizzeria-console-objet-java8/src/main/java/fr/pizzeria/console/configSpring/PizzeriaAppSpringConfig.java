package fr.pizzeria.console.configSpring;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.pizzeria.dao.pizza.BatchPizzaJdbcTemplate;
import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoRest;

@Configuration
@ComponentScan("fr.pizzeria")
@EnableTransactionManagement
public class PizzeriaAppSpringConfig {

	//
	@Bean
	@Qualifier("daoImpl")
	public IPizzaDao getPizzaDao(@Qualifier("pizzaDaoDBSpring") IPizzaDao pizzaDao) {
		return pizzaDao;
	}

	@Bean
	@Lazy
	public EntityManagerFactory getEmf() {
		return javax.persistence.Persistence.createEntityManagerFactory("pizzeria-console-objet-java8");
	}

	@Bean
	public Scanner getScanner() {
		return new Scanner(System.in);
	}

	@Bean
	public DataSource dataSource() {
		return new DriverManagerDataSource("jdbc:mysql://localhost:3306/pizzeria", "root", "");
	}
		
	@Bean
	public PlatformTransactionManager txManager(){
		return new DataSourceTransactionManager(dataSource());
	}
	
	
}
