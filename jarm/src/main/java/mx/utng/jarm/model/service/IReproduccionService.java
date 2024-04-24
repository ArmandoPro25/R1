package mx.utng.jarm.model.service;

import java.util.List;

import mx.utng.jarm.model.entity.Reproduccion;


public interface IReproduccionService {
    List<Reproduccion> list();
    void save(Reproduccion reproduccion);
    Reproduccion getById(Long id);
    void delete(Long id);
}
