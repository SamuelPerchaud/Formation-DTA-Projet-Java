package fr.pizzeria.config;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoSpringData;

@Configuration
@EnableJpaRepositories("fr.pizzeria.repos")
//@Import(PizzeriaAppJPAConfig.class)
public class PizzeriaAppSpringDataConfig {

	@Bean
	public IPizzaDao getPizzaDao() {
		return new PizzaDaoSpringData();
	}

	@Bean
	@Lazy
	public EntityManagerFactory entityManagerFactory() {
		return javax.persistence.Persistence.createEntityManagerFactory("pizzeria-pu");
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
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager();
	}

}
