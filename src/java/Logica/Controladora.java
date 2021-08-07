package Logica;

import Persistencia.ControladoraPersistencia;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Controladora {

    ControladoraPersistencia controlPersistencia = new ControladoraPersistencia();
    private List<Usuario> listaUsuarios;

    //Convertir String a Date
    public static synchronized java.util.Date deStringToDate(String fecha) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy"); //formato guión
        Date fechaEnviar = null;
        try {
            fechaEnviar = df.parse(fecha);
            return fechaEnviar;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    //Convertir Date a String
    public static String DateAString(Date fecha) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        return formatoFecha.format(fecha);
    }

    public boolean comprobarIngreso(String usuario, String contrasenia) {
        boolean verificacion = false;

        listaUsuarios = controlPersistencia.getUsuario();

        for (Usuario user : listaUsuarios) {

            if (user.getNombreUser().equals(usuario) && user.getPassword().equals(contrasenia)) {
                verificacion = true;
                return verificacion;
            }

        }

        return verificacion;
    }

    public void crearEmpleado(String dni, String nombre, String apellido, String direccion, String telefono, String fechaNacimiento, String cargo, String user, String password) {
        Empleado empleado = new Empleado();
        Usuario usuario = new Usuario();

        usuario.setNombreUser(user);
        usuario.setPassword(password);

        empleado.setDni(dni);
        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setDireccion(direccion);
        empleado.setTelefono(telefono);
        Date fecha = deStringToDate(fechaNacimiento);
        empleado.setFechaNacimiento(fecha);
        empleado.setCargo(cargo);

        empleado.setUser(usuario);

        controlPersistencia.crearEmpleado(empleado);

    }

    public void crearHuesped(String dni, String nombre, String apellido, String direccion, String telefono, String fechaNacimiento, String profesion) {

        Huesped huesped = new Huesped();

        huesped.setDni(dni);
        huesped.setNombre(nombre);
        huesped.setApellido(apellido);
        huesped.setDireccion(direccion);
        huesped.setTelefono(telefono);
        Date fecha = deStringToDate(fechaNacimiento);
        huesped.setFechaNacimiento(fecha);
        huesped.setProfesion(profesion);

        controlPersistencia.crearHuesped(huesped);
    }

    public void crearReserva(String fechaIngreso, String fechaEgreso, String estado, String habitacion) {

        Reserva reserva = new Reserva();

        Date fechaIn = deStringToDate(fechaIngreso);
        Date fechaOut = deStringToDate(fechaEgreso);
        boolean estadoHabitacion = Boolean.parseBoolean(estado);

        reserva.setFechaIngreso(fechaIn);
        reserva.setFechaSalida(fechaOut);
        reserva.setEstado(estadoHabitacion);

        controlPersistencia.crearReserva(reserva);

    }

    public List<Empleado> getListaEmpleados() {
        return controlPersistencia.getEmpleado();
    }

    public List<Huesped> getListaHuespedes() {
        return controlPersistencia.getHuesped();
    }

    public List<Habitacion> getListaHabitacion() {
        return controlPersistencia.getHabitacion();
    }

    public List<Reserva> getListaReserva() {
        return controlPersistencia.getReserva();
    }

    public void borrarEmpleado(long id) {
        controlPersistencia.borrarEmpleado(id);
    }

    public Empleado buscarEmpleado(long id) {
        return controlPersistencia.buscarEmpleado(id);
    }

    public void modificarEmpleado(Empleado empleado) {
        controlPersistencia.modificarEmpleado(empleado);
    }

    public void crearHabitacion(String idHabitacion, String piso, String tematica, String tipoHabitacion, String precio) {
        Habitacion habitacion = new Habitacion();

        habitacion.setIdHabitacion(Integer.parseInt(idHabitacion));
        habitacion.setPiso(Integer.parseInt(piso));
        habitacion.setTematica(tematica);
        String tipo;

        if ("1".equals(tipoHabitacion)) {
            tipo = "Single";
        } else if ("2".equals(tipoHabitacion)) {
            tipo = "Doble";
        } else if ("3".equals(tipoHabitacion)) {
            tipo = "Tiple";
        } else {
            tipo = "Multiple";
        }

        habitacion.setTipoHabitacion(tipo);
        habitacion.setPrecio(Float.parseFloat(precio));

        controlPersistencia.crearHabitacion(habitacion);
    }

    public Huesped buscarHuesped(long id) {
        return controlPersistencia.buscarHuesped(id);
    }

    public void modificarHuesped(Huesped huesped) {
        controlPersistencia.modificarHuesped(huesped);
    }

    public void borrarHuesped(long id) {
        controlPersistencia.borrarHuesped(id);
    }

    public Habitacion buscarHabitacion(int idHabitacion) {
        return controlPersistencia.buscarHabitacion(idHabitacion);
    }

    public void modificarHabitacion(Habitacion habitacion) {
        controlPersistencia.modificarHabitacion(habitacion);
    }

    public void borrarHabitacion(int idHabitacion) {
        controlPersistencia.borrarHabitacion(idHabitacion);
    }

}
