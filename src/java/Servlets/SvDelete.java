package Servlets;

import Logica.Controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvDelete", urlPatterns = {"/SvDelete"})
public class SvDelete extends HttpServlet {

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
        long id = Long.parseLong(request.getParameter("id"));
        
        Controladora control = new Controladora();
        
        //Envio esa ID a la logica para poder enviarla a la persistencia
        control.borrarEmpleado(id);
        
        //Actualizo la lista de Empleado
        request.getSession().setAttribute("listaEmpleados", control.getListaEmpleados());
        response.sendRedirect("empleados.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
