package Servlets;

import Logica.Controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvRegister", urlPatterns = {"/SvRegister"})
public class SvRegister extends HttpServlet {

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
        
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String fechaNacimiento = request.getParameter("fechaNacimiento"); 
        String cargo = request.getParameter("cargo");
        
        String user = request.getParameter("usuario");
        String password = request.getParameter("contrasenia");
        
        Controladora control = new Controladora();
        control.crearEmpleado(dni, nombre, apellido, direccion, telefono, fechaNacimiento, cargo, user, password);
        
        response.sendRedirect("login.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
