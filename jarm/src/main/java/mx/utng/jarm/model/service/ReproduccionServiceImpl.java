package mx.utng.jarm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.utng.jarm.model.dao.IReproduccionDao;
import mx.utng.jarm.model.entity.Reproduccion;
/*
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class ReproduccionServiceImpl implements IReproduccionService{

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private IReproduccionDao reproduccionDao;

    @Transactional(readOnly = true)
    @Override
    public List<Reproduccion> list() {
        return reproduccionDao.list();
    }

    @Transactional
    @Override
    public void save(Reproduccion reproduccion) {
       reproduccionDao.save(reproduccion);
    }

    @Transactional(readOnly = true)
    @Override
    public Reproduccion getById(Long id) {
        return reproduccionDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        reproduccionDao.delete(id);
    }
    
}
