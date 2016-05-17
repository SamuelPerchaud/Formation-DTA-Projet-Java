package fr.pizzeria;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemErrRule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoImpl;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.ihm.menu.option.AjouterNouvellePizzaOptionMenu;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;
public class AjouterNouvellePizzaOptionMenuTest {

	@Rule
	public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();	
	@Rule
	public final SystemErrRule systemErrRule = new SystemErrRule().enableLog();
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	private AjouterNouvellePizzaOptionMenu optionMenu;
	private IPizzaDao pizzaDao;
	@Before
	public void setUp() throws Exception {
		Scanner scanner = new Scanner(System.in);
		pizzaDao = new PizzaDaoImpl();
		optionMenu = new AjouterNouvellePizzaOptionMenu(scanner,pizzaDao);
	}

	@Test
	public void test() throws DaoException, IOException {
		/**systemInMock.provideLines("NEW","Newton","15.25","0");
		boolean next = optionMenu.execute();
		assertTrue(next);
		List<Pizza> allPizzas = pizzaDao.findAllPizzas();
		Optional<Pizza> pizzaOpt = allPizzas.stream().filter(p -> "NEW".equals(p.getCode())).findFirst();
		assertTrue(pizzaOpt.isPresent());
		Pizza pizza = pizzaOpt.get();
		assertEquals("Newton", pizza.getNom());
		assertTrue(pizza.getNouveauPrix()== 15.25);
		assertEquals(CategoriePizza.VIANDE,pizza.getCategorie());
		
		String outAttendu = Files.lines(Paths.get("test/fr/pizzeria/ihm/menu/option/resultatAjouterNouvellePizza.txt")).collect(Collectors.joining("\n"));
		outAttendu +="\n";
		assertEquals(outAttendu, systemOutRule.getLog());
		*/
		
		
		
		//fail("Not yet implemented");
	}

}
