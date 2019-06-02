/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet;

import carrito.Item;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.ProductoModelo;
import producto.bean.Producto;

/**
 *
 * @author tatoa
 */
public class CarritoServlet extends HttpServlet {

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
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CarritoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CarritoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String aux = request.getPathInfo();
            String url = "";
            if (aux.contains("listar-carrito")) {
                url = "/jsp/vistas/productos/carrito.jsp";
                ServletContext sc = this.getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher(url);
                rd.forward(request, response);
            } else if (aux.contains("agregar")) {
                doGetAgregar(request, response);
            } else if (aux.contains("eliminar")) {
                doGetRemove(request, response);
            }
        } catch (Exception e) {
            System.out.println(e);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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

    private void doGetDesplegarCarrito(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/vistas/productos/carrito.jsp").forward(request, response);
    }

    private void doGetAgregar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ProductoModelo mo = new ProductoModelo();
        HttpSession session = request.getSession();
        if (session.getAttribute("carrito") == null) { // si no hay un carrito en la sesion, instancia uno nuevo
            List<Item> carrito = new ArrayList<>();
            carrito.add(new Item(mo.traerProducto(Integer.parseInt(request.getParameter("codigo"))), Integer.parseInt(request.getParameter("cantidad"))));
            session.setAttribute("carrito", carrito);
        } else {
            List<Item> carrito = (List<Item>) session.getAttribute("carrito");
            int index = siExiste(request.getParameter("id"), carrito);
            if (index == -1) { // si no existe el producto en la lista, inserta el producto con la cantidad ingresada
                carrito.add(new Item(mo.traerProducto(Integer.parseInt(request.getParameter("id"))),
                        Integer.parseInt(request.getParameter("cantidad"))));
            } else { // si existe el producto, suma la cantidad ingresada a la cantidad actual del producto
                int quantity = carrito.get(index).getCantidad() + Integer.parseInt(request.getParameter("cantidad"));
                carrito.get(index).setCantidad(quantity);
            }
            session.setAttribute("carrito", carrito);
        }
        response.sendRedirect("/par2019fe/carrito/listar-carrito");
    }

    protected void doGetRemove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Item> carrito = (List<Item>) session.getAttribute("carrito");
        int index = siExiste(request.getParameter("id"), carrito);
        carrito.remove(index);
        session.setAttribute("carrito", carrito);
        response.sendRedirect("/par2019fe/carrito/listar-carrito");
    }
    
    private int siExiste(String id, List<Item> carrito) {
        for (int i = 0; i < carrito.size(); i++) {
            if (carrito.get(i).getProducto().getId().equals(id)) {
                    return i;
            }
        }
        return -1;
    }

    private void doGetListar(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
