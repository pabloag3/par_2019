<%-- 
    Document   : carrito
    Created on : May 20, 2019, 3:36:45 PM
    Author     : tatoa
--%>

<%@page import="carrito.Item"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrito de compra</title>
    </head>
    <body>
        <table cellpadding="2" cellspacing="2" border="1">
            <thead border="1">
                <th>Opcion</th>
                <th>Nombre</th>
                <th>Precio</th>
                <th>Cantidad</th>
            </thead>
            <tbody>
		<c:set var="total" value="0"></c:set>
                <% 
                    HttpSession sesion = request.getSession();
                    List<Item> lista = (List<Item>)sesion.getAttribute("carrito");
                    Long total = Long.valueOf(0);
                %>
                <% 
                    for(Item item: lista) {
                        total += item.getProducto().getPrecioUnit() * item.getCantidad();
                %>
                <tr>
                    <td> 
                        <form action="carrito/eliminar/{=<%= item.getProducto().getId() %>}" method="get"> 
                            <button>Eliminar</button>
                        </form>
                    </td>
                    <td> <%= item.getProducto().getDescripcion() %> </td>
                    <td> <%= item.getProducto().getPrecioUnit() %> </td>
                    <td> <%= item.getCantidad() %> </td>
                </tr>
                <% } %>
		<tr>
                    <td colspan="3" align="right">Total</td>
                    <td><%= out.write(Long.toString(total)) %> </td>
		</tr>
            </tbody>
	</table>
    </body>
</html>
