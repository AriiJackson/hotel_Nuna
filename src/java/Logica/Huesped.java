package Logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Huesped extends Persona implements Serializable {
    //Atributos
    @Basic
    private String profesion;
    @OneToMany
    private List<Reserva> listaReserva;
    
    //Constructores
    public Huesped() {
    }

    public Huesped(String profesion, List<Reserva> listaReserva, long idPersona, String dni, String nombre, String apellido, String direccion, String telefono, Date fechaNacimiento) {
        super(idPersona, dni, nombre, apellido, direccion, telefono, fechaNacimiento);
        this.profesion = profesion;
        this.listaReserva = listaReserva;
    }
    
    //Getter and setter
    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public List<Reserva> getListaReserva() {
        return listaReserva;
    }

    public void setListaReserva(List<Reserva> listaReserva) {
        this.listaReserva = listaReserva;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getApellido() {
        return apellido;
    }

    @Override
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    @Override
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public long getIdPersona() {
        return idPersona;
    }

    @Override
    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public String getDni() {
        return dni;
    }

    @Override
    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String getTelefono() {
        return telefono;
    }

    @Override
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
