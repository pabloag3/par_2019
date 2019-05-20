<%-- 
    Document   : carrito
    Created on : May 20, 2019, 3:36:45 PM
    Author     : tatoa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrito de compra</title>
    </head>
    <body>
        <table cellpadding="2" cellspacing="2" border="1">
		<tr>
			<th>Option</th>
			<th>Name</th>
			<th>Price</th>
		</tr>
		<c:set var="total" value="0"></c:set>
		<c:forEach var="item" items="${sessionScope.cart }">
			<c:set var="total" value="${total + item.product.price * item.quantity }"></c:set>
			<tr>
                            <td align="center">
                                    <a href="${pageContext.request.contextPath }/cart?action=remove&id=${item.product.id }"
                                    onclick="return confirm('Estas seguro?')">Eliminar</a>
                            </td>
                            <td>${item.product.name }</td>
                            <td>${item.product.price }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6" align="right">Total</td>
			<td>${total }</td>
		</tr>
	</table>
    </body>
</html>
