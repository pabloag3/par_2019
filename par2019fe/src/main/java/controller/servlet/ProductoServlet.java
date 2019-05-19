package controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.ProductoModelo;
import producto.bean.Producto;


/**
 *
 * @author Porfirio Perez
 */
public class ProductoServlet extends HttpServlet {
    ProductoModelo mo = new ProductoModelo();
    ArrayList<Producto> productos = new ArrayList<Producto>();

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
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
        try {
            //processRequest(request, response);
            traerProductos(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        //processRequest(request, response);
    }

    private void traerProductos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception  {
        String uri = request.getServletPath();
        String url = "";
        if (uri.contains("/listar-productos")) {
            url = "/jsp/vistas/productos/listaProducto.jsp";
            productos = mo.traerProductos();
        }
        request.setAttribute("productos", productos);
        ServletContext sc = this.getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    private void traerProductosDescripcion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception  {
        String uri = request.getServletPath();
        String descri = request.getParameter("descripcion");
        String cat = request.getParameter("categoria");

        String url = "";
        if (uri.contains("/listar-producto")) {
            url = "/jsp/vistas/productos/listaProducto.jsp";
            productos = mo.traerProductos(descri, cat);
            request.setAttribute("productos", productos);
        }
        ServletContext sc = this.getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher(url);
        rd.forward(request, response);
    }
}
