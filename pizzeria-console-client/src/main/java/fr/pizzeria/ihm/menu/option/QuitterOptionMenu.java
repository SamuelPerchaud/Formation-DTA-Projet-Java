package fr.pizzeria.ihm.menu.option;

public class QuitterOptionMenu extends AbstractOptionMenuClient {

	private static final String QUITTER_CLIENT_LIBELLE_MENU = "quitter";

	public QuitterOptionMenu() {
		super(QUITTER_CLIENT_LIBELLE_MENU, null, null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute() {
		System.out.println("fin du prog ! ! !");
		return false;
	}

}
