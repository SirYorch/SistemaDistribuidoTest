package sd.solicitudes;

import jakarta.ws.rs.core.MediaType;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/hola")
public class HolaMundoService {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String saludar() {
		return "{\"mensaje\":\"Hola mundo\"}";
	}
}
