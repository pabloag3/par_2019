package controller.servlet;

import carrito.Item;
import cliente.bean.Cliente;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.ProductoModelo;
import modelos.TransaccionModelo;
import transaccion.bean.Transaccion;
import transaccionDetalle.bean.TransaccionDetalle;

/**
 *
 * @author tatoa
 */
public class CarritoServlet extends HttpServlet {
    
    TransaccionModelo mo = new TransaccionModelo();

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
            } else if (aux.contains("vaciar-carrito")) {
                doGetLimpiarCarrito(request, response);
            } else if (aux.contains("comprar")) {
                doGetComprar(request, response);
            } else if (aux.contains("ver-compras")) {
                doGetVerFacturas(request, response);
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
        String aux = request.getPathInfo();
        String url = "";
        if (aux.contains("confirmar-compra")) {
            doPostComprar(request, response);
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

    private void doGetAgregar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ProductoModelo mo = new ProductoModelo();
        HttpSession session = request.getSession();
        if (session.getAttribute("carrito") == null) { // si no hay un carrito en la sesion, instancia uno nuevo
            List<Item> carrito = new ArrayList<>();
            carrito.add(new Item(mo.traerProducto(Integer.parseInt(request.getParameter("codigo"))), Integer.parseInt(request.getParameter("cantidad"))));
            session.setAttribute("carrito", carrito);
        } else {
            List<Item> carrito = (List<Item>) session.getAttribute("carrito");
            String aux = request.getParameter("codigo");
            int index = siExiste(aux, carrito);
            if (index == -1) { // si no existe el producto en la lista, inserta el producto con la cantidad ingresada
                carrito.add(new Item(mo.traerProducto(Integer.parseInt(request.getParameter("codigo"))),
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
        int index = siExiste(request.getParameter("codigo"), carrito);
        carrito.remove(index);
        session.setAttribute("carrito", carrito);
        response.sendRedirect("/par2019fe/carrito/listar-carrito");
    }
    
    private int siExiste(String id, List<Item> carrito) {
        for (int i = 0; i < carrito.size(); i++) {
            if (carrito.get(i).getProducto().getId() == Integer.parseInt(id)) {
                    return i;
            }
        }
        return -1;
    }
    
    private void doGetLimpiarCarrito(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        List<Item> carrito = new ArrayList<>();
        session.setAttribute("carrito", carrito);
        response.sendRedirect("/par2019fe/carrito/listar-carrito");
    }

    private void doGetComprar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        if (session.getAttribute("cliente") == null) {
            response.sendRedirect("/par2019fe/clientes/login");
        } else {
            if (session.getAttribute("carrito") == null) {
                response.sendRedirect("/par2019fe/carrito/listar-carrito");
            } else {
                String url = "/jsp/vistas/cliente/confirmarCompraProductos.jsp";
                ServletContext sc = this.getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher(url);
                rd.forward(request, response);
            }
        }
    }

    private void doGetVerFacturas(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession sesion = request.getSession(); 
        if (sesion.getAttribute("cliente") == null){
            response.sendRedirect("/par2019fe/clientes/login");
        } else {
            String url = "/jsp/vistas/cliente/listarCompras.jsp";
            ServletContext sc = this.getServletContext();
            RequestDispatcher rd = sc.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }

    private void doPostComprar(HttpServletRequest request, HttpServletResponse response) {
        HttpSession sesion = request.getSession(); 
        List<Item> carrito = (List<Item>) sesion.getAttribute("carrito");
        Cliente cli =(Cliente) sesion.getAttribute("cliente");
        int usu = cli.getId();
        
        // insercion de la transaccion
        Transaccion trans = new Transaccion();
        Calendar fecha = new GregorianCalendar();
        trans.setFecha(fecha);
        trans.setIdCliente(usu);
        trans.setTotal((Long)sesion.getAttribute("total"));
        trans.setDireccionEnvio(request.getParameter("direccion"));
        trans.setIdMedioPago(Integer.valueOf(request.getParameter("medio_pago")));
        if (Integer.valueOf(request.getParameter("medio_pago")) == 0) {
            trans.setNroTarjeta(Long.valueOf(0));
        } else {
            trans.setNroTarjeta(Long.valueOf(request.getParameter("nro_tarjeta")));
        }
        trans.setEstado("E"); 
        mo.agregarTransaccion(trans);
        
        TransaccionDetalle td = new TransaccionDetalle();
        //insercion de detalles de transaccions
        for (int i = 0; i < carrito.size(); i++) {
            td.setIdCabecera(i);
            td.setItem(i);
            td.setIdProducto(carrito.get(i).getProducto().getId());
            td.setCantidad(carrito.get(i).getCantidad());
            td.setPrecio(carrito.get(i).getProducto().getPrecioUnit());
            td.setSubTotal(carrito.get(i).getProducto().getPrecioUnit() * carrito.get(i).getCantidad());
            mo.agregarTransaccionDetalle(td);
        }
    }

}
