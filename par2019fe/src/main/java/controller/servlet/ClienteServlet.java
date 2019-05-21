package controller.servlet;

import cliente.bean.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.ClienteModelo;

/**
 *
 * @author Perez
 */
public class ClienteServlet extends HttpServlet {
    Cliente cliente;
    ClienteModelo modelo = new ClienteModelo();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getServletPath();
        String url = "";
        if(uri.contains("login")) {
            
            url = "/jsp/vistas/cliente/ClienteLogin.jsp";
        } else if(uri.contains("registrar"))
            url = "/jsp/vistas/cliente/ClienteRegistrar.jsp";
        else if(uri.contains("ingresar")) {
            cliente = traerCliente(request, response);
            if(cliente.getId() != 0) {
                //response.sendRedirect("jsp/home.jsp");
                request.setAttribute("cliente", cliente);
                url = "/jsp/home.jsp";
            } else
                url = "/jsp/vistas/cliente/ClienteLogin.jsp";
        }
        ServletContext sc = this.getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getServletPath();
        if (uri.contains("agregar")) {
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String email = request.getParameter("email");
            String loginName = nombre + apellido;
            String contrasenha = request.getParameter("contrasenha");
            Cliente nuevoCliente = new Cliente(nombre, apellido, email, loginName, contrasenha, 0);
            modelo.agregar(nuevoCliente);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private Cliente traerCliente(HttpServletRequest request, HttpServletResponse response) {
        Cliente cli;
        String loginName = request.getParameter("usu");
        String contrasenha = request.getParameter("pass"); 
        cli = modelo.traerCliente(loginName, contrasenha);
        return cli;
    }
}
