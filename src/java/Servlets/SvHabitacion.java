package Servlets;

import Logica.Controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvHabitacion", urlPatterns = {"/SvHabitacion"})
public class SvHabitacion extends HttpServlet {

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

        Controladora control = new Controladora();

        String idHabitacion = request.getParameter("idHabitacion");
        String piso = request.getParameter("piso");
        String tematica = request.getParameter("tematica");
        String tipoHabitacion = request.getParameter("tipoHabitacion");
        String precio = request.getParameter("precio");
        
        control.crearHabitacion(idHabitacion, piso, tematica, tipoHabitacion, precio);
        response.sendRedirect("lista_habitaciones.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
