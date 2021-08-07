package Servlets;

import Logica.Controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {

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
        
        boolean verificacion = false;
        
        Controladora control = new Controladora();
        verificacion = control.comprobarIngreso(request.getParameter("usuario"), request.getParameter("contrasenia"));
        
        if (verificacion == true) {
            HttpSession miSesion = request.getSession(true);
            
            String user = request.getParameter("usuario");
            String password = request.getParameter("contrasenia");
            
            miSesion.setAttribute("usuario", user);
            miSesion.setAttribute("control", control);
            
            response.sendRedirect("index.jsp");
        }
        else {
            response.sendRedirect("login_error.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
