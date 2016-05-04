
public class Main {

	public static void main(String[] args) {
		Utilisateur moimeme = new Utilisateur("moimeme");
		Repertoire racine = new Repertoire(moimeme);
		Repertoire rep = new Repertoire(moimeme);

		racine.ajouteNoeuds(rep);
		racine.ajouteNoeuds(new Fichier(moimeme, 100));

		SystemeFichier systemeFichier = new SystemeFichier(racine);
		
		
		
		VisiteurCalculNombre visiteurnombre = new VisiteurCalculNombre();
		
		
		
	}

}
