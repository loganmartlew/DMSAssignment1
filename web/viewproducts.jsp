<%-- 
    Document   : viewproducts.jsp
    Created on : 26/03/2022, 4:51:26 pm
    Author     : Logan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Products</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Products</h1>
        <c:forEach items="${products}" var="product">
            <div style="margin: 2rem; padding: 1em; border: 1px solid black; width: max-content; min-width: 200px;">
                <h2>
                    <a href="/shop/ViewProductsServlet?id=${product.id}" style="color: inherit;">
                        <c:out value="${product.name}" />
                    </a>
                </h2>
                <p><c:out value="${product.description}" /></p>
                <p>Stock: <c:out value="${product.quantity}" /></p>
                <p>Price: <c:out value="${product.getFormattedPrice()}" /></p>
            </div>
        </c:forEach>
    </body>
</html>
