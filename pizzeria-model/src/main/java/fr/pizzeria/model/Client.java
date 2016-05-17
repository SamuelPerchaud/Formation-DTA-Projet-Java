package fr.pizzeria.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
//@NamedQuery(name="pizza.getcode",query="SELECT p FROM Pizza p WHERE p.code=:code")
public class Client {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer id;
	// @ToString
	private String prenom;
	// @ToString(uppercase = true)
	private String nom;
	// @ToString
	private String email;
	// @ToString @Enumerated (EnumType.STRING)
	private String mdp;

	@OneToMany(mappedBy="client")
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Set<Commande> getCommande() {
		return commande;
	}

	public void setCommande(Set<Commande> commande) {
		this.commande = commande;
	}

}
