import java.util.ArrayList;
import java.util.List;

public class Repertoire {

	protected List<Noeud> noeuds = new ArrayList<Noeud>();
	public int taille;

	public Repertoire(Utilisateur util) {
		super();
		// TODO Auto-generated constructor stub
	}

	public void ajouteNoeuds(Noeud rep) {
		noeuds.add(rep);
	}

	public void acceptVisiteur(Visiteur visiteur) {

		visiteur.visiteRepertoire(this);
		for (Noeud n : noeuds) {
			n.accepVisiteur(visiteur);
		}
	}

	
}
