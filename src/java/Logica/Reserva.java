package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reserva implements Serializable {
    //Atributos
    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO )
    int idReserva;
    @Temporal(TemporalType.DATE)
    Date fechaIngreso;
    @Temporal(TemporalType.DATE)
    Date fechaSalida;
    @Basic
    boolean estado;
    @OneToOne
    Habitacion habitacion;
    
    //Constructores
    public Reserva() {
    }

    public Reserva(int idReserva, Date fechaIngreso, Date fechaSalida, boolean estado, Habitacion habitacion) {
        this.idReserva = idReserva;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.estado = estado;
        this.habitacion = habitacion;
    }
    
    //Getter and setter
    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    
}
