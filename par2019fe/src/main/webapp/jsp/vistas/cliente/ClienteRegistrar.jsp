<%-- 
    Document   : ClienteRegistrar
    Created on : 12-may-2019, 0:40:22
    Author     : Porfirio Perez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <form>
            <label><h1>Registro de Cliente</h1></label>
            <div id="nombre" name="nombre">
                <label>Nombre: </label>
                <input type="text" placeholder="Nombre">
            </div>
            <div id="apellido" name="apellido">
                <label>Apellido: </label>
                <input type="text" placeholder="Apellido">
            </div>
            <div id="email" name="email">
                <label>Email: </label>
                <input type="text" placeholder="Email">
            </div>
            <div id="contrasenha">
                <label>Contraseña: </label>
                <input type="password" placeholder="Contraseña">
            </div>
            <div id="tipo_cliente" hidden="true" name="passwd">
                <input type="password" value="1">
            </div>
            <br/>
            <div>
                <form id="loginRgtr" action="registrar" method="post">
                    <button>Registrar usuario</button>
                </form>
                <form id="loginBtn" action="login" method="get">
                    <button>Ya tengo una cuenta</button>
                </form>
                <form id="loginCancelar" onclick="history.back()" method="get">
                    <button>Cancelar</button>
                </form>
            </div>
        </form>
    </body>
</html>
