<%-- 
    Document   : agregarModificarProducto
    Created on : May 11, 2019, 3:48:24 PM
    Author     : tatoa
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="producto.bean.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ABM Productos</title>
    </head>
    <body>
        <h1>PRODUCTOS: Agregar, modificar y eliminar</h1>
        <form action="guardarProducto" method="post">
            <div id="row1">
                <div class="col1">
                    <label>Descripcion:</label>
                </div>
                <div class="col2">
                    <input type="text" name="Descripcion" id="descripcion">
                </div>
            </div>
            <div id="row1">
                <div class="col1">
                    <label>Categoria</label>
                </div>
                <div class="col2">
                    <select name="categorias"> <!-- agregar lista -->
                        <option value="1">Windows Vista</option> 
                    </select>
                </div>
            </div>
            <div id="row1">
                <div class="col1">
                    <label>Precio unitario:</label>
                </div>
                <div class="col2">
                    <input type="number" name="precioUnit" id="precioUnit">
                </div>
            </div>
            <div id="row1">
                <div class="col1">
                    <label>Cantidad:</label>
                </div>
                <div class="col2">
                    <input type="number" name="cantidad" id="cantidad">
                </div>
            </div>
            <input type="submit" value="Submit">
        </form>
        
        <div>
            <label>Buscar por Producto</label>
            <input type="text" placeholder="Nombre Producto"/>
            <br/>
            <br/>
            <label>Buscar por Categoria</label>
            <input type="text" placeholder="Categoria"/>
        </div>
        <h1>Lista de Productos</h1>
        <table>
            <thead border=1>
               <th>Codigo</th>
               <th>Nombre</th>
               <th>Categoria</th>
               <th>Precio</th>
               <th>Cantidad</th>
            </thead>
            <tbody>
                <% 
                    ArrayList<Producto> productos = new ArrayList<>();
                    Producto pro = new Producto((Integer)1, "Computadora", 1, (Long.parseLong("5")), (Long.parseLong("10")));
                    productos.add(pro);
                %>
                <%  
                    for(Producto prod : productos) { 
                    //Categoria cat = (Categoria) categoriaService.findById(prod.getIdCategoria()); 
                %>
                <tr>
                    <td> <%= prod.getId() %> </td>
                    <td> <%= prod.getDescripcion() %> </td>
                    <td> <%= prod.getIdCategoria() %> </td>
                    <td> <%= prod.getPrecioUnit() %> </td>
                    <td> <%= prod.getCantidad() %> </td>
                    <td> <button>Modificar</button></td>
                    <td> <button>Eliminar<input hidden="true" action="eliminarProducto/{<%= prod.getId() %>}" method="post"></button></td>
                 </tr>
                <% } %>
            </tbody>
        </table>
    </body>   
</html>