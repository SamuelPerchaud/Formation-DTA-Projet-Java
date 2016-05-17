package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.DaoFactory;
import fr.pizzeria.model.Client;

public class InscriptionOptionMenu extends AbstractOptionMenuClient {

	private static final String INSCRIPTION_CLIENT_LIBELLE_MENU = "inscription";

	public InscriptionOptionMenu(DaoFactory daoFactory, Scanner sc) {
		super(INSCRIPTION_CLIENT_LIBELLE_MENU, daoFactory, sc);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute() {
		Client newClient = new Client();
		System.out.println("Veuillez saisir le nom");
		newClient.setNom(sc.next());
		
		System.out.println("Veuillez saisir le prenom");
		newClient.setPrenom(sc.next());

		System.out.println("Veuillez saisir le email");
		newClient.setEmail(sc.next());

		System.out.println("Veuillez saisir le mot de passe");
		newClient.setMdp(sc.next());
		
		daoFactory.getClientDao().saveClient(newClient);
		
		
		
		return true;
	}

}
