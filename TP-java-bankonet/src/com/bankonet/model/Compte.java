package com.bankonet.model;

import com.bankonet.DebitException;
import com.bankonet.ICompteStat;
/**
 * @author fguibert
 */
public abstract class Compte implements ICompteStat  {
	private String libelle;
	private int identifiant;
	protected float solde;

	Compte() { }
	Compte(int id, String libelle, float solde) {
		this.identifiant = id;
		this.libelle = libelle;
		this.solde = solde;
	}
	
	public String toString() {
	        return  " ID  : "+this.getIdentifiant() +" - "+
		    		" Lib : "+this.getLibelle()+" - "+
		    		" Solde : "+this.getSolde()+"€";
	}

	public void crediter(float montant) {
		try {
			this.setSolde( this.getSolde() + montant);
		} catch (BankonetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void debiter(float montant) throws DebitException, BankonetException{
		try {
		this.setSolde( this.getSolde() - montant);
		} catch (BankonetException e) {
			throw e;

		}
	}
	
	
	public void effectuerVirement (Compte compteDebiteur,float montant ) throws BankonetException{
		try {
			this.debiter(montant);
		} catch (DebitException e) {
			throw e;
		}
		
		compteDebiteur.crediter(montant);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public abstract boolean creditAutorise(float montant) throws BankonetException;

	public abstract boolean debitAutorise(float montant) throws BankonetException;

	
	
	
	
	public String getLibelle() {
		return libelle;
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public float getSolde() {
		return solde;
	}

	private void setSolde(float newSolde) throws BankonetException {
		
		
		this.solde = newSolde;
		if(newSolde < 0){
            throw new BankonetException();
 
		}
	}
}
