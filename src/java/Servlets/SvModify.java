package Servlets;

import Logica.Controladora;
import static Logica.Controladora.deStringToDate;
import Logica.Empleado;
import Logica.Usuario;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvModify", urlPatterns = {"/SvModify"})
public class SvModify extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        //Traigo los datos a modificar
        long id = Long.parseLong(request.getParameter("id"));
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String fechaNacimiento = request.getParameter("fechaNacimiento"); 
        String cargo = request.getParameter("cargo");
        String user = request.getParameter("usuario");
        
        Controladora control = new Controladora();
        Empleado empleado = control.buscarEmpleado(id);
        
        //Setteo los valores a modificar
        empleado.setDni(dni);
        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setDireccion(direccion);
        empleado.setTelefono(telefono);
        Date fecha = deStringToDate(fechaNacimiento);
        empleado.setFechaNacimiento(fecha);
        empleado.setCargo(cargo);
        Usuario usuario = new Usuario();
        usuario.setNombreUser(user);
        empleado.setUser(usuario);
        
        //Envio los valores a la logica para que lo envie a la persistencia
        control.modificarEmpleado(empleado);
        
        //Actualizo al empleado
        request.getSession().setAttribute("listaEmpleados", control.getListaEmpleados());
        response.sendRedirect("empleados.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        //Traigo el ID por el cual voy a modificar
        long id = Long.parseLong(request.getParameter("id"));
        
        Controladora control = new Controladora();
        
        //Envio el ID a la logica para que en la persistencia busque al Empleado
        Empleado empleado =  control.buscarEmpleado(id);
        
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("empleado", empleado);
        
        //Enviamos a la pagina para modificar los datos
        response.sendRedirect("modificar_datos.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
