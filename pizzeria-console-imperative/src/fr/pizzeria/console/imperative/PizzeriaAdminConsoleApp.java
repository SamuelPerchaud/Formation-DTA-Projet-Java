package fr.pizzeria.console.imperative;

import java.util.Scanner;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Object [][] pizza = new Object[100][3];
		pizza[0] = new Object[] {"PEP","Pépéroni",12.50};
		pizza[1] = new Object[] {"MAR","Margherita",14.00};
		pizza[2] = new Object[] {"REI","La Reine",11.50};
		pizza[3] = new Object[] {"FRO","La 4 fromage",12.00};
		pizza[4] = new Object[] {"CAN","La cannibale",12.50};
		pizza[5] = new Object[] {"SAV","La savoyarde",13.00};
		pizza[6] = new Object[] {"ORI","L'orientale",13.50};
		pizza[7] = new Object[] {"IND","l'indienne",14.00};

		
		do{
		System.out.println("***** Pizzeria Administration *****");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre à jor une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");
		int nb = sc.nextInt();
		switch(nb){
		case (1) : 
			for(int i=0;i<100; i++){
				if(pizza[i][0]!=null){				
					System.out.println(pizza[i][0]+"->"+pizza[i][1]+" ("+pizza[i][2]+" €)");
				}
			}
			break;
		case (2) : 
			int nouvellePizza=0;
		for(int i=0;i<100; i++){
			if(pizza[i][0]!=null){
				nouvellePizza = i+1;
			}
		}
		System.out.println("veuillez saisir le code de la nouvelle pizza");
		String scanMiseAjour = sc.next();
		pizza[nouvellePizza][0]=scanMiseAjour;
		System.out.println("veuillez saisir le nom");
		scanMiseAjour = sc.next();
		pizza[nouvellePizza][1]=scanMiseAjour;
		System.out.println("veuillez saisir le prix");
		double prix = sc.nextDouble();
		pizza[nouvellePizza][2]=prix;
			break;	
		case (3) : 

		for(int i=0;i<100; i++){
			if(pizza[i][0]!=null){				
				System.out.println(pizza[i][0]+"->"+pizza[i][1]+" ("+pizza[i][2]+" €)");
			}
		}
		System.out.println("choisissez une pizza a mettre a jour");
		String scanMiseAJour = sc.next();
		if(scanMiseAJour=="99"){
			break;
		}
		System.out.println("choisissez le nouveau code");
		scanMiseAJour = sc.next();
		int PizzaMiseAJour=0;
		for(int i=0;i<100; i++){
		if(pizza[i][0]!=scanMiseAJour){
			PizzaMiseAJour = i;
		}
		}
		pizza[PizzaMiseAJour][0]	=scanMiseAJour;
		System.out.println("choisissez le nouveau nom");
		scanMiseAJour = sc.next();
		pizza[PizzaMiseAJour][1]	=scanMiseAJour;
		System.out.println("choisissez le nouveau prix");
		pizza[PizzaMiseAJour][1]	=sc.nextInt();;
	
			break;
		case (4) : 
			break;
		case (99) : 
			break;
		default :System.out.println("entrer un numero de menu valide");

		
		}
		}while (true);

	}

}
