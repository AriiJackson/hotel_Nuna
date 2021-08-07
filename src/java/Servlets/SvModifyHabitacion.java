package Servlets;

import Logica.Controladora;
import Logica.Habitacion;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvModifyHabitacion", urlPatterns = {"/SvModifyHabitacion"})
public class SvModifyHabitacion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        Controladora control = new Controladora();

        //Traigo los datos a modificar
        int idHabitacion = Integer.parseInt(request.getParameter("idHabitacion"));
        String piso = request.getParameter("piso");
        String tematica = request.getParameter("tematica");
        String tipoHabitacion = request.getParameter("tipoHabitacion");
        String precio = request.getParameter("precio");
        
        Habitacion habitacion = control.buscarHabitacion(idHabitacion);
        
        //Setteo los valores a modificar
        habitacion.setIdHabitacion(idHabitacion);
        habitacion.setPiso(Integer.parseInt(piso));
        habitacion.setTematica(tematica);
        habitacion.setTipoHabitacion(tipoHabitacion);
        habitacion.setPrecio(Float.parseFloat(precio));
        
        //Envio los valores a la logica para que lo envie a la persistencia
        control.modificarHabitacion(habitacion);
        
        //Actualizo la habitacion
        request.getSession().setAttribute("listaHabitaciones", control.getListaHabitacion());
        response.sendRedirect("lista_habitacion.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        //Traigo el ID por el cual voy a modificar
        int idHabitacion = Integer.parseInt(request.getParameter("idHabitacion"));
        
        Controladora control = new Controladora();
        
        //Envio el ID a la logica para que en la persistencia busque la habitacion
        Habitacion habitacion =  control.buscarHabitacion(idHabitacion);
        
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("habitacion", habitacion);
        
        //Enviamos a la pagina para modificar los datos
        response.sendRedirect("modificar_habitacion.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
