<%-- 
    Document   : createUser
    Created on : Aug 17, 2021, 8:02:57 PM
    Author     : Phu Thinh
--%>

<%@page import="dtos.ErrorUserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/Login.css">
        <link rel="stylesheet" href="css/Header.css">
        <title>Create Page</title>
    </head>
    <body>
        <div id="headers">
            <a href="MainController?btnAction=Logout">Logout</a></br>
            <div id="mainContent">Cerate User</div>
        </div>

        <div id="loginFrame">
            <div class="inputClass" id="loginFormContent">Input Information :</div>
            <div id="formContainer">
                <form action="MainController" method="POST">
                    <input class="input inputClass" type="text" name="userID" required="" placeholder="User ID"/></br>
                    <font color="red">${requestScope.ERROR_USER.getUserIDError()}</font><br/>
                    <input class="input inputClass" type="text" name="fullName" required="" placeholder="Full Name"/></br>
                    <font color="red">${requestScope.ERROR_USER.getFullNameError()} </font><br/>
                    <input class="input inputClass"type="password" name="password" required="" placeholder="Password"/></br>                    
                    <input class="input inputClass" type="password" name="confirm" required=""placeholder="Conform Password"/></br>
                    <font color="red">${requestScope.ERROR_USER.getConfirmError()}</font><br/>
                    <input class="btnSubmit inputClass"  type="submit" value="Create" name="btnAction"/><br>
                    <input class="btnSubmit inputClass" type="reset" value="Reset" />
                </form>
            </div>
        </div>
    </body>
</html>

