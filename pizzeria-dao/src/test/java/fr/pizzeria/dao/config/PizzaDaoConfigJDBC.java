package fr.pizzeria.dao.config;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import fr.pizzeria.config.PizzeriaAppJDBCSpringConfig;
import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoDB;
import fr.pizzeria.dao.pizza.PizzaDaoJPASpring;
import fr.pizzeria.dao.test_implementation.PizzaDaoDBSpringTest;

@Configuration
//@ComponentScan("fr.pizzeria.dao")
//@Import(PizzeriaAppJDBCSpringConfig.class)
public class PizzaDaoConfigJDBC {

	@Bean
	public DataSource dataSource() {
		return   new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("db-schema.sql").addScript("db-data.sql").build();
		}
	
	
	@Bean
	public PlatformTransactionManager TxManager(){
		return new DataSourceTransactionManager(dataSource());
	}
	
	@Bean
	public IPizzaDao pizzaDao(){
		return new PizzaDaoDB();
	}
	

}
