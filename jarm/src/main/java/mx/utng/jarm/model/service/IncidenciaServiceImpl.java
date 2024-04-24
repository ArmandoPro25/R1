package mx.utng.jarm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.utng.jarm.model.dao.IIncidenciaDao;
import mx.utng.jarm.model.entity.Incidencia;
/*
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class IncidenciaServiceImpl implements IIncidenciaService{

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private IIncidenciaDao incidenciaDao;

    @Transactional(readOnly = true)
    @Override
    public List<Incidencia> list() {
        return incidenciaDao.list();
    }

    @Transactional
    @Override
    public void save(Incidencia incidencia) {
        incidenciaDao.save(incidencia);
    }

    @Transactional(readOnly = true)
    @Override
    public Incidencia getById(Long id) {
        return incidenciaDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        incidenciaDao.delete(id);
    }
    
}
