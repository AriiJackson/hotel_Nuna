package Persistencia;

import Logica.Empleado;
import Logica.Habitacion;
import Logica.Huesped;
import Logica.Reserva;
import Logica.Usuario;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {

    EmpleadoJpaController empleadoJPA = new EmpleadoJpaController();
    HabitacionJpaController habitacionJPA = new HabitacionJpaController();
    HuespedJpaController huespedJPA = new HuespedJpaController();
    ReservaJpaController reservaJPA = new ReservaJpaController();
    UsuarioJpaController usuarioJPA = new UsuarioJpaController();

    public List<Usuario> getUsuario() {
        List<Usuario> listaUsuario;
        listaUsuario = usuarioJPA.findUsuarioEntities();

        return listaUsuario;
    }

    public void crearEmpleado(Empleado empleado) {
        try {
            empleadoJPA.create(empleado);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearHuesped(Huesped huesped) {
        try {
            huespedJPA.create(huesped);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearReserva(Reserva reserva) {
        try {
            reservaJPA.create(reserva);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Empleado> getEmpleado() {
        List<Empleado> listaEmpleado;
        listaEmpleado = empleadoJPA.findEmpleadoEntities();

        return listaEmpleado;
    }

    public List<Huesped> getHuesped() {
        List<Huesped> listaHuesped;
        listaHuesped = huespedJPA.findHuespedEntities();

        return listaHuesped;
    }

    public List<Habitacion> getHabitacion() {
        List<Habitacion> listaHabitacion;
        listaHabitacion = habitacionJPA.findHabitacionEntities();
        
        return listaHabitacion;
    }

    public void borrarEmpleado(long id) {
        try {
            empleadoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Empleado buscarEmpleado(long id) {
        return empleadoJPA.findEmpleado(id);
    }

    public void modificarEmpleado(Empleado empleado) {
        try {
            empleadoJPA.edit(empleado);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Reserva> getReserva() {
        List<Reserva> listaReserva;
        listaReserva = reservaJPA.findReservaEntities();
        
        return listaReserva;
    }

    public void crearHabitacion(Habitacion habitacion) {
        try {
            habitacionJPA.create(habitacion);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Huesped buscarHuesped(long id) {
        return huespedJPA.findHuesped(id);
    }

    public void modificarHuesped(Huesped huesped) {
        try {
            huespedJPA.edit(huesped);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarHuesped(long id) {
        try {
            huespedJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Habitacion buscarHabitacion(int idHabitacion) {
        return habitacionJPA.findHabitacion(idHabitacion);
    }

    public void modificarHabitacion(Habitacion habitacion) {
        try {
            habitacionJPA.edit(habitacion);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarHabitacion(int idHabitacion) {
        try {
            habitacionJPA.destroy(idHabitacion);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
