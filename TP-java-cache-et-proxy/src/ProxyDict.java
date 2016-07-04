import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.TreeMap;

public class ProxyDict<T> implements DictPersistantIntf<T> {

	private Map<String, T> cache = new TreeMap<String, T>();
	DictPersistantIntf<String> dico = new DictPersistant<String>();

	public boolean ajoute(String cle, T objet) {
		System.out.println("                        ajoute proxy");

		if (cache.containsKey(cle)) {
			return true;}
		else{
			//appel dico
			cache.put(cle, objet);
			return dico.ajoute(cle, (String) objet);
		}
	
		
	}

	public T get(String cle) {
		System.out.println("                         get proxy");

		if (cache.containsKey(cle)) {
			return cache.get(cle);
		} else {
			cache.put(cle, cache.get(cle));
			return (T) dico.get(cle);
		}

		// return null;
	}
}
