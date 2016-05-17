package fr.pizzeria.dao.client;

import java.util.HashMap;
import java.util.Map;

import fr.pizzeria.model.*;

public interface IClientDao {
	Map<String, Client> clients = new HashMap<String, Client>();

	void saveClient(Client client);

	void connectionClient(String codeClient, Client newClient);

	void deleteClient(String codeClient);

}
