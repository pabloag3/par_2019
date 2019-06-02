<%-- 
    Document   : listaProducto
    Created on : 09/05/2019, 09:15:23 PM
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
            List<Producto> productos;
            List<Categoria> categorias;
            productos = (List<Producto>) request.getAttribute("productos");
            categorias = (List<Categoria>) request.getAttribute("categorias");
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
            <h2>Administracion de Productos.</h2>
            <form action="admin/busqueda" method="get">
                <input name="descripcion" class="buscadorProducto" placeholder="Buscar Productos">
                <input name="categoria" class="buscadorCategoria" placeholder="Buscar Categoria">
                <br/>
                <br/>
                <dd>
                    <button type="submit">Buscar</button>
                </dd>
                <br/>
            </form>
            <form action="${pageContext.request.contextPath}/productos/admin/agregar" method="get">
                <button type="submit">Nuevo Producto</button>
            </form>
            <table>
                <thead border=1>
                   <th>Codigo</th>
                   <th>Nombre</th>
                   <th>Categoria</th>
                   <th>Precio</th>
                   <th>Cantidad</th>
                   <th>Modificar Producto</th>
                   <th>Eliminar Producto</th>
                </thead>
                <tbody>
                    <%
                        for(Producto prod: productos) {
                            String catego = categorias.get(prod.getIdCategoria()).getDescripcion();
                    %>
                    <tr>
                        <td> <%= prod.getId() %> </td>
                        <td> <%= prod.getDescripcion() %> </td>
                        <td> <%= catego %> </td>
                        <td> <%= prod.getPrecioUnit() %> </td>
                        <td> <%= prod.getCantidad() %> </td>
                        <td> 
                            <a href="${pageContext.request.contextPath}/productos/admin/modificar?codigo=<%= prod.getId()%>">Modificar</a>
                        </td>
                        <td> 
                            <a href="${pageContext.request.contextPath}/productos/admin/eliminar?codigo=<%= prod.getId()%>">Eliminar</a>
                        </td>
                     </tr>
                    <% } %>
                </tbody>
            </table>
            </form>
        </section>
    </body>
</html>
