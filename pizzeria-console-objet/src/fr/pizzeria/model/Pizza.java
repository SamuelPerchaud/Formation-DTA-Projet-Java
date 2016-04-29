package fr.pizzeria.model;

public class Pizza {

	public Pizza(String code, String nom, double prix,TypePizza type) {
		super();
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.type = type;
		
	}

	public Pizza() {
		// TODO Auto-generated constructor stub
	}

	public int id;
	public String code;
	public String nom;
	public double prix;
	public static int nbPizzas;
	public TypePizza type;
	
	
	
	@Override
	public String toString() {
		return "Pizza [code=" + code + ", nom=" + nom + ", prix=" + prix + ", type=" + type + "]";
	}
	
	
	
	
	
}
