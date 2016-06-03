package fr.pizzeria.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Performance {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ToString
	private String service;
	@ToString
	private java.util.Date date;  
	@ToString
	private long tempsExecution;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date2) {
		this.date = date2;
	}
	public long getTempsExecution() {
		return tempsExecution;
	}
	public void setTempsExecution(long tempsExecution) {
		this.tempsExecution = tempsExecution;
	}
	
}
