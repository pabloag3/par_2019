<%-- 
    Document   : listarCompras
    Created on : Jun 2, 2019, 5:11:21 PM
    Author     : tatoa
--%>

<%@page import="transaccion.bean.Transaccion"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cliente.bean.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" type="text/css" href="estilos.css"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mis compras</title>
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
                    <a class="inicio" href="home"><h1>Inicio Parzon!</h1></a>
                </dd>
            </div>
            <div id="login">
                <p>Usuario: <%=usu%> </p>
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
        <%
            List<Transaccion> t = new ArrayList<Transaccion>();
            
            
        %>
        <table cellpadding="2" cellspacing="2" border="1">
            <thead border="1">
                <th>Nro.</th>
                <th>Fecha</th>
                <th>Cantidad de items</th>
                <th>Monto</th>
            </thead>
        </table>
        
        
        
    </body>
</html>
