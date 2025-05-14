package sd.solicitudes;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import jakarta.inject.Inject;
import sd.solicitudes.bussiness.EstudianteGestion;
import sd.solicitudes.models.Estudiante;
import java.util.List;

@Path("/estudiantes")
@Produces(MediaType.APPLICATION_JSON)
public class EstudianteService {

    @Inject
    private EstudianteGestion estudianteGestion;

    @POST
    @Path("/crear")
    public Response crearEstudiante(Estudiante estudiante) {
        estudianteGestion.crearEstudiante(estudiante);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response actualizarEstudiante(@PathParam("id") Long id, Estudiante estudiante) {
        Estudiante existente = estudianteGestion.obtenerEstudiante(id);
        if (existente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        // Actualizar campos
        existente.setNombre(estudiante.getNombre());
        existente.setEmail(estudiante.getEmail());
        estudianteGestion.actualizarEstudiante(existente);

        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response eliminarEstudiante(@PathParam("id") Long id) {
        boolean eliminado = estudianteGestion.eliminarEstudiante(id);
        if (!eliminado) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }

    @GET
    @Path("/listar")
    public Response obtenerEstudiantes() {
        List<Estudiante> estudiantes = estudianteGestion.obtenerTodos();
        if (estudiantes.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(estudiantes).build();
    }

}
