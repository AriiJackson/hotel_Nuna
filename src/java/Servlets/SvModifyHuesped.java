package Servlets;

import Logica.Controladora;
import static Logica.Controladora.deStringToDate;
import Logica.Huesped;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvModifyHuesped", urlPatterns = {"/SvModifyHuesped"})
public class SvModifyHuesped extends HttpServlet {

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
        String profesion = request.getParameter("profesion");
        
        Controladora control = new Controladora();
        Huesped huesped = control.buscarHuesped(id);
        
        //Setteo los valores a modificar
        huesped.setDni(dni);
        huesped.setNombre(nombre);
        huesped.setApellido(apellido);
        huesped.setDireccion(direccion);
        huesped.setTelefono(telefono);
        Date fecha = deStringToDate(fechaNacimiento);
        huesped.setFechaNacimiento(fecha);
        huesped.setProfesion(profesion);
        
        //Envio los valores a la logica para que lo envie a la persistencia
        control.modificarHuesped(huesped);
        
        //Actualizo al huesped
        request.getSession().setAttribute("listaHuespedes", control.getListaHuespedes());
        response.sendRedirect("lista_huesped.jsp");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        //Traigo el ID por el cual voy a modificar
        long id = Long.parseLong(request.getParameter("id"));
        
        Controladora control = new Controladora();
        
        //Envio el ID a la logica para que en la persistencia busque al Huesped
        Huesped huesped =  control.buscarHuesped(id);
        
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("huesped", huesped);
        
        //Enviamos a la pagina para modificar los datos
        response.sendRedirect("modificar_huesped.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
