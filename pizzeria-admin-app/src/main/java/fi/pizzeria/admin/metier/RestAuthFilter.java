package fi.pizzeria.admin.metier;

import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

@Provider
public class RestAuthFilter implements ContainerRequestFilter {

	@Inject
	private TokenService tokenService;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String token = requestContext.getHeaderString("auth");

		if (TokenService.isTokenValid(token)) {
			// cas auth
		} else {
			// ccas non auth
			if (!requestContext.getUriInfo().getPath().contains("/login")) {
				//non auth
				requestContext.abortWith(Response.status(Status.FORBIDDEN).build());
			}else {
				
				// cas login
			}
		}

	}

}
