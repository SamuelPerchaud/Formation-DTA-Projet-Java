package fr.pizzeria.dao;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import fr.pizzeria.dao.pizza.IPizzaDao;

@Configuration
@ComponentScan("fr.pizzeria")
public class PizzaDaoSpringTest {

	@Bean
	public DataSource dataSource() {
		return   new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("db-schema.sql").addScript("db-data.sql").build();
		}
	

	
	
}
