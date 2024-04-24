package mx.utng.jarm.model.service;

import java.util.List;

import mx.utng.jarm.model.entity.Consumo;


public interface IConsumoService {
    List<Consumo> list();
    void save(Consumo consumo);
    Consumo getById(Long id);
    void delete(Long id);
}
