<%-- 
    Document   : header
    Created on : 28/03/2022, 3:27:32 pm
    Author     : Logan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head></head>
    <body>
        <header>
            <jsp:useBean id="userBean" class="user.UserAccount" scope="session" />
            <h1>Shop</h1>
            <div class="info">
                <c:if test="${userBean == null}">
                    <p>Logged Out</p>
                    <a href="/shop/loginpage.jsp">
                        <button>Login</button>
                    </a>
                </c:if>
                <c:if test="${userBean != null}">
                    <p>${userBean.userName}</p>
                    <a href="#">
                        <button>Log Out</button>
                    </a>
                </c:if>
            </div>
        </header>
        <style>
            body {
                margin: 0;
                font-family: sans-serif;
            }
            
            header {
                display: flex;
                justify-content: space-between;
                align-items: center;
                gap: 2em;
                padding: 0.5em 10%;
                background-color: #d4d4d4;
            }
            
            header .info {
                display: flex;
                align-items: center;
                gap: 1em;
            }
            
            main {
                padding: 2em 10%;
            }
        </style>
    </body>
</html>

