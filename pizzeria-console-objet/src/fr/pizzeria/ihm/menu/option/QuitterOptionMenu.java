package fr.pizzeria.ihm.menu.option;

public class QuitterOptionMenu extends AbstractOptionMenu {

	private static final String QUITTER_LIBELLE = "quitter";

	public QuitterOptionMenu() {
		super(QUITTER_LIBELLE);
		// this.libelle = "quitter";
	}

	@Override
	public boolean execute() {
		System.out.println("quitter");
		return false;
	}

}
