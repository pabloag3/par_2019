<%-- 
    Document   : ABMCliente
    Created on : 02-jun-2019, 21:33:31
    Author     : Pablo Aguilar
    Author     : Porfirio Perez
--%>

<%@page import="cliente.bean.Cliente"%>
<%@page import="categoria.bean.Categoria"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.fasterxml.jackson.databind.JsonNode"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="com.fasterxml.jackson.core.type.TypeReference"%>
<%@page import="java.util.List"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.lang.Object"%>
<%@page import="controller.servlet.ProductoServlet"%>
<%@page import="modelos.ProductoModelo"%>
<%@page import="producto.bean.Producto"%>
<%@page import="java.util.ArrayList"%>
<link rel="stylesheet" type="text/css" href="estilos.css"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administracion de Productos.</title>
    </head>
    <body>
        <%
            boolean ocultar = false;
            String usu = "";
            HttpSession sesion = request.getSession();
            if(sesion.getAttribute("cliente") != null){
                ocultar = true;
                Cliente cli =(Cliente) sesion.getAttribute("cliente");
                usu = cli.getLoginName();
            }
            //ProductoModelo mo = new ProductoModelo();
            List<Cliente> clientes;
            clientes = (List<Cliente>) request.getAttribute("clientes");
        %>
        <section id="superior">
            <div id="titulo">
                <dd>
                    <a class="inicio" href="home"><h1>Inicio Parzon!</h1></a>
                </dd>
            </div>
            <div id="login">
                <p>Usuario:<%=usu%></p>
                <form id="loginBtn" action="login" method="get">
                    <button hidden= <%= ocultar %> >Login</button>
                </form>
                <form id="loginRgtr" action="registrar" method="get">
                    <button hidden= <%= ocultar %> >Registrar</button>
                </form>
                <form id="formularioCarrito" action="/productos" method="get">
                    <dd><button type="submit">Ir a Carrito</button></dd>
                </form>
            </div>
        </section>
        <br/><br/><br/><br/>
        <br/>
        <hr>
        <section id="medio">
            <br/>
            <h2>Administracion de Clientes.</h2>
            <form action="${pageContext.request.contextPath}/productos/admin/agregar" method="get">
                <button type="submit">Nuevo Administrador</button>
            </form>
            <table>
                <thead border=1>
                   <th>Codigo</th>
                   <th>Nombre</th>
                   <th>Apellido</th>
                   <th>Email</th>
                   <th>Login Nombre</th>
                   <th>Tipo Cliente</th>
                   <th>Modificar Cliente</th>
                   <th>Eliminar Cliente</th>
                </thead>
                <tbody>
                    <%
                        for(Cliente clien: clientes) {
                    %>
                    <tr>
                        <td> <%= clien.getId() %> </td>
                        <td> <%= clien.getNombre() %> </td>
                        <td> <%= clien.getApellido() %> </td>
                        <td> <%= clien.getEmail() %> </td>
                        <td> <%= clien.getLoginName() %> </td>
                        <td> <%= clien.getTipoCliente()%> </td>
                        <td> 
                            <a href="${pageContext.request.contextPath}/clientes/admin/modificar?codigo=<%= clien.getId()%>">Modificar</a>
                        </td>
                        <td>
                            <a href="admin/eliminar?codigo=<%= clien.getId()%>">Eliminar</a>
                        </td>
                     </tr>
                    <% } %>
                </tbody>
            </table>
        </section>
    </body>
</html>
