package Servlets;

import Logica.Controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvReserva", urlPatterns = {"/SvReserva"})
public class SvReserva extends HttpServlet {

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
        
        //Trae los datos de una Reserva
        String fechaIngreso = request.getParameter("fechaIngreso");
        String fechaEgreso = request.getParameter("fechaEgreso");
        String estado = request.getParameter("estado");
        String habitacion = request.getParameter("habitacion");
        
        //Envia los datos de Reserva a la logica
        control.crearReserva(fechaIngreso, fechaEgreso, estado, habitacion);
        
        //Redirecciono hacia una pagina con mensaje de carga exitosa
        response.sendRedirect("carga_exitosa.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
