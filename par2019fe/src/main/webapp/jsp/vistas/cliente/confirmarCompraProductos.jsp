<%-- 
    Document   : confirmarCompraProductos
    Created on : Jun 2, 2019, 5:36:43 PM
    Author     : tatoa
--%>

<%@page import="cliente.bean.Cliente"%>
<%@page import="carrito.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String usu = "";
            boolean ocultar = false;
            HttpSession sesion = request.getSession();
            if (sesion.getAttribute("cliente") != null){
                ocultar = true;
                Cliente cli =(Cliente) sesion.getAttribute("cliente");
                usu = cli.getLoginName();
            }
        %>
        <section id="superior">
            <div id="titulo">
                <dd>
                    <h1>Inicio Parzon!</h1>
                </dd>
            </div>
            <div id="login">
                <p>Usuario: <%=usu%> </p>
                <form id="loginBtn" action="clientes/login" method="get">
                    <button>Login</button>
                </form>
                <form id="loginRgtr" action="clientes/registrar" method="get">
                    <button>Registrar</button>
                </form>
            </div>
        </section>
        <table cellpadding="2" cellspacing="2" border="1">
            <thead border="1">
                <th>Opcion</th>
                <th>Codigo</th>
                <th>Nombre</th>
                <th>Precio</th>
                <th>Cantidad</th>
            </thead>
            <tbody>
		<c:set var="total" value="0"></c:set>
                <% 
                    List<Item> lista = (List<Item>)sesion.getAttribute("carrito");
                    if (lista == null) {
                        lista = new ArrayList<>();
                    }
                    Long total = Long.valueOf(0);
                %>
                <% 
                    for(Item item: lista) {
                        total += item.getProducto().getPrecioUnit() * item.getCantidad();
                %>
                <tr>
                    <td> 
                        <a href="${pageContext.request.contextPath}/carrito/eliminar?codigo=<%= item.getProducto().getId() %>">Eliminar</a>
                    </td>
                    <td> <%= item.getProducto().getId()%> </td>
                    <td> <%= item.getProducto().getDescripcion() %> </td>
                    <td> <%= item.getProducto().getPrecioUnit() %> </td>
                    <td> <%= item.getCantidad() %> </td>
                </tr>
                <% } %>
		<tr>
                    <td colspan="3" align="right">Total</td>
                    <td><%= total %> </td>
                    <%
                        session.setAttribute("total", total);
                    %>
		</tr>
            </tbody>
	</table>
                <form name="confirmarCompra" action="carrito/confirmar-compra" method="post">
                    <div id="direccion" >
                        <label>Direccion: </label>
                        <input type="text" placeholder="Direccion" required="true" name="direccion">
                    </div>
                    <div id="nro_tarjeta">
                        <label>Numero de tarjeta </label>
                        <input type="number" placeholder="Numero de tarjeta" name="nro_tarjeta">
                    </div>
                    <div>
                        <input type="radio" name="medio_pago" value="0" required="true" checked="true">Efectivo<br>
                    </div>
                    <div>
                        <input type="radio" name="medio_pago" value="1" required="true">Tarjeta de credito<br>
                    </div>
                    <input type = "submit" value = "Confirmar compra" />
                </form>
    </body>
</html>
