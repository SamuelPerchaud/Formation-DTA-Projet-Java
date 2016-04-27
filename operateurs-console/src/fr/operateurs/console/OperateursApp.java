package fr.operateurs.console;

import java.util.Scanner;

public class OperateursApp {

	public static void main(String[] args) {
		System.out.println("Bonjour");
		Scanner sc = new Scanner(System.in);
		System.out.println("veuillez saisir un premier nombre");
		double nb = sc.nextDouble();
		System.out.println("votre premier nombre est : " + nb);
		System.out.println("veuillez saisir un deuxieme nombre");
		double nb2 = sc.nextDouble();
		System.out.println("votre deuxieme nombre est : " + nb2);
		System.out.println("addition     :" + nb + " + " + nb2 + " = " + (nb + nb2));
		System.out.println("différence   :" + nb + " - " + nb2 + " = " + (nb - nb2));
		System.out.println("produit      :" + nb + " * " + nb2 + " = " + (nb * nb2));
		System.out.println("division     :" + nb + " / " + nb2 + " = " + (nb / nb2));
		System.out.println("modulo       :" + nb + " % " + nb2 + " = " + (nb % nb2));

		sc.close();
	}

}
