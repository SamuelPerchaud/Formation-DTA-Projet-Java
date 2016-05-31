package fi.pizzeria.admin.metier;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TokenService {

	private static List<String> tokenValide = new ArrayList<String>();

	public static String generateToken() {
		String token = UUID.randomUUID().toString();
		tokenValide.add(token);
		return token.toString();
	}

	public static boolean isTokenValid(String token) {
		// TODO Auto-generated method stub
		return tokenValide.contains(token);
	}

}
