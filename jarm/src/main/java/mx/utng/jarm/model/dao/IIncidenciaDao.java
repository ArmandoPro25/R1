package mx.utng.jarm.model.dao;

import java.util.List;

import mx.utng.jarm.model.entity.Incidencia;


public interface IIncidenciaDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar estudiantes
    List<Incidencia> list();

    //Guardar un estudiante
    void save(Incidencia incidencia);

    //Obterner un estudiante en especifico a partir del id
    Incidencia getById(Long id);

    //Eliminar un estudiante por el id
    void delete(Long id);
}
