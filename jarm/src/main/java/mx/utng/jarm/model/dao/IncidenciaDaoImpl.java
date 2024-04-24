package mx.utng.jarm.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.jarm.model.entity.Incidencia;

@Repository
public class IncidenciaDaoImpl implements IIncidenciaDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Incidencia> list() {
        return em.createQuery("from Incidencia").getResultList();
    }

    @Override
    public void save(Incidencia incidencia) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(incidencia.getId() != null && incidencia.getId()>0){
            em.merge(incidencia);
        }else{
            //Registro nuevo al usar persist
            em.persist(incidencia);
        }
    }

    @Override
    public Incidencia getById(Long id) {
        return em.find(Incidencia.class, id);
    }

    @Override
    public void delete(Long id) {
      Incidencia incidencia = getById(id);
      em.remove(incidencia);
    }
    

}