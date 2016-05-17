package fr.pizzeria.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
//@NamedQuery(name="pizza.getcode",query="SELECT p FROM Pizza p WHERE p.code=:code")
public class Livreur {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)	private Integer id;
	// @ToString
	private String prenom;
	// @ToString(uppercase = true)
	private String nom;
	// @ToString
	
	@OneToMany(mappedBy="livreur")
	private Set<Commande> commande;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	

}
