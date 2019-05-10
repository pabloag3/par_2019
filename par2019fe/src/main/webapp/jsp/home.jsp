<%-- 
    Document   : home
    Created on : 09/05/2019, 08:02:40 PM
    Author     : Pablo Aguilar
    Author     : Porfirio Perez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body><center><h1>Inicio  Pablinchi!</h1></center>
        <div>
            <form id="formularioProducto" action="productos" method="get">
                <button type="submit">Ir a productos</button>
            </form>
            <form id="formularioCarrito" action="/productos" method="get">
                <button type="submit">Ir a Carrito</button>
            </form>
        </div>
    </body>
</html>
