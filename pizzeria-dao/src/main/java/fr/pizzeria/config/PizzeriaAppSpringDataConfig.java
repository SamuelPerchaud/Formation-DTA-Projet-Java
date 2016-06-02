package fr.pizzeria.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import fr.pizzeria.dao.pizza.IPizzaDao;

@Configuration
@EnableJpaRepositories("fr.pizzeria.repos")
@Import(PizzeriaAppJPAConfig.class)
public class PizzeriaAppSpringDataConfig {
	
	@Bean
	@Qualifier("daoImpl")
	public IPizzaDao getPizzaDao(@Qualifier("pizzaDaoSpringData") IPizzaDao pizzaDao) {
		return pizzaDao;
	}

}
