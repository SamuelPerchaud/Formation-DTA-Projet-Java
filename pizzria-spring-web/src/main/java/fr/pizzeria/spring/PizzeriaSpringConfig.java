package fr.pizzeria.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import fr.pizzeria.config.PizzeriaAppSpringConfig;
import fr.pizzeria.config.PizzeriaAppSpringDataConfig;

@Configuration
@EnableWebMvc
@ComponentScan("fr.pizzeria.spring.mvc.controller")
@Import(PizzeriaAppSpringDataConfig.class)

public class PizzeriaSpringConfig {

}
