package mx.utng.jarm.model.dao;

import java.util.List;

import mx.utng.jarm.model.entity.Consumo;


public interface IConsumoDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar estudiantes
    List<Consumo> list();

    //Guardar un estudiante
    void save(Consumo consumo);

    //Obterner un estudiante en especifico a partir del id
    Consumo getById(Long id);

    //Eliminar un estudiante por el id
    void delete(Long id);
}
