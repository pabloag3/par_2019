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
        <title>Listas de Productos.</title>
    </head>
    <body>
        <%
            boolean ocultar = false;
            String usu = "";
            HttpSession sesion = request.getSession();
            if(sesion.getAttribute("cliente") != null) {
                ocultar = true;
                Cliente cli =(Cliente) sesion.getAttribute("cliente");
                usu = cli.getLoginName();
            }
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
            <form action="productos" method="get">
                <input name="descripcion" class="buscadorProducto" placeholder="Buscar Productos">
                <input name="categoria" class="buscadorCategoria" placeholder="Buscar Categoria">
                <br/>
                <br/>
                <dd>
                    <button type="submit">Buscar</button>
                </dd>
                <br/>
            </form>
            <table>
                <thead border=1>
                   <th>Nombre</th>
                   <th>Categoria</th>
                   <th>Precio</th>
                   <!-- <th>Cantidad</th> -->
                   <th>Agregar Carrito</th>
                </thead>
                <tbody>
                    <%
                        for(Producto prod: productos) {
                            String catego = categorias.get(prod.getIdCategoria()).getDescripcion();
                    %>
                    <tr>
                        <td> <%= prod.getDescripcion() %> </td>
                        <td> <%= catego %> </td>
                        <td> <%= prod.getPrecioUnit() %> </td>
                        <td> <input name="canti" placeholder="1" disabled="true"> </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/carrito/agregar?codigo=<%= prod.getId()%>&cantidad=1">Comprar</a>
                        </td>
                     </tr>
                    <% } %>
                </tbody>
            </table>
            </form>
        </section>
    </body>
</html>
