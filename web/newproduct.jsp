<%-- 
    Document   : newproduct
    Created on : 22/03/2022, 5:33:04 pm
    Author     : Logan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="formerror.FormErrorBean" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>List a Product</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <main>
            <h1>List a Product</h1>
            <jsp:useBean id="error" class="formerror.FormErrorBean" scope="request" />
            <form action="/shop/ValidateProductServlet">
                <div>
                    <label for="name">Product Name:</label><br />
                    <input type="text" name="name" id="name" value="${error.getObject().getName()}" />
                </div>
                <br />

                <div>
                    <label for="description">Description:</label><br />
                    <textarea name="description" id="description">${error.getObject().getDescription()}</textarea>
                </div>
                <br />

                <div>
                    <label for="quantity">Quantity:</label><br />
                    <input type="number" name="quantity" id="quantity" value="${error.getObject().getQtyString()}" />
                </div>
                <br />

                <div>
                    <label for="price">Price ($):</label><br />
                    <input type="number" name="price" id="price" value="${error.getObject().getPriceString()}" />
                </div>
                <br />

                <c:if test="${error.getMessage() != null}">
                    <p style="color: red">${error.message}</p>
                </c:if>

                <button type="submit">Submit Product</button>
            </form>
        </main>
    </body>
</html>
