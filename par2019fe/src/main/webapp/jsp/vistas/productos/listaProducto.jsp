<%-- 
    Document   : listaProducto
    Created on : 09/05/2019, 09:15:23 PM
    Author     : Pablo Aguilar
    Author     : Porfirio Perez
--%>

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
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listas de Productos.</title>
    </head>
    <body>
        <%
            List<Producto> productos = new ArrayList<Producto>();          
            productos = (List<Producto>) request.getAttribute("productos");
            Iterator<Producto> it = productos.iterator();
        %>
        <section id="superior">
            <div id="titulo">
                <dd>
                    <h1>Inicio Parzon!</h1>
                </dd>
            </div>
            <div id="login">
                <p>Usuario</p>
                <button>Login</button>
                <form id="formularioCarrito" action="/productos" method="get">
                    <dd><button type="submit">Ir a Carrito</button></dd>
                </form>
            </div>
        </section>
        <br/><br/><br/><br/>
        <br/>
        <hr>
        <section id="medio">
            <input class="buscadorProducto" placeholder="Buscar Productos en Parzon">
            <dd>
                <button>Buscar</button>
            </dd>
            <table>
                <thead border=1>
                   <th>Codigo</th>
                   <th>Nombre</th>
                   <th>Categoria</th>
                   <th>Precio</th>
                   <th>Cantidad</th>
                </thead>
                <tbody>
                    <%
                        int longitud = productos.size();
                        for(int i = 0 ; i <longitud ; i++) {                            
                    %>
                    <tr>
                        <td> <%= productos.get(i).getId() %> </td>
                        <td> <%= productos.get(i).getDescripcion() %> </td>
                        <td> <%= productos.get(i).getIdCategoria() %> </td>
                        <td> <%= productos.get(i).getPrecioUnit() %> </td>
                        <td> <button>Agregar al carrito<input hidden="true" action="eliminarProducto/{<%= productos.get(i).getId() %>}" method="post"></button></td>
                     </tr>
                    <% } %>
                </tbody>
            </table>
        </section>
    </body>
</html>
