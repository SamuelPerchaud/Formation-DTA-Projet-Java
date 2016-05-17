package fr.pizzeria.dao.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import fr.pizzeria.model.Client;
import fr.pizzeria.model.Pizza;

public class ClientDaoJPA implements IClientDao {

	// private Map<String, Client> clients = new HashMap<String, Client>();
	public EntityManagerFactory emf;

	public ClientDaoJPA(EntityManagerFactory emf) {
		super();
		this.emf = emf;

	}

	@Override
	public void saveClient(Client client) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Client newclient1 =null;
		try {
			client = em.createNamedQuery("client.getnom", Client.class).setParameter("code", client.getNom())
					.getSingleResult();
			System.err.println("INFO---- Client deja present");
			em.close();

		} catch (NoResultException e) {
			em.persist(newclient1);
			// System.err.println(newPizza);
			et.commit();
			em.close();
			System.err.println("INFO---- pizza inséré  : " + newclient1);
			// EntityNotFoundException e
		}

	}

	@Override
	public void connectionClient(String codeClient, Client newClient) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteClient(String codeClient) {
		// TODO Auto-generated method stub

	}

}
