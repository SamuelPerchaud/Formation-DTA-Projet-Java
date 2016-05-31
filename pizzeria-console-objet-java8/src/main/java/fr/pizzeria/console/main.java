package fr.pizzeria.console;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dao-memoire-config.xml")) {
			Afficher menu = context.getBean(Afficher.class);
			menu.afficher();
		}

	}

}
