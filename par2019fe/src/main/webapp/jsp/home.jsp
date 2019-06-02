<%-- 
    Document   : home
    Created on : 09/05/2019, 08:02:40 PM
    Author     : Pablo Aguilar
    Author     : Porfirio Perez
--%>
<%@page import="cliente.bean.Cliente"%>
<link rel="stylesheet" type="text/css" href="estilos.css"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Principal</title>
    </head>
    <body>
        <%
            String usu = "";
            if(request.getAttribute("cliente") != null){
                Cliente cli =(Cliente) request.getAttribute("cliente");
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
                <p>Usuario:<%=usu%> </p>
                <form id="loginBtn" action="clientes/login" method="get">
                    <button>Login</button>
                </form>
                <form id="loginRgtr" action="clientes/registrar" method="get">
                    <button>Registrar</button>
                </form>
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
                <form id="formularioProducto" action="productos/listar-productos" method="get">
                    <button type="submit">Ir a productos</button>
                </form>
                <form id="formularioCarrito" action="carrito/listar-carrito" method="get">
                    <dd><button type="submit">Ir a Carrito</button></dd>
                </form>
            </div>
        </section>
    </body>
</html>