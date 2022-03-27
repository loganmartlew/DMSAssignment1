<%-- 
    Document   : userLogged
    Created on : 27/03/2022, 3:18:16 pm
    Author     : coen-
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8" 
        import="Users.UserAccount"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
    <centre>
        <% UserAccount user =(UserAccount(session.getAttribute("currentSessionUser")));%>
        
        Welcome<%= user.getUserName() %>
    </centre>
    </body>
</html>
