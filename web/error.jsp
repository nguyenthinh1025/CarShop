<%-- 
    Document   : Error
    Created on : Aug 11, 2021, 8:38:55 PM
    Author     : Phu Thinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <h1>ERROR PAGE</h1>
        <h2>
            <font color="red" >
            ${requestScope.ERROR}
            </font>
        </h2>
        <a href="Login.jsp">Back to login page</a>
    </body>
</html>
