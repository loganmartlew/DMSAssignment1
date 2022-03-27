<%-- 
    Document   : LoginPage
    Author     : coen-
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1> Please login </h1>
        <form action="LoginServlet">
            
            Username:
            <input type="text" name="userName"/><br>
            Password:
            <input type="text" name="password"/><br>
            
            <input type="submit" value="Login">
            
        </form>
    </body>
</html>
