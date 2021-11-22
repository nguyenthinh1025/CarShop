<%-- 
    Document   : Insert
    Created on : Aug 13, 2021, 12:45:41 PM
    Author     : Phu Thinh
--%>

<%@page import="dtos.CatagoryDTO"%>
<%@page import="dtos.ProductError"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="dtos.ProductDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/Login.css">
        <link rel="stylesheet" href="css/Header.css">
        <title>Insert Page</title>
    </head>
    <body>
        <div id="headers">
            <a href="MainController?btnAction=Logout">Logout</a></br>
            <div id="mainContent"><h1>Insert Page</h1></div>
        </div>

        <div id="loginFrame">
            <div class="inputClass" id="loginFormContent">Please Insert New Oto</div>            
            <div id="formContainer">
                <form action="MainController" method="POST">
                    <input class="input inputClass" type="text" name="txtID" placeholder="Oto ID"></br>
                    <font color="red">${requestScope.ERROR.getOtoIDError()}</font></br>
                    <input class="input inputClass" type="text" name="txtName" placeholder="Oto Name"></br>
                    <font color="red">${requestScope.ERROR.getOtoNameError()}</font></br>
                    <font color="red"><input class="input inputClass" type="text" name="txtImage" placeholder="Image"></br>
                    <font color="red">${requestScope.ERROR.getImageError()}</font></br>
                    <input class="input inputClass" type="number" name="txtPrice" placeholder="Price"></br>
                    <font color="red">${requestScope.ERROR.getPriceError()}</font></br>
                    <input class="input inputClass" type="number" name="txtQuantity" placeholder="Quantity"></br>
                    <font color="red">${requestScope.ERROR.getQuantityError()}</font></br>
                    <input class="input inputClass" type="text" name="txtCatagory" placeholder="Catagory"></br>
                    <font color="red">${requestScope.ERROR.getCatagoryIDError()}</font></br>
                    <input class="btnSubmit inputClass" type="submit" name="btnAction" value="Insert"></br>
                    <input class="btnSubmit inputClass" type="reset"  value="Reset"></br>

                </form>
            </div>
    </body>
</html>
