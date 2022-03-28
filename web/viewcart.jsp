<%-- 
    Document   : cart
    Created on : 28/03/2022, 12:49:20 pm
    Author     : Logan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
    </head>
    <body>
        <jsp:useBean id="cart" class="cart.Cart" scope="session" />
        <h1>Cart</h1>
        
        <c:if test="${!cart.hasItems()}">
            <p>Cart is empty</p>
            <a href="/shop/ViewProductsServlet">View Products</a>
        </c:if>
            
        <c:if test="${cart.hasItems()}">
            <table>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Total Price</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${cart.items}" var="item">
                        <tr>
                            <td>${item.getProduct().name}</td>
                            <td>${item.getProduct().getFormattedPrice()}</td>
                            <td>${item.quantity}</td>
                            <td>${item.getProduct().getFormattedPrice(item.quantity)}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </body>
</html>
