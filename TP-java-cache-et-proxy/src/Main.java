
public class Main {

	public static void main(String[] args) {

DictPersistantIntf<String> dico = new DictPersistant<String>();
dico.ajoute("1", "mots1");
dico.ajoute("2", "mots2");
dico.ajoute("3", "mots3");
dico.ajoute("4", "mots4");
dico.ajoute("5", "mots5");
dico.ajoute("6", "mots6");
System.out.println("sans proxy :"+dico.get("1"));

dico = new ProxyDict<String>();
dico.ajoute("7", "mots 7");
System.out.println("avec proxy :"+dico.get("2"));
System.out.println("avec proxy :"+dico.get("3"));
System.out.println("avec proxy :"+dico.get("7"));
dico.ajoute("8", "mots 8");
System.out.println("avec proxy :"+dico.get("8"));


	}

}
