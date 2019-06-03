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
        <form name="formularioRegistrar" action="registrar/agregar" method="post">
            <label><h1>Registro de Cliente</h1></label>
            <div id="nombre" >
                <label>Nombre: </label>
                <input type="text" placeholder="Nombre" name="nombre" required="true">
            </div>
            <div id="apellido">
                <label>Apellido: </label>
                <input type="text" placeholder="Apellido" name="apellido" required="true">
            </div>
            <div id="email">
                <label>Email: </label>
                <input type="text" placeholder="Email" name="email" required="true">
            </div>
            <div id="contrasenha">
                <label>Contraseña: </label>
                <input type="password" placeholder="Contraseña" name="contrasenha" required="true">
            </div>
            <div id="tipo_cliente" hidden="true" name="tipo_client">
                <input type="password" value="1">
            </div>
            <input type = "submit" value = "Crear usuario" />
        </form>
        <br/>
        <div>
            <form id="loginBtn" action="login" method="get">
                <button>Ya tengo una cuenta</button>
            </form>
            <form id="loginCancelar" action="cancelar" method="get">
                <button>Cancelar</button>
            </form>
        </div>
    </body>
</html>
