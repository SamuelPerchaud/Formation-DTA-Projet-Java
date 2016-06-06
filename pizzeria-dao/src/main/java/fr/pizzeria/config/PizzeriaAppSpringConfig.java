package fr.pizzeria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoImpl;

@Configuration
@EnableTransactionManagement
public class PizzeriaAppSpringConfig {

	//
	@Bean
	public IPizzaDao getPizzaDao() {
		return new PizzaDaoImpl();
	}

//	@Bean
//	@Lazy
//	public EntityManagerFactory getEmf() {
//		return javax.persistence.Persistence.createEntityManagerFactory("pizzeria-console-objet-java8");
//	}
//
//	@Bean
//	public Scanner getScanner() {
//		return new Scanner(System.in);
//	}
//
//	@Bean
//	public DataSource dataSource() {
//		return new DriverManagerDataSource("jdbc:mysql://localhost:3306/pizzeria", "root", "");
//	}
//		
//	@Bean
//	public PlatformTransactionManager txManager(){
//		return new DataSourceTransactionManager(dataSource());
//	}
//	
	
	
}
