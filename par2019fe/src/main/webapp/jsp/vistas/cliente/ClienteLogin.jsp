<%-- 
    Document   : Usuario
    Created on : 11-may-2019, 22:07:12
    Author     : Perez
--%>

<%@page import="cliente.bean.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
    <body>
        <%
            String usu = "";
            if(request.getAttribute("cliente") != null){
                Cliente cli =(Cliente) request.getAttribute("cliente");
                usu = cli.getLoginName();
            }
        %>    
        <form action="ingresar">
            <label><h1>Login</h1></label>
            <div id="usuario">
                <label>Usuario: <%=usu%></label>
                <input type="text" placeholder="Usuario" name="usu">
            </div>
            <div id="contrasenha">
                <label>Contraseña: </label>
                <input type="password" placeholder="Contraseña" name="pass">
            </div>
            <br/>
            <div>
                <form id="loginRgtr" action="login" method="get">
                    <button>Iniciar sesión</button>
                </form>
                <form id="loginBtn" action="registrar" method="get">
                    <button>Crear usuario</button>
                </form>
                <form id="loginCancelar" action="cancelar" method="get">
                    <button>Cancelar</button>
                </form>
            </div>
        </form>
    </body>
</html>