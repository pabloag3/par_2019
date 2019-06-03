<%-- 
    Document   : clienteAgregarModificar
    Created on : 02-jun-2019, 22:15:09
    Author     : Porfirio Perez
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="categoria.bean.Categoria"%>
<%@page import="java.util.List"%>
<%@page import="producto.bean.Producto"%>
<%@page import="cliente.bean.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar / Modificar Producto</title>
    </head>
    <body>
        <%
            String usu = "";
            HttpSession sesion = request.getSession();
            if(sesion.getAttribute("cliente") != null){
                Cliente cli =(Cliente) sesion.getAttribute("cliente");
                usu = cli.getLoginName();
            }
            Cliente cli = (Cliente) request.getAttribute("modClientes");
            String nombre = "";
            int tipo_cliente = 0;
            String apellido = "";
            int id = 0;
            String email = "";
            String contraseña = "";
            if(cli != null ) {
                contraseña = cli.getPasswd();
                nombre = cli.getNombre();
                tipo_cliente = cli.getTipoCliente();
                apellido = cli.getApellido();
                email = cli.getEmail();
                id = cli.getId().intValue();
            }
        %>
        <section id="superior">
            <div id="titulo">
                <dd>
                    <a class="inicio" href="home"><h1>Inicio Parzon!</h1></a>
                </dd>
            </div>
            <div id="login">
                <p>Usuario:<%=usu%> </p>
            </div>
        </section>

        <div>
            <form id="loginCancelar" action="cancelar" method="get">
                <button>Cancelar</button>
            </form>
        </div>
        <form name="formularioRegistrar" action="${pageContext.request.contextPath}/clientes/admin/cargar" method="post">
            <label><h1>Registro de Cliente</h1></label>
            <div id="id" hidden="true" >
                <label>Nombre: </label>
                <input type="number" placeholder="id" name="id" value="<%=id%>" required="true">
            </div>
            <div id="nombre" >
                <label>Nombre: </label>
                <input type="text" placeholder="Nombre" name="nombre" value="<%=nombre%>" required="true">
            </div>
            <div id="apellido">
                <label>Apellido: </label>
                <input type="text" placeholder="Apellido" name="apellido" value="<%=apellido%>" required="true">
            </div>
            <div id="contrasenha">
                <label>Contraseña: </label>
                <input type="password" placeholder="Contraseña" name="contrasenha" value="<%=contraseña%>" required="true">
            </div>
            <div id="email">
                <label>Email: </label>
                <input type="text" placeholder="Email" name="email" value="<%=email%>" required="true">
            </div>
            <div id="tipo_cliente">
                <label>Tipo Cliente: </label>
                <input type="number" min="0" max="1" value="<%=tipo_cliente%>" name="tipo_cliente" required="true">
                <p>0:Admin; 1:Cliente</p>
            </div>
            <input type = "submit" value = "Crear usuario" />
        </form>
        <br/>
        <div>
            <form id="loginCancelar" action="cancelar" method="get">
                <button>Cancelar</button>
            </form>
        </div>
    </body>
</html>
