import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
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

public class LoginFilter implements Filter {
	
	

	@Override
	public void destroy() {
	}


	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse reponse = (HttpServletResponse)resp;
		//chain.doFilter(req, resp);
		
		
		if (request.getSession().getAttribute("logged").equals("1")) {
			
			chain.doFilter(req, resp);

		} else {
			reponse.sendRedirect(request.getContextPath()+"/pizzas/login");
		}
		
		
		
		//String login =(String) req.getAttribute("login");
		//String password =(String) req.getAttribute("password");
		
	}


	@Override
	public void init(FilterConfig arg0) throws ServletException {
			
	}

}
