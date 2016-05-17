package fr.pizzeria.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
//@NamedQuery(name="pizza.getcode",query="SELECT p FROM Pizza p WHERE p.code=:code")
public class Commande {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String numero_commande;
	private StatusCommande status;
	private String date_commande;

	@ManyToOne @JoinColumn(name="livreur_id")
	private Livreur livreur;
	@ManyToOne @JoinColumn(name="Client_id")
	private Client client;
	@ManyToMany
	@JoinTable(name="Commande_Pizza",
		joinColumns=
		@JoinColumn(name="ID_commande", referencedColumnName="id"),
		inverseJoinColumns=
		@JoinColumn(name="ID_pizza",referencedColumnName="id")
	
			
			)
		private List<Pizza> pizza;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumero_commande() {
		return numero_commande;
	}
	public void setNumero_commande(String numero_commande) {
		this.numero_commande = numero_commande;
	}
	public StatusCommande getStatus() {
		return status;
	}
	public void setStatus(StatusCommande status) {
		this.status = status;
	}
	public String getDate_commande() {
		return date_commande;
	}
	public void setDate_commande(String date_commande) {
		this.date_commande = date_commande;
	}
	public Livreur getLivreur() {
		return livreur;
	}
	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Pizza> getPizza() {
		return pizza;
	}
	public void setPizza(List<Pizza> pizza) {
		this.pizza = pizza;
	}
	

}
