<%-- 
    Document   : home
    Created on : 09/05/2019, 08:02:40 PM
    Author     : Pablo Aguilar
    Author     : Porfirio Perez
--%>
<link rel="stylesheet" type="text/css" href="estilos.css"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Principal</title>
    </head>
    
    <body>
        <div id="superior">
            <div id="titulo">
                <h1>Inicio Parzon!</h1>
            </div>
            <div id="longin">
                <button>Longin</button>
            </div>
        </div>
        <br/>
        <div>
            </center>
                <input class="buscadorProducto" placeholder="Buscar Productos en Parzon"><button>Buscar</button>
                <br/>
                <div id="principalBtn">
                    <form id="formularioProducto" action="productos" method="get">
                        <button type="submit">Ir a productos</button>
                    </form>
                    <form id="formularioCarrito" action="/productos" method="get">
                        <button type="submit">Ir a Carrito</button>
                    </form>
                </div>
            </center>
        </div>
    </body>
</html>
