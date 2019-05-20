<%-- 
    Document   : listaProducto
    Created on : 09/05/2019, 09:15:23 PM
    Author     : Pablo Aguilar
    Author     : Porfirio Perez
--%>

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
            ArrayList<Producto> productos = new ArrayList<>();
            productos = (ArrayList) request.getAttribute("productos");
            //Producto pro = productos.get(0);
            System.out.println("className.methodName()" + productos.toString());
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
                        for(Producto prod : productos) {
                            System.out.println(prod.toString());
                    %>
                    <tr>
                        <td> <%= prod.getId() %> </td>
                        <td> <%= prod.getDescripcion() %> </td>
                        <td> <%= prod.getIdCategoria() %> </td>
                        <td> <%= prod.getPrecioUnit() %> </td>
                        <td> <button>Agregar al carrito<input hidden="true" action="eliminarProducto/{<%= prod.getId() %>}" method="post"></button></td>
                     </tr>
                    <% } %>
                </tbody>
            </table>
        </section>
    </body>
</html>
