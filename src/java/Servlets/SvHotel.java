package Servlets;

import Logica.Controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvHotel", urlPatterns = {"/SvHotel"})
public class SvHotel extends HttpServlet {

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
         
        //Trae los datos de Huesped
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String fechaNacimiento = request.getParameter("fechaNacimiento"); 
        String profesion = request.getParameter("profesion");
       
        //Envio los datos de Huesped a la Logica
        control.crearHuesped(dni, nombre, apellido, direccion, telefono, fechaNacimiento, profesion);
        
        //Redirecciono hacia la lista de huesped
        response.sendRedirect("lista_huesped.jsp");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
