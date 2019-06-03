package controller.servlet;

import categoria.bean.Categoria;
import cliente.bean.Cliente;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    List<Producto> productos = new ArrayList<Producto>();
    List<Categoria> categorias = new ArrayList<Categoria>();
    int contar = 0;
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
            String uri = request.getServletPath();
            if (uri.contains("/login")) {
                response.sendRedirect("/par2019fe/clientes/login");
            } else if (uri.contains("/registrar")) {
                response.sendRedirect("/par2019fe/clientes/registrar");
            } else if (uri.contains("/admin")) {
                if(uri.contains("busqueda")) {
                    traerProductosDescripcion(request, response);
                } else if(uri.contains("agregar") || uri.contains("modificar")) {
                    irAgregarModificar(request, response);
                } else if(uri.contains("eliminar")) {
                    eliminarProducto(request, response);
                    administracionProducto(request, response);
                } else {
                    administracionProducto(request, response);
                    traerProductos(request, response);
                }
            } else if (uri.contains("/listar-productos") || uri.contains("/productos")) {
                traerProductos(request, response);
            }
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
        try {
            Producto prod = new Producto();
            Integer cod = Integer.parseInt( request.getParameter("id_producto"));
            prod.setCantidad( Long.parseLong(request.getParameter("cantidad")));
            prod.setDescripcion(request.getParameter("descripcion"));
            prod.setPrecioUnit(Long.parseLong(request.getParameter("precio")));
            prod.setIdCategoria(Integer.parseInt(request.getParameter("categoria")));
            if(cod == 0) {
                mo.agregar(prod);
            } else {
                prod.setId(cod);
                mo.actualizarProducto(prod);
            }
            administracionProducto(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void traerProductos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception  {
        String uri = request.getServletPath();
        String url = "";
        if (uri.contains("/listar-productos")) {
            url = "/jsp/vistas/productos/listaProducto.jsp";
            productos = mo.traerProductos();
            categorias = mo.traerCategorias();
        } else if(uri.contains("/productos")) {
            traerProductosDescripcion(request, response);
        }
        request.setAttribute("productos", productos);
        request.setAttribute("categorias", categorias);
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
        } else if(uri.contains("busqueda")) {
            url = "/jsp/vistas/admin/ABMProducto.jsp";
            productos = mo.traerProductos(descri, cat);
            categorias = mo.traerCategorias();
            if(++contar >=2)
                response.sendRedirect("/par2019fe/productos/admin");
        } else if(uri.contains("/productos")) {
            productos = mo.traerProductos(descri, cat);
            categorias = mo.traerCategorias();
            url = "/jsp/vistas/productos/listaProducto.jsp";
        }
        request.setAttribute("productos", productos);
        request.setAttribute("categorias", categorias);
        ServletContext sc = this.getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    private void administracionProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception  {
        Cliente cli = (Cliente) request.getSession().getAttribute("cliente");
        if(cli != null && cli.getTipoCliente() == 0) {
            String url = "/jsp/vistas/admin/ABMProducto.jsp";
            productos = mo.traerProductos();
            categorias = mo.traerCategorias();
            request.setAttribute("productos", productos);
            request.setAttribute("categorias", categorias);

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
            String url = "/jsp/vistas/admin/productoAgregarModificar.jsp";
            String uri = request.getServletPath();
            if(uri.contains("modificar")){
                Integer cod = Integer.parseInt( request.getParameter("codigo"));
                Producto p = new Producto();
                if(productos.isEmpty())
                    productos = mo.traerProductos();
                for(Producto prod : productos) {
                    if(Objects.equals(prod.getId(), cod))
                        p = prod;
                }
                request.setAttribute("modProducto", p);
            }
            if(request.getAttribute("categorias") == null) {
                request.setAttribute("categorias", categorias);
                categorias = mo.traerCategorias();
                request.setAttribute("categorias", categorias);
            }
            ServletContext sc = this.getServletContext();
            RequestDispatcher rd = sc.getRequestDispatcher(url);
            rd.forward(request, response);
        } else {
            response.sendRedirect("/par2019fe/");
        }
    }

    private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) {
        Integer cod = Integer.parseInt(request.getParameter("codigo"));
        mo.borrarProducto(cod);
    }
}
