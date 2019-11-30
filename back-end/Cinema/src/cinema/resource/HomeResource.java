package cinema.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class HomeResource {
	@GET
	public String index() {
		return "Hello World!";
	}
	
	
	
}
