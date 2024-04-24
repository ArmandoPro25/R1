package mx.utng.jarm.model.dao;

import java.util.List;

import mx.utng.jarm.model.entity.Reproduccion;


public interface IReproduccionDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar estudiantes
    List<Reproduccion> list();

    //Guardar un estudiante
    void save(Reproduccion reproduccion);

    //Obterner un estudiante en especifico a partir del id
    Reproduccion getById(Long id);

    //Eliminar un estudiante por el id
    void delete(Long id);
}
