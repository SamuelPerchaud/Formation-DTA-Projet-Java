package fi.pizzeria.admin.metier;


import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/login")
public class LoginRessource {

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response login(@FormParam("email") String email, @FormParam("motDePasse") String motDePasse){
		
		Response resp = null;
		
		if("admin".equals(email) && "admin".equals(motDePasse)){
			String token = TokenService.generateToken();
			//UUID token = UUID.randomUUID();
			resp = Response.ok(token).build();
		}else {
			resp = Response.status(Status.FORBIDDEN).build();
		}
		return resp;
		
		
	}
}
