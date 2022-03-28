<%-- 
    Document   : loginPage
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
        <jsp:include page="header.jsp" />
        <main>
            <h1>Login</h1>
            <form action="/action_page.php">
                <label for="userName">User Name:</label><br>
                <input type="text" id="userName" name="userName"><br>
                <label for="password">Password:</label><br>
                <input type="password" id="password" name="password"><br><br>
                <input type="submit" value="Submit">
            </form>
        </main>
    </body>
</html>
