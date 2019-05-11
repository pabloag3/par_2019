<%-- 
    Document   : agregarProducto
    Created on : May 11, 2019, 3:56:00 PM
    Author     : tatoa
--%>

<%@page language="java" %>
<%@page import="java.util.List"%>
<%@page import="bean.categoria.domain.model.entity.Categoria" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">
        <title>Agregar producto</title>
    </head>
    <body>
        <h1>Agregar producto</h1>
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
                <%   List<Categoria> categorias = Categoria.clas %>
                <div class="col2">
                    <select name="categorias">
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
    </body>
</html>
