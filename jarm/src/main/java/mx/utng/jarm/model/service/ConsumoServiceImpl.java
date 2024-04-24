package mx.utng.jarm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.utng.jarm.model.dao.IConsumoDao;
import mx.utng.jarm.model.entity.Consumo;
/*
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class ConsumoServiceImpl implements IConsumoService{

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private IConsumoDao consumoDao;

    @Transactional(readOnly = true)
    @Override
    public List<Consumo> list() {
        return consumoDao.list();
    }

    @Transactional
    @Override
    public void save(Consumo consumo) {
        consumoDao.save(consumo);
    }

    @Transactional(readOnly = true)
    @Override
    public Consumo getById(Long id) {
        return consumoDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        consumoDao.delete(id);
    }
    
}
