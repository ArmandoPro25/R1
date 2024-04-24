package mx.utng.jarm.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.jarm.model.entity.Reproduccion;

@Repository
public class ReproduccionDaoImpl implements IReproduccionDao {

    // Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Reproduccion> list() {
        return em.createQuery("from Reproduccion").getResultList();
    }

    @Override
    public void save(Reproduccion reproduccion) {
        // Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if (reproduccion.getId() != null && reproduccion.getId() > 0) {
            em.merge(reproduccion);
        } else {
            // Registro nuevo al usar persist
            em.persist(reproduccion);
        }
    }

    @Override
    public Reproduccion getById(Long id) {
        return em.find(Reproduccion.class, id);
    }

    @Override
    public void delete(Long id) {
        Reproduccion reproduccion = getById(id);
        em.remove(reproduccion);
    }
}
