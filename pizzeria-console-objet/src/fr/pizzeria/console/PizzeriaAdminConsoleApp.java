package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	private static Pizza[] getTableauPizzas() {
		Pizza[] pizzas = new Pizza[100];
		pizzas[0] = creerPizza( "PEP", "Pépéroni", 12.50 );
		pizzas[1] = creerPizza( "MAR", "Margherita", 14.00 );
		pizzas[2] = creerPizza( "REI", "La Reine", 11.50 );
		pizzas[3] = creerPizza( "FRO", "La 4 fromages", 12.00 );
		pizzas[4] = creerPizza( "CAN", "La cannibale", 12.50);
		pizzas[5] = creerPizza( "SAV", "La savoyarde", 13.00 );
		pizzas[6] = creerPizza( "ORI", "L'orientale", 13.50 );
		pizzas[7] = creerPizza( "IND", "L'indienne", 14.00 );
		return pizzas;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Pizza[] pizzas = getTableauPizzas();

		int saisie = 0;
		do {
			afficherMenuPrincipal();

			saisie = sc.nextInt();

			switch (saisie) {
			case 1:
				listerPizzas(pizzas);
				break;
			case 2:
				ajouterNouvellePizza(sc, pizzas);
				break;
			case 3:
				MettreAJourUnePizza(sc, pizzas);
				break;
			case 4:
				supprimerPizza(sc, pizzas);
				break;
			case 99:
				System.out.println("Aurevoir :-(");
				break;
			}
		} while (saisie != 99);

		sc.close();
	}

	
	private static Pizza creerPizza(String code, String nom, double prix){
		Pizza p = new Pizza();
		p.code = code;
		p.nom = nom;
		p.prix = prix;
		Pizza.nbPizzas++;
		return p;
	}
	
	
	private static void afficherMenuPrincipal() {
		System.out.println("***** Pizzeria Administration *****");
		System.out.println("1. Lister les pizzas ");
		System.out.println("2. Ajouter une nouvelle pizza ");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");
	}

	private static void listerPizzas(Pizza[] pizzas) {
		System.out.println("Liste des pizzas");
		afficherListePizzas(pizzas);
	}

	private static void ajouterNouvellePizza(Scanner sc, Pizza[] pizzas) {
		System.out.println("Ajout d’une nouvelle pizza");
		//boolean placeTrouve = false;
		if (Pizza.nbPizzas < pizzas.length){
			pizzas[Pizza.nbPizzas] = saisirDonneesPizza(sc);
		} else {
			System.err.println("Plus de place pour une nouvelle pizza");

		}
		/*while (Pizza.nbPizzas < pizzas.length) {
			placeTrouve = pizzas[index] == null;
			index++;
		}

		if (placeTrouve) {
			pizzas[index] = saisirDonneesPizza(sc);
		} else {
			System.err.println("Plus de place pour une nouvelle pizza");
		}*/
	}

	private static void MettreAJourUnePizza(Scanner sc,Pizza[] pizzas) {
		System.out.println("Mise à jour d’une pizza");
		afficherListePizzas(pizzas);
		System.out.println("Veuillez choisir la pizza a modifier. (99 pour abandonner)");
		String codePizza = sc.next();
		Object[] resultatRecherche = rechercherPizza(pizzas, codePizza);
		boolean pizzaTrouve = (boolean) resultatRecherche[0];
		int indexPizzaTrouve = (int) resultatRecherche[1];

		if (pizzaTrouve) {
			pizzas[indexPizzaTrouve] = saisirDonneesPizza(sc);
		} else {
			System.err.println("Code pizza non trouvé");
		}
	}

	private static void supprimerPizza(Scanner sc, Pizza[] pizzas) {
		System.out.println("Suppression d’une pizza");
		afficherListePizzas(pizzas);
		System.out.println("Veuillez choisir la pizza a supprimer. (99 pour abandonner)");
		String codePizzaSuppr = sc.next();
		Object[] resultatRecherche = rechercherPizza(pizzas, codePizzaSuppr);
		boolean pizzaTrouve = (boolean) resultatRecherche[0];
		int indexPizzaTrouve = (int) resultatRecherche[1];
		if (pizzaTrouve) {
			pizzas[indexPizzaTrouve] = creerPizza(null,"",0); 
		} else {
			System.err.println("Code pizza non trouvé");
		}
	}

	private static void afficherListePizzas(Pizza[] pizzas) {
		for (int i = 0; i < Pizza.nbPizzas; i++) {
			if (pizzas[i] != null) {
				System.out.println(pizzas[i].code + " -> " + pizzas[i].nom + " (" + pizzas[i].prix + ")");
			}
		}
	}

	private static Object[] rechercherPizza(Pizza[] pizzas, String codePizza) {
		boolean pizzaTrouve = false;
		int indexPizzaTrouve = 0;
		while (!pizzaTrouve && indexPizzaTrouve < pizzas.length) {
			pizzaTrouve = codePizza.equals(pizzas[indexPizzaTrouve]);
			if (!pizzaTrouve) {
				indexPizzaTrouve++;
			}
		}
		return new Object[] { pizzaTrouve, indexPizzaTrouve };
	}

	private static Pizza saisirDonneesPizza(Scanner sc) {
		System.out.println("Veuillez saisir le code");
		String newCode = sc.next();
		System.out.println("Veuillez saisir le nom (sans espace)");
		String newNom = sc.next();
		System.out.println("Veuillez saisir le prix");
		double newPrix = sc.nextDouble();
		
		return creerPizza( newCode, newNom, newPrix );
	}

}