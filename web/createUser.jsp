<%-- 
    Document   : createUser
    Author     : coen-
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="formerror.FormErrorBean" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create new user account</title>
    </head>
    <body>
        <h1>Create Account</h1>
        <jsp:useBean id="error" class="formerror.FormErrorBean" scope="request" />
        <form action="/shop/ValidateProductServlet">
            <div>
                <label for="userName">User Name:</label><br />
                <input type="text" name="userName" id="userName" value="${error.getObject().getUserName()}" />
            </div>
            
            <br />
            <div>
                <label for="password">Password:</label><br />
                <input type="password" name="password" id="password" value="${error.getObject().getPassword()}" />\
            </div>
            
            <br />
            <c:if test="${error.getMessage() != null}">
                <p style="color: red">${error.message}</p>
            </c:if>

            <button type="submit">Submit Product</button>
        </form>

    </body>
</html>
