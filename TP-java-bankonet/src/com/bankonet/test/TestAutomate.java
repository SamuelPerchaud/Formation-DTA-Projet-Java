package com.bankonet.test;

import com.bankonet.ICompteStat;

public class TestAutomate {

	public TestAutomate() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
float moyenne = 0;
		ICompteStat[] tabComptes = DonneesTest.construitEchantillonComptes();
		for(ICompteStat b :tabComptes){
			moyenne += b.getSolde();
			
			
		}
		moyenne =moyenne/tabComptes.length;
		System.out.println("la moyenne des comptes est :"+moyenne);
		
		
	}

}
