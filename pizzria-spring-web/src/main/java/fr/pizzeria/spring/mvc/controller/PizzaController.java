package fr.pizzeria.spring.mvc.controller;

import java.lang.ProcessBuilder.Redirect;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoImpl;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

	@Autowired
	public IPizzaDao pizzaDao;

	@RequestMapping(method = RequestMethod.GET)
	//@ResponseBody
	public ModelAndView bonjour() throws DaoException, SQLException {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/vueBonjour.jsp");
		List<Pizza> pizzas = pizzaDao.findAllPizzas();
System.out.println("test");
		mav.addObject("pizzas", pizzas);
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST)
	//@ResponseBody
	public String bonjour2(@RequestParam("code") String code,@RequestParam("prix")BigDecimal prix,@RequestParam("nom")String nom,@RequestParam("categorie")String categorie) throws DaoException, SQLException {
		System.out.println("testPost");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/vueBonjour.jsp");
		Pizza newPizza = new Pizza(code, nom, prix, CategoriePizza.valueOf(categorie));
		System.out.println(newPizza);
		pizzaDao.savePizza(newPizza);
		//mav.addObject("pizzas", pizzas);
		return "redirect:/api/pizzas";
	}
	
	
}
