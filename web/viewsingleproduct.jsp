<%-- 
    Document   : viewsingleproduct
    Created on : 27/03/2022, 1:37:22 pm
    Author     : Logan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>${product.name}</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>${product.name}</h1>
        <a href="/shop/viewProductsServlet">Back to products</a>
        <p>${product.description}</p>
        <p>Stock: ${product.quantity}</p>
        <p>Price: ${product.getFormattedPrice()}</p>
        <a href="#"><button>Add to cart</button></a>
    </body>
</html>
