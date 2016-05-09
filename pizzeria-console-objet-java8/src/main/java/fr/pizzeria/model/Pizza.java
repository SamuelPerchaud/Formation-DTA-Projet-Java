package fr.pizzeria.model;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Pizza {

	private int id;
	@ToString
	private String code;
	@ToString(uppercase = true)
	private String nom;
	@ToString
	private double prix;
	@ToString
	private CategoriePizza categorie;

	public static int nbPizzas;

	public Pizza() {
		this.categorie = CategoriePizza.INDEFINI;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categorie == null) ? 0 : categorie.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + id;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prix);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		if (categorie != other.categorie)
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (id != other.id)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (Double.doubleToLongBits(prix) != Double.doubleToLongBits(other.prix))
			return false;
		return true;
	}

	public Pizza(String code, String nom, double prix, CategoriePizza cat) {
		this();
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = cat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Utiliser plutôt getNouveauPrix()
	 * 
	 * @return
	 */
	@Deprecated
	public double getPrix() {
		return prix;
	}

	public double getNouveauPrix() {
		// super algo
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public CategoriePizza getCategorie() {
		return categorie;
	}

	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {

		return Arrays.asList(this.getClass().getDeclaredFields()).stream()
				.filter(field -> field.getAnnotation(ToString.class) != null)
				.map(field -> {
					try {
						return field.getAnnotation(ToString.class).uppercase()
								? field.get(this).toString().toUpperCase() : field.get(this).toString();
					} catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
						e.printStackTrace();
						return "";
					}
				})
				//.sorted(field -> field.)
				.collect(Collectors.joining("  "));

		/**
		 * for(Field champ : this.getClass().getDeclaredFields()) { ToString
		 * annotation = champ.getAnnotation(ToString.class);
		 * 
		 * if(annotation != null) { try { boolean uppercase =
		 * annotation.uppercase();
		 * 
		 * Object valeurDuChamp = champ.get(this);
		 * 
		 * value += uppercase ? valeurDuChamp.toString().toUpperCase() :
		 * valeurDuChamp + " "; } catch (IllegalArgumentException |
		 * IllegalAccessException e) { e.printStackTrace(); } } }
		 */
		// return value;
	}

}
