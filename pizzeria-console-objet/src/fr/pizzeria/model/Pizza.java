package fr.pizzeria.model;

import java.lang.reflect.Field;

//import java.text.Format.Field;

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
	 @ToString public String code;
	@ToString public String nom;
	 public double prix;
	 @ToString public static int nbPizzas;
	public TypePizza type;
	
	
	
	@Override
	public String toString() {
		//System.out.println("test");
		String value = " ";
		for(Field champ : this.getClass().getDeclaredFields()){
			ToString annotation = champ.getAnnotation(ToString.class);
			if(annotation != null){
				try {
					//boolean uppercase = annotation.uppercase();
					Object valeurChamp = champ.get(this);
					//value += uppercase ? valeurChamp.toString().toUpperCase() : valeurChamp + " ";
					value += valeurChamp + " ";

				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				//f.get(this);
			}
			
		}
		
		
		
		return value;
	}
	
	
	
	
	
}
