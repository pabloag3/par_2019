<%-- 
    Document   : Usuario
    Created on : 11-may-2019, 22:07:12
    Author     : Perez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
    <body>
        <form>
            <label><h1>Login</h1></label>
            <div id="usuario">
                <label>Usuario: </label>
                <input type="text" placeholder="Usuario">
            </div>
            <div id="contrasenha">
                <label>Contraseña: </label>
                <input type="password" placeholder="Contraseña">
            </div>
            <br/>
            <div>
                <form id="loginRgtr" action="login" method="get">
                    <button>Iniciar sesión</button>
                </form>
                <form id="loginBtn" action="clientes/registrar" method="get">
                    <button>Crear usuario</button>
                </form>
                <form id="loginCancelar" onclick="history.back()" method="get">
                    <button>Cancelar</button>
                </form>
            </div>
        </form>
    </body>
</html>