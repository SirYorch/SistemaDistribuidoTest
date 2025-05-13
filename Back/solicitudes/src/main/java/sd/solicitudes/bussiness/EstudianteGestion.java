package sd.solicitudes.bussiness;


import jakarta.inject.Inject;
import sd.solicitudes.dao.EstudianteDAO;
import sd.solicitudes.models.Estudiante;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class EstudianteGestion {

    @Inject
    private EstudianteDAO estudianteDAO;

    @Transactional
    public void crearEstudiante(Estudiante estudiante) {
        estudianteDAO.create(estudiante);
    }

    public Estudiante obtenerEstudiante(Long id) {
        return estudianteDAO.find(id);
    }

    public List<Estudiante> obtenerTodos() {
        return estudianteDAO.findAll();
    }

    @Transactional
    public void actualizarEstudiante(Estudiante estudiante) {
        estudianteDAO.update(estudiante);
    }

    @Transactional
    public boolean eliminarEstudiante(Long id) {
        return estudianteDAO.delete(id);
    }
}
