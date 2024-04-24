package mx.utng.jarm.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Consumo {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (length = 40, nullable = false)
    @NotEmpty
    private String fecha;

    @Column (length = 100, nullable = false)
    @NotEmpty
    private String cantidadLitros;

    //GETTERS AND SETTERS

public String getCantidadLitros() {
    return cantidadLitros;
}
public String getFecha() {
    return fecha;
}
public Long getId() {
    return id;
}
public void setCantidadLitros(String cantidadLitros) {
    this.cantidadLitros = cantidadLitros;
}
public void setFecha(String fecha) {
    this.fecha = fecha;
}
public void setId(Long id) {
    this.id = id;
}


}