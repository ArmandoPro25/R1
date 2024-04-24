package mx.utng.jarm.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Reproduccion {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (length = 40, nullable = false)
    @NotEmpty
    private String nombreLista;

    @Column (length = 100, nullable = false)
    @NotEmpty
    private String canciones;

    //GETTERS AND SETTERS

public String getCanciones() {
    return canciones;
}
public Long getId() {
    return id;
}
public String getNombreLista() {
    return nombreLista;
}
public void setCanciones(String canciones) {
    this.canciones = canciones;
}
public void setId(Long id) {
    this.id = id;
}
public void setNombreLista(String nombreLista) {
    this.nombreLista = nombreLista;
}


}
