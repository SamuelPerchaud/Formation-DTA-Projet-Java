package fr.pizzeria.model;

public enum StatusCommande {
	ENCOURS("en cours"), LIVRE("Livré"),INDEFINI("status inconnu");
	
	private String libelle;

	private StatusCommande(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}
}
