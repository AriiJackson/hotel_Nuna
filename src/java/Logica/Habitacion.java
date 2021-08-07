package Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Habitacion implements Serializable {
    //Atributos
    @Id
    private int idHabitacion;
    @Basic
    private int piso;
    private String tematica;
    private String tipoHabitacion;
    private float precio;
    
    //Constructores
    public Habitacion () {
    }

    public Habitacion(int idHabitacion, int piso, String tematica, String tipoHabitacion, float precio) {
        this.idHabitacion = idHabitacion;
        this.piso = piso;
        this.tematica = tematica;
        this.tipoHabitacion = tipoHabitacion;
        this.precio = precio;
    }
    
    //Getter and setter
    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    
}
