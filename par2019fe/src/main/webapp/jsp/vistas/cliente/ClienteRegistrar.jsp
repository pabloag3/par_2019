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
            <div id="nombre">
                <label>Nombre</label>
                <input type="text" placeholder="Nombre">
            </div>
            <div id="apellido">
                <label>Apellido</label>
                <input type="text" placeholder="Apellido">
            </div>
            <div id="email">
                <label>Email</label>
                <input type="text" placeholder="Email">
            </div>
            <div id="contrasenha">
                <label>Contraseña: </label>
                <input type="password" placeholder="Contraseña">
            </div>
            <div id="tipo_cliente" hidden="true">
                <input type="password" value="1">
            </div>
            <br/>
            <div>
                <input type="button" value="Crear Usuario"/>
                <input type="button" value="Ingresar Usuario"/>
                <input type="button" value="cancelar"/>
            </div>
        </form>
    </body>
</html>
