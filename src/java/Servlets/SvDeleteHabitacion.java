package Servlets;

import Logica.Controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvDeleteHabitacion", urlPatterns = {"/SvDeleteHabitacion"})
public class SvDeleteHabitacion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        //Traigo el ID por el cual voy a borrar
        int idHabitacion = Integer.parseInt(request.getParameter("idHabitacion"));
        
        Controladora control = new Controladora();
        
        //Envio esa ID a la logica para poder enviarla a la persistencia
        control.borrarHabitacion(idHabitacion);
        
        //Actualizo la lista de Empleado
        request.getSession().setAttribute("listaHabitaciones", control.getListaHabitacion());
        response.sendRedirect("lista_habitacion.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
