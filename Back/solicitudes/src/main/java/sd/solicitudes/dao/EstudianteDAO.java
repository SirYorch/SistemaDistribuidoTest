package sd.solicitudes.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import sd.solicitudes.models.Estudiante;

import java.util.List;

@Stateless
public class EstudianteDAO {
    
    @PersistenceContext
    private EntityManager em;

    public void create(Estudiante estudiante) {
        em.persist(estudiante);
    }

    public Estudiante find(Long id) {
        return em.find(Estudiante.class, id);
    }

    public List<Estudiante> findAll() {
        return em.createQuery("SELECT u FROM Estudiante u", Estudiante.class).getResultList();
    }

    public void update(Estudiante estudiante) {
    // Buscar el estudiante existente por id
    Estudiante estudianteExistente = em.find(Estudiante.class, estudiante.getId());
    
    if (estudianteExistente != null) {
        // Actualizar los campos del estudiante existente
        estudianteExistente.setNombre(estudiante.getNombre());
        estudianteExistente.setEmail(estudiante.getEmail());
        // Actualiza otros campos según sea necesario

        // Sin necesidad de persistir, solo actualizar en la base de datos
        em.merge(estudianteExistente);
    } else {
        // Si no se encuentra el estudiante, lanzar excepción o manejar el caso según sea necesario
        throw new EntityNotFoundException("Estudiante no encontrado con id: " + estudiante.getId());
    }
}


    public boolean delete(Long id) {
        Estudiante estudiante = em.find(Estudiante.class, id);
        if (estudiante != null) {
            em.remove(estudiante);
            return true;
        }
        return false;
    }
}
