<%-- 
    Document   : carrito
    Created on : May 20, 2019, 3:36:45 PM
    Author     : tatoa
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="cliente.bean.Cliente"%>
<%@page import="carrito.Item"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="estilos.css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrito de compra</title>
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
                <p>Usuario: <%= usu %> </p>
                <form id="loginBtn" action="clientes/login" method="get">
                    <button hidden=<%= ocultar %> >Login</button>
                </form>
                <form id="loginRgtr" action="clientes/registrar" method="get">
                    <button hidden=<%= ocultar %>>Registrar</button>
                </form>
            </div>
        </section>
        <br/><br/><br/><br/>
        <br/>
        <hr>
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
		</tr>
            </tbody>
	</table>
            <div id="principalBtn">
                <form action="carrito/vaciar-carrito" method="get">
                    <button type="submit">Vaciar carrito</button>
                </form>
                <form action="comprar" method="get">
                    <dd><button type="submit">Comprar</button></dd>
                </form><form action="carrito/ver-facturas" method="get">
                    <dd><button type="submit">Ver facturas</button></dd>
                </form>
            </div> 
    </body>
</html>
