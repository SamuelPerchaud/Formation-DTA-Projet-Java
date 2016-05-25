import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoJPA;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class EditerPizzaControlleur extends HttpServlet {
	private IPizzaDao pizzaDao = IPizzaDao.DEFAULT_IMPLEMENTATION;
	private static final Logger LOG = Logger.getLogger(EditerPizzaControlleur.class.toString());
	//private IPizzaDao pizzaDao =  new PizzaDaoJPA(Persistence.createEntityManagerFactory( "pizzeria-console-objet-java8" ));;

	//private IPizzaDao pizzaDao = new PizzaDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			List<Pizza> pizzas = pizzaDao.findAllPizzas();
			req.setAttribute("listPizza", pizzas);
			String codePizza =(String) req.getAttribute("code");
			
			Pizza pizza = pizzas.get(0)  ;
						
			for(Pizza p :pizzas){
				if(p.getCode().equals(codePizza)) pizza = p;
				
			}
			
			
			req.setAttribute("Pizza", pizza);
			
			
			
			
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/pizzas/editerPizza.jsp");
			dispatcher.forward(req, resp);

			//resp.getWriter().write(listPizzas.toString());
			/*
			 * resp.getWriter().write("[");
			 * resp.getWriter().write(listPizzas.stream
			 * ().map(Pizza::toJson).collect(Collectors.joining()));
			 * resp.getWriter().write("]");
			 */
		} catch (DaoException e) {
			resp.sendError(500, "Désolé :(");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code");
		String nom = req.getParameter("nom");
		String prix = req.getParameter("prix");
		String cat = req.getParameter("categorie");
		LOG.info("INFO---J'ai bien reçu le POST avec le code = " + code);
		LOG.info("INFO---J'ai bien reçu le param avec le code = " + req.getParameter("anciencode"));
		if (StringUtils.isBlank(code) || StringUtils.isBlank(nom) || StringUtils.isBlank(prix)
				|| StringUtils.isBlank(cat)) {
			resp.sendError(400, "Non non non ! Donnes moi toutes les valeurs !");
		} else {
			Pizza updatePizza = new Pizza(code, nom, new BigDecimal(prix), CategoriePizza.valueOf(cat));
			try {
				pizzaDao.updatePizza(req.getParameter("anciencode"),updatePizza);
				LOG.info("Nouvelle pizza créée");
				resp.sendRedirect("http://localhost:8082/pizzeria-admin-app/pizzas/list");
				//RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/pizzas/list.jsp");
				//dispatcher.forward(req, resp);
			} catch (DaoException e) {
				resp.sendError(500, "Désolé :(");
			} catch (NumberFormatException e) {
				resp.sendError(400, "Format nombre KO :(");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
