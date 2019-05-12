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
        <section id="superior">
            <div id="titulo">
                <dd>
                    <h1>Inicio Parzon!</h1>
                </dd>
            </div>
            <div id="login">
                <p>Usuario</p>
                <button>Login</button>
            </div>
        </section>
        <br/><br/><br/><br/>
        <br/>
        <hr>
        <section id="medio">
            <div class="buscador">
                <input class="buscadorProducto" placeholder="Buscar Productos">
                <br/>
                <br/>
            </div>
            
            <div id="principalBuscar">
                <form id="formularioProducto" action="productos" method="get">
                    <button type="submit">Buscar</button>
                </form>
            </div>
            <br/><br/>
            <div id="principalBtn">
                <form id="formularioProducto" action="productos" method="get">
                    <button type="submit">Ir a productos</button>
                </form>
                <form id="formularioCarrito" action="/productos" method="get">
                    <dd><button type="submit">Ir a Carrito</button></dd>
                </form>
            </div>
        </section>
    </body>
</html>