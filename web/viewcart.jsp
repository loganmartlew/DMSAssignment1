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
        </c:if>
            
        <c:if test="${cart.hasItems()}">
            <style>
                table,th,td {
                    border: 1px solid black;
                    border-collapse: collapse;
                }
                th,td {
                    padding: 0.5em;
                }
            </style>
            <table>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Total Price</th>
                        <th>Remove Item</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${cart.items}" var="item">
                        <tr>
                            <td>${item.getValue().getProduct().name}</td>
                            <td>${item.getValue().getProduct().getFormattedPrice()}</td>
                            <td>
                                <a href="/shop/CartItemServlet?action=decrement&payload=${item.getValue().getProduct().getId()}"><button>-</button></a>
                                ${item.getValue().getQuantity()}
                                <a href="/shop/CartItemServlet?action=increment&payload=${item.getValue().getProduct().getId()}"><button>+</button></a>
                            </td>
                            <td>${item.getValue().getProduct().getFormattedPrice(item.getValue().getQuantity())}</td>
                            <td><a href="/shop/CartItemServlet?action=remove&payload=${item.getValue().getProduct().getId()}"><button>Remove</button></a></td>
                        </tr>
                    </c:forEach>
                </tbody>
                <tfoot>
                    <tr>
                        <td>Total Cart Price:</td>
                        <td>${cart.getFormattedCartPrice()}</td>
                    </tr>
                </tfoot>
            </table>
        </c:if>
            
        <a href="/shop/ViewProductsServlet">View Products</a>
        
        <a href="#"><button>Checkout</button></a>
    </body>
</html>
