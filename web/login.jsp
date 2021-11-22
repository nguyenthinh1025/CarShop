<%-- 
    Document   : Login
    Created on : Aug 11, 2021, 8:13:16 PM
    Author     : Phu Thinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/Login.css">
        <link rel="stylesheet" href="css/Header.css">
        <title>Login Page</title>
    </head>
    <body>
        <div id="headers">
            <div id="mainContent"><h1>Thinh Store</h1></div>
        </div>
        <div id="loginFrame">
            <div class="inputClass" id="loginFormContent">Please sign in</div>            
            <div id="formContainer">
                <form action="MainController" method="POST">
                    <input class="input inputClass" type="text" name="txtUserID" value="" placeholder="User ID"><br>
                    <input class="input inputClass" type="password" name="txtPassword" value="" placeholder="Password"><br>
                    <input class="btnSubmit inputClass" type="submit" name="btnAction" value="Login"/></br>
                    <input class="btnSubmit inputClass" type="reset" value="Reset"/></br>

                </form>
                <font color="red">${requestScope.ERROR}</font></br>
                <a href="createUser.jsp">Create User</a></b>
            </div>
        </div>
    </body>
</html>

