<%-- 
    Document   : loginPage
    Author     : coen-
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="formerror.FormErrorBean" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <main>
            <h1>Login</h1>
            <jsp:useBean id="error" class="formerror.FormErrorBean" scope="request" />
            <form action="/shop/LoginServlet">
                <label for="userName">User Name:</label><br>
                <input type="text" id="userName" name="userName"><br><br>
                <label for="password">Password:</label><br>
                <input type="password" id="password" name="password"><br>
                <c:if test="${error.getMessage() != null}">
                    <p style="color: red">${error.message}</p>
                </c:if>
                <input type="submit" value="Submit">
            </form>
            <br/>
            
            <a href = "/shop/createuser.jsp">Create User</a>
        </main>
    </body>
</html>
