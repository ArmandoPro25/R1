package mx.utng.jarm.model.service;

import java.util.List;

import mx.utng.jarm.model.entity.Incidencia;


public interface IIncidenciaService {
    List<Incidencia> list();
    void save(Incidencia incidencia);
    Incidencia getById(Long id);
    void delete(Long id);
}
