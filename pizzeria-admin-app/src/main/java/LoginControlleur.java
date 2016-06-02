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
import fr.pizzeria.dao.pizza.PizzaDaoImpl;
import fr.pizzeria.dao.pizza.PizzaDaoJPA;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class LoginControlleur extends HttpServlet {

	private static final Logger LOG = Logger.getLogger(LoginControlleur.class.toString());

	//private IPizzaDao pizzaDao = IPizzaDao.DEFAULT_IMPLEMENTATION;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
		dispatcher.forward(req, resp);
		// resp.getWriter().write(listPizzas.toString());
		/*
		 * resp.getWriter().write("["); resp.getWriter().write(listPizzas.stream
		 * ().map(Pizza::toJson).collect(Collectors.joining()));
		 * resp.getWriter().write("]");
		 */

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login =  req.getParameter("login");
		String password =  req.getParameter("password");

		if (login.equals("admin") && password.equals("admin")) {
			req.getSession().setAttribute("logged", 1);
		resp.sendRedirect(req.getContextPath()+"/pizzas/list");

		} else {
			resp.sendError(400, "login/password invalide");
		}

		
	}

}
