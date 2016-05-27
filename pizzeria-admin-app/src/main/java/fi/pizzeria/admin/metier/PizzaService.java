package fi.pizzeria.admin.metier;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.collections4.ListUtils;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;


@Path("/pizzas")
@Stateless
public class PizzaService  {
	@Inject private IPizzaDao pizzaDao;
	@PersistenceContext(unitName="pizzeria-admin-app") private EntityManager em;
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pizza> findAllPizzas() throws DaoException, SQLException {
		List<Pizza> listPizza = em.createQuery("SELECT p FROM Pizza p", Pizza.class).getResultList();
		return listPizza;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void savePizza(Pizza newPizza) throws DaoException, SQLException {
		Pizza pizza = null;
		try {
			pizza = em.createNamedQuery("pizza.getcode", Pizza.class).setParameter("code", newPizza.getCode())
					.getSingleResult();
			System.err.println("INFO---- Pizza deja presente");

		} catch (NoResultException e) {
			em.persist(newPizza);
			// System.err.println(newPizza);
			System.err.println("INFO---- pizza inséré  : " + newPizza);
			// EntityNotFoundException e
		}

	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public void updatePizza(String codePizza, Pizza updatePizza) throws DaoException, SQLException {
		Pizza pizza = em.createNamedQuery("pizza.getcode", Pizza.class).setParameter("code", codePizza)
				.getSingleResult();
		if (pizza != null) {
			pizza.setCode(updatePizza.getCode());
			pizza.setNom(updatePizza.getNom());
			pizza.setPrix(updatePizza.getPrix());
			pizza.setCategorie(updatePizza.getCategorie());
		}

		// em.merge(pizza);
		System.err.println("la pizza : " + pizza + "a été mise a jour");
		}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void deletePizza(String codePizza)  {
		Pizza pizza = em.createNamedQuery("pizza.getcode", Pizza.class).setParameter("code", codePizza)
				.getSingleResult();
		em.remove(pizza);
		System.err.println("la pizza : " + pizza + "a été supprimé");

		
	}		
	

	//@PostConstruct
	public void importPizza() {
		List<List<Pizza>> test = new ArrayList<List<Pizza>>();
		List<Pizza> listPizza;
		try {
			URL resource = Thread.currentThread().getContextClassLoader().getResource("data");
			this.getClass().getResource("data");
			 listPizza = Files.list(Paths.get(resource.toURI())).map(path -> {
				Pizza p = new Pizza();
				p.setCode(path.getFileName().toString().replaceAll(".txt", ""));
				try {
					String ligne = Files.readAllLines(path).get(0);
					String[] ligneTab = ligne.split(";");
					p.setNom(ligneTab[0]);
					p.setPrix(new BigDecimal(ligneTab[1]));
					p.setCategorie(CategoriePizza.valueOf(ligneTab[2]));
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.err.println("INFO----IMPORT de " + p);

				return p;
			}).collect(Collectors.toList());
			 test = ListUtils.partition(listPizza, 3);

				for (List<Pizza> listPizzaparcour : test) {
					for (Pizza pizza : listPizzaparcour) {
						// System.err.println("INFO----IMPORT de " + pizza);
						savePizza(pizza);
					}
				}	
		} catch (IOException e) {
			// TODO logger à faire
			e.printStackTrace();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
}
