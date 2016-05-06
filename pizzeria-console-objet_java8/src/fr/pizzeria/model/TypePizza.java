package fr.pizzeria.model;

public enum TypePizza {
	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans Viande");

	private String libelle;

	private TypePizza(String libelle) {
		this.libelle = libelle;
	}

	public String toString() {
		return libelle;
	}

	public String getLibelle() {
		return libelle;
	}
	
}
