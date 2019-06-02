<%-- 
    Document   : listarCompras
    Created on : Jun 2, 2019, 5:11:21 PM
    Author     : tatoa
--%>

<%@page import="cliente.bean.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
    </body>
</html>
