<%-- 
    Document   : Shopping
    Created on : Aug 13, 2021, 12:19:12 PM
    Author     : Phu Thinh
--%>

<%@page import="dtos.CatagoryDTO"%>
<%@page import="java.util.List"%>
<%@page import="dtos.ProductDTO"%>
<%@page import="dtos.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/Header.css">
        <link rel="stylesheet" href="css/Login.css">
        <link rel="stylesheet" href="css/Search.css">
        <link rel="stylesheet" href="css/Shop.css">
        <title>Shopping Page</title>

    </head>
    <body>
        <%
            List<CatagoryDTO> listCata = (List<CatagoryDTO>) request.getAttribute("LIST_CATA");
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            if (user == null || !"US".equals(user.getRole())) {
                response.sendRedirect("login.jsp");
                return;
            }
        %>

        <div id="headers">
            <a href="MainController?btnAction=Logout">Logout</a>
            <div id="mainContent"> Welcome Thinh Store:<%=user.getFullName()%></div>
            <h4>DANH SACH OTO CO TRONG CUA HANG :</h4></div>
    </div>




    <%
        String searchValue = request.getParameter("txtSearchName");
        if (searchValue == null) {
            searchValue = "";
        }
        String searchValue1 = request.getParameter("txtSearchCatagory");
        if (searchValue1 == null) {
            searchValue1 = "";
        }
    %>
    <div id="searchlist">
        <form action="MainController">
            Search Name :<input class="input inputClass" type="text" name="txtSearchName" value="<%= searchValue%>">
            Search Catagory :<select class="input inputClass" name="txtSearchCatagory">
                <%
                    if (listCata != null) {
                        for (CatagoryDTO dto : listCata) {
                %>
                <option value="<%=dto.getCatagoryID()%>"> <%= dto.getCatagoryName()%> </option>
                <%
                    }
                %>
                <option value=""> ALL </option>
                <%
                    }

                %>
            </select>
            <input class="input inputClass" type="submit" name="btnAction" value="SearchOto"/>
            
        </form>
    </div>

    <h2><font color="red">${requestScope.ERROR}</font></h2>



    <%
        List<ProductDTO> list = (List<ProductDTO>) request.getAttribute("LIST_PRODUCT");
        if (list != null) {
            for (ProductDTO dto : list) {
    %>
    <div id="viewList">
    <form action="MainController" method="POST">
        <div class="img">


            <%= dto.getOtoID()%> - <%= dto.getOtoName()%><br>
            <img src="<%=dto.getImage()%>" width="200px" height="100px"></br>
            <%= dto.getPrice()%> $</br>
            <%= dto.getQuantity()%> Quantity</br>
            <input id="quantity" type ="number" name="txtOtoQuantity"value="1" min="1" max="<%= dto.getQuantity()%>" step="1"/> </br>
            <input  id ="add" type="submit" name="btnAction" value="Add"/>

            <input type ="hidden" name="txtOtoID" value="<%= dto.getOtoID()%>" readonly="true"/>
            <input type ="hidden" name="txtOtoName" value="<%= dto.getOtoName()%>"/>
            <input type ="hidden" name="txtOtoPrice" value="<%= dto.getPrice()%>"/>
            <input type ="hidden" name="txtOtoQuantity" value="<%= dto.getQuantity()%>"/>
            <input type ="hidden" name="txtOtoCatagoryID" value="<%=dto.getCatagoryID()%>"/>                
            <input type="hidden" name="txtSearchName" value="<%= request.getParameter("txtSearchName") == null ? "" : request.getParameter("txtSearchName")%>">
            <input type="hidden" name="txtSearchCatagory" value="<%= request.getParameter("txtSearchCatagory") == null ? "" : request.getParameter("txtSearchCatagory")%>">
        </div>

    </form>
    </div>
    <%
        }
    %> 

    <%
        }
    %>  

    <a id="btnView" href="MainController?btnAction=View">View Shopping Cart</a> 


</body>
</html>