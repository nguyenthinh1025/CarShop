<%-- 
    Document   : Search
    Created on : Aug 11, 2021, 8:21:17 PM
    Author     : Phu Thinh
--%>

<%@page import="dtos.UserDTO"%>
<%@page import="java.util.List"%>
<%@page import="dtos.ProductDTO"%>
<%@page import="dtos.ProductDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/Header.css">
        <link rel="stylesheet" href="css/Login.css">
        <link rel="stylesheet" href="css/Search.css">
        <title>Oto Page</title>
    </head>
    <body>
        <%
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            if (user == null || !"AD".equals(user.getRole())) {
                response.sendRedirect("login.jsp");
                return;
            }
        %>
        <div id="headers">
            <a href="MainController?btnAction=Logout">Logout</a></br>
            <a id="btnView"  href="insert.jsp">Insert New Oto</a></br>


            <div id="mainContent" <h3>HELLO ADMIN : <%= user.getFullName()%></h3></div>
            <div id="secondaryContent">Wellcome to Thinh Store!!</div>
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
                Search Name <input class="input inputClass" type="text" name="txtSearchName" value="<%= searchValue%>">
                Search Catagory : <input class="input inputClass" type="text" name="txtSearchCatagory" value="<%= searchValue1%>">
                <input class="input inputClass" type="submit" name="btnAction" value="Search"/>
            </form>
        </div>

        <div id="table">  
            <font color="red"><h2>${requestScope.ERROR}</h2></font></br>
                <%
                    List<ProductDTO> list = (List<ProductDTO>) request.getAttribute("LIST_PRODUCT");
                    if (list != null) {
                %>
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Image</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Category</th>
                        <th>Update</th>
                        <th>Delete</th>                   
                    </tr>
                </thead>
                <tbody>
                    <%
                        int count = 1;
                        for (ProductDTO dto : list) {
                    %>
                <form action="MainController" method="POST">
                    <tr>
                        <td><%= count++%></td>
                        <td>
                            <input type ="text" name="txtOtoID" value="<%= dto.getOtoID()%>" readonly="true"/>
                        </td>
                        <td>
                            <input type ="text" name="txtOtoName" value="<%= dto.getOtoName()%>"/>
                        </td>
                        <td>
                            <img src="<%=dto.getImage()%>"  width="200px" height="100px">                    
                        </td>

                        <td>
                            <input type ="number" name="txtOtoPrice" value="<%= dto.getPrice()%>"/>
                        </td>
                        <td>
                            <input type ="number" name="txtOtoQuantity" value="<%= dto.getQuantity()%>"/>
                        </td>
                        <td>
                            <input type ="text" name="txtOtoCatagoryID" value="<%=dto.getCatagoryID()%>"/>
                        </td>
                        <td>
                            <input type="submit" name="btnAction" value="Update"/>
                            <input type="hidden" name="txtSearchName" value="<%=searchValue%>"/>
                            <input type="hidden" name="txtSearchCatagory" value="<%=searchValue1%>"/>
                            <input type="hidden" name="txtOtoID" value="<%=dto.getOtoID()%>"/>

                        </td>
                        <td>
                            <a href="MainController?btnAction=Delete&txtOtoID=<%= dto.getOtoID()%>&txtSearchName=<%= searchValue%>&txtSearchCatagory=<%= searchValue1%>">Delete</a>

                        </td>


                    </tr>
                </form>
                <%
                    }
                %>
                </tbody>
            </table>
            <%
                }
            %>

        </div>
    </body>
</html>
