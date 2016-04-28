package fr.pizzeria.model;

public class Pizza {

	public Pizza(String code, String nom, double prix) {
		super();
		this.code = code;
		this.nom = nom;
		this.prix = prix;
	}

	public int id;
	public String code;
	public String nom;
	public double prix;
	public static int nbPizzas;
}