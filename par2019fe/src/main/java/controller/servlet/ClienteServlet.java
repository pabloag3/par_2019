package controller.servlet;

import cliente.bean.Cliente;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.ClienteModelo;
import producto.bean.Producto;

/**
 *
 * @author Porfirio Perez
 * @author Pablo Aguilar
 */
public class ClienteServlet extends HttpServlet {
    HttpSession sesion;
    Cliente cliente;
    ClienteModelo modelo = new ClienteModelo();
    List<Cliente> listaClientes = new ArrayList<>();
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
        try {
            String uri = request.getServletPath();
            String url;
            if(uri.contains("login")) {
                url = "/jsp/vistas/cliente/ClienteLogin.jsp";
                ServletContext sc = this.getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher(url);
                rd.forward(request, response);
            } else if(uri.contains("home")) {
                response.sendRedirect("/par2019fe/");
            } else if (uri.contains("/admin")) {
                if(uri.contains("agregar") || uri.contains("modificar")) {
                    irAgregarModificar(request, response);
                } else if(uri.contains("eliminar")) {
                    eliminarCliente(request, response);
                    administracionCliente(request, response);
                } else {
                    administracionCliente(request, response);
                }
            } else if(uri.contains("ingresar")) {
                cliente = traerCliente(request, response);
                if(cliente.getId() != 0) {
                    sesion = request.getSession(true);
                    //request.setAttribute("cliente", cliente);
                    sesion.setAttribute("cliente", cliente);
                    response.sendRedirect("/par2019fe/");
                } else {
                    url = "/jsp/vistas/cliente/ClienteLogin.jsp";
                    request.setAttribute("error", "error");
                    ServletContext sc = this.getServletContext();
                    RequestDispatcher rd = sc.getRequestDispatcher(url);
                    rd.forward(request, response);
                }
            } else if(uri.contains("registrar")) {
                url = "/jsp/vistas/cliente/ClienteRegistrar.jsp";
                ServletContext sc = this.getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher(url);
                rd.forward(request, response);
            } else if(uri.contains("cancelar")) {
                response.sendRedirect("/par2019fe/");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            String url;
            if(!"".equals(nombre) && !"".equals(apellido) && !"".equals(email) && !"".equals(contrasenha)) {
                Cliente nuevoCliente = new Cliente(nombre, apellido, email, loginName, contrasenha, 1);
                modelo.agregar(nuevoCliente);
                url = "/jsp/vistas/cliente/ClienteLogin.jsp";
                ServletContext sc = this.getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher(url);
                rd.forward(request, response);
            } else {
                response.sendRedirect("/par2019fe/");
            }
        } else if(uri.contains("admin/cargar")) {
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String email = request.getParameter("email");
            String loginName = nombre + apellido;
            String contrasenha = request.getParameter("contrasenha");
            int id = Integer.parseInt(request.getParameter("id"));
            Cliente nuevoCliente = new Cliente(nombre, apellido, email, loginName, contrasenha, 1);
            if(id == 0) {
                modelo.agregar(nuevoCliente);
                response.sendRedirect("/par2019fe/clientes/admin");
            } else if(id != 0) {
                nuevoCliente.setId(id);
                modelo.actualizarCliente(nuevoCliente);
                response.sendRedirect("/par2019fe/clientes/admin");
            } else {
                response.sendRedirect("/par2019fe/");
            }
        }
        
    }

    private Cliente traerCliente(HttpServletRequest request, HttpServletResponse response) {
        Cliente cli;
        String loginName = request.getParameter("usu");
        String contrasenha = request.getParameter("pass"); 
        cli = modelo.traerCliente(loginName, contrasenha);
        return cli;
    }

    private void administracionCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception  {
        Cliente cli = (Cliente) request.getSession().getAttribute("cliente");
        if(cli != null && cli.getTipoCliente() == 0) {
            String url = "/jsp/vistas/admin/ABMCliente.jsp";
            listaClientes = modelo.traerClientes();
            request.setAttribute("clientes", listaClientes);

            ServletContext sc = this.getServletContext();
            RequestDispatcher rd = sc.getRequestDispatcher(url);
            rd.forward(request, response);
        } else {
            response.sendRedirect("/par2019fe/");
        }
    }

    private void irAgregarModificar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cliente cli = (Cliente) request.getSession().getAttribute("cliente");
        if(cli != null && cli.getTipoCliente() == 0) {
            String url = "/jsp/vistas/admin/clienteAgregarModificar.jsp";
            String uri = request.getServletPath();
            if(uri.contains("modificar")){
                Integer cod = Integer.parseInt( request.getParameter("codigo"));
                Cliente clienteMod = new Cliente();
                if(listaClientes.isEmpty())
                    listaClientes = modelo.traerClientes();
                for(Cliente client : listaClientes) {
                    if(Objects.equals(client.getId(), cod))
                        clienteMod = client;
                }
                request.setAttribute("modClientes", clienteMod);
            }
            ServletContext sc = this.getServletContext();
            RequestDispatcher rd = sc.getRequestDispatcher(url);
            rd.forward(request, response);
        } else {
            response.sendRedirect("/par2019fe/");
        }
    }

    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response) {
        Integer cod = Integer.parseInt(request.getParameter("codigo"));
        modelo.borrarCliente(cod);
    }
}
