package mx.utng.jarm.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.jarm.model.entity.Consumo;

@Repository
public class ConsumoDaoImpl implements IConsumoDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Consumo> list() {
        return em.createQuery("from Consumo").getResultList();
    }

    @Override
    public void save(Consumo consumo) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(consumo.getId() != null && consumo.getId()>0){
            em.merge(consumo);
        }else{
            //Registro nuevo al usar persist
            em.persist(consumo);
        }
    }

    @Override
    public Consumo getById(Long id) {
        return em.find(Consumo.class, id);
    }

    @Override
    public void delete(Long id) {
      Consumo consumo = getById(id);
      em.remove(consumo);
    }
    

}