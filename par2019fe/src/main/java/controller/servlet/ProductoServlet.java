/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author Perez
 */
public class ProductoServlet extends HttpServlet {
    //private final ProductoServiceImpl productoService = new ProductoServiceImpl(new JdbcProductoRepository());
    //private final CategoriaServiceImpl categoriaService = new CategoriaServiceImpl(new JdbcCategoriaRepository());
    ArrayList<Producto> productos;

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
        if (uri.contains("/productos")){
            url = "/jsp/vistas/productos/listaProducto.jsp";
            ProductoModelo mo = new ProductoModelo();
            //productos = mo.traerProducto( (Integer) 1);
            Producto producto = mo.traerProducto( (Integer) 1);

            System.out.println("controller.servlet.ProductoServlet.traerProductos()" + producto.toString());
        }
            

        ServletContext sc = this.getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher(url);
        rd.forward(request, response);
        
        /*        
//ArrayList<Producto> productos = (ArrayList) productoService.getAll();
        ArrayList<Producto> productos = new ArrayList<>();
        Producto prod1 = new Producto((Integer) 1, "jabon", 1, Long.valueOf( 5000), Long.valueOf(10));
        productos.add(prod1);
        String vista =
        "<!DOCTYPE html>" +
        "<html>" +
	"<head>" +
	"	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">" +
	"	<title>Productos</title>" +
	"</head>" +
	"<body>" +
                "<h3>Servlet ProductoServlet at " + request.getContextPath() + "</h1>"+
                "<h3>Servlet ProductoServlet at " + request.getServletPath() + "</h1>"+
                "<div>" +
                    "<label>Buscar por Producto</label>" +
                    "<input type=\"text\" placeholder=\"Nombre Producto\"/>" +
                    "<br/>" +
                    "<br/>" +
                    "<label>Buscar por Categoria</label>" +
                    "<input type=\"text\" placeholder=\"Categoria\"/>" +
                "</div>" +
	"	<h1>Lista de Productos</h1>" +
	"	<table >" +
	"		<thead border=\"1\">" +
	"                   <th>Codigo</th>" +
	"                   <th>Nombre</th>" +
	"                   <th>Categoria</th>" +
	"                   <th>Precio</th>" +
	"                   <th>Cantidad</th>" +
	"		</thead>" +
	"		<tbody>    ";          
        for(Producto prod : productos) {
            //Categoria cat = (Categoria) categoriaService.findById(prod.getIdCategoria());
            vista +=
            "               <tr>" +
            "                   <td>" + prod.getId() + "</td>" +
            "			<td>" + prod.getDescripcion() + "</td>" +
            "			<td>" + prod.getIdCategoria() + "</td>" +
            "			<td>" + prod.getPrecioUnit() + "</td>" +
            "			<td>" + prod.getCantidad() + "</td>" +
            "                </tr>"; 
        }
        vista += "      </tbody>" +
	"           </table>" +
	"       </body>   " +
        "</html>";
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(vista);
        }
*/    }

}
