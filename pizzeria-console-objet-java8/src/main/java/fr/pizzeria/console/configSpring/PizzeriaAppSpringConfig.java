package fr.pizzeria.console.configSpring;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoRest;

@Configuration
@ComponentScan("fr.pizzeria")
//@Import()
public class PizzeriaAppSpringConfig {

	@Autowired
	@Qualifier("pizzaDaoImpl")
	private IPizzaDao pizzaDao;
	
	
	@Bean
	public IPizzaDao getPizzaDao() {
		return pizzaDao;
	}
	
	@Bean
	public EntityManagerFactory getEmf(){
		return javax.persistence.Persistence.createEntityManagerFactory("pizzeria-console-objet-java8");
	} 
	
	@Bean
	public Scanner getScanner(){
		return new Scanner(System.in);
	}

}
