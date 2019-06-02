<%-- 
    Document   : productoAgregarModificar
    Created on : 02-jun-2019, 14:33:55
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
            List<Categoria> categorias;
            Producto pro = (Producto) request.getAttribute("modProducto");
            int cant = 0;
            int precio = 0;
            int categoria = 0;
            int id = 0;
            String des = "";
            if(pro != null ) {
                cant = pro.getCantidad().intValue();
                precio = pro.getPrecioUnit().intValue();
                categoria = pro.getIdCategoria();
                id = pro.getId().intValue();
                des = pro.getDescripcion();
            }
            categorias = (List<Categoria>) request.getAttribute("categorias");
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
            <h4>Lista de Categorias</h4>
        <table>
            <thead border=1>
               <th>Codigo</th>
               <th>Nombre</th>
            </thead>
            <tbody>
                <%
                    if(categorias == null) categorias = new ArrayList<>();
                    int max = categorias.size();
                    for(Categoria cat: categorias) {
                %>
                <tr>
                    <td> <%= cat.getId() %> </td>
                    <td> <%= cat.getDescripcion() %> </td>
                 </tr>
                <% } %>
            </tbody>
        </table>
        <form name="formProductoAM" action="${pageContext.request.contextPath}/productos/admin/cargar" method="post">
            <label><h1>Registro de Producto</h1></label>
            <div id="descripcion">
                <label>Descripción: </label>
                <input type="text" placeholder="Nombre" name="descripcion" value="<%=des%>" required="true">
            </div>
            <div id="categoria">
                <label>Categoria: </label>
                <input type="number" placeholder="Categoria" name="categoria" min="0" max="<%= max %>" value="<%=categoria%>" required="true">
            </div>
            <div id="precio">
                <label>Precio Unitario: </label>
                <input type="number" placeholder="Precio Unitario" name="precio" min="0" value="<%=precio%>" required="true">
            </div>
            <div id="cantidad">
                <label>Cantidad: </label>
                <input type="number" placeholder="Cantidad" name="cantidad" min="0" value="<%= cant%>" required="true">
            </div>
            <div id="tipo_cliente" hidden="true">
                <input type="number" name="id_producto" value="<%=id%>">
            </div>
            <input type = "submit" value = "Cargar Producto"/>
        </form>
        <br/>
        <div>
            <form id="loginCancelar" action="cancelar" method="get">
                <button>Cancelar</button>
            </form>
        </div>
    </body>
</html>
