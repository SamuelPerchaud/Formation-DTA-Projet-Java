package fr.pizzeria.console.configSpring;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import fr.pizzeria.dao.pizza.IPizzaDao;

@Configuration
@ComponentScan("fr.pizzeria.dao.pizza")
public class PizzeriaAppSpringConfig {

	@Bean
	public IPizzaDao pizzaDao() {
	
		return null;
	}
	
	@Bean
	public EntityManagerFactory 
	
	@Bean
	public Scanner scanner(){
		return new Scanner(System.in);
	}

}
