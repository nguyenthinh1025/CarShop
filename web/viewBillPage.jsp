<%-- 
    Document   : viewBillPage
    Created on : Aug 16, 2021, 8:54:18 PM
    Author     : Phu Thinh
--%>

<%@page import="dtos.ProductDTO"%>
<%@page import="java.util.Set"%>
<%@page import="dtos.CartDTO"%>
<%@page import="dtos.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/Header.css">
        <link rel="stylesheet" href="css/Cart.css">
        <title>View Bill Page</title>
    </head>
    <body>

        <%
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            float totalMoney = 0;
            if (cart == null) {
        %>
        <div>
            <h2>Shopping Cart Empty</h2>
        </div>
        <%
        } else if (cart != null) {

        %>
        <div id="headers">
            <a href="MainController?btnAction=Logout">Logout</a></br>
            <div id="mainContent">View Bill Page</div>
            <div id="secondaryContent">All the selected products in your cart</div>
        </div>

        <h1>Your bill: <%=user.getFullName()%></h1>
        <div id="mainContainer">
            <table border="1">

                <tr>


                    <th>Oto Name</th>                   
                    <th>Quantity</th>
                    <th>Unit Price</th>
                    <th>Price</th>
                    <td>Update</td>                    
                    <th>Delete</th>
                </tr>

                <%

                    for (ProductDTO list : cart.getCart().values()) {

                        totalMoney += list.getPrice() * list.getQuantity();
                %>
                <form action="MainController">
                    <tr>

                        <td><%= list.getOtoName()%></td>                  

                        <td><input  type="number" name="txtQuantity" value="<%= list.getQuantity()%>"</td>  
                        <td><%= list.getPrice()%>$</td>
                        <td><%=list.getPrice() * list.getQuantity()%>$</td>
                        <td><input id="btn" type="submit" name="btnAction" value="Update Oto"/></td>
                        <td>                       
                            <input id="btn" type="submit" name="btnAction" value="Delete Oto"/>               
                            <input  type="hidden" name="txtOtoID" value="<%= list.getOtoID()%>"/>
                        </td>

                    </tr>





                </form>

                <%
                    }
                %>


                <tr>
                    <td colspan="3"><b>Grand Total</b></td>
                    <td id="grandTotal" colspan="0"><b><%=totalMoney%>$</b></td>
                </tr>
            </table> 



            <form action="MainController" >
                <input id="buy" type="submit" name="btnAction" value="Buy Oto"/>
                <input type="hidden" name="txtUserID" value="<%=user.getUserID()%>"/>    
                <input type="hidden" name="totalMoney" value="<%=totalMoney%>"/>  
            </form>


            <%
                }
            %>

            <a id="btnContinue" href="UserSearchController"> Add more!</a> 
            <input type="hidden" name="txtUserID" value="<%=user.getUserID()%>"/>   

        </div>


        <div id="paypal-button-container"></div>
        <form action="MainController" method="POST" style="display: none">
            <input type="hidden" name="total" value="${total+0.5}">
            <input type="hidden" name="userID" value="${sessionScope.USER.getUserID()}">
            <input type="hidden" name="voucherID" value="${requestScope.DISCOUNT.getDiscountID()}">
            <input type="submit" name="action" id="ppButton" value="Paypal">
        </form>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://www.paypal.com/sdk/js?client-id=Abt1sXyO3BlIRE3m7690odmoURU0BYNR9JeEkTXZtGQX2bX6jFt4BHB7bOFmcZ1zTGt0VvVDhub8nqsk"></script>
        <script>

            paypal.Buttons({

                style: {
                    color: 'blue',
                    shape: 'pill'
                },
                createOrder: function (data, actions) {
                    //Hàm này thiết lập chi tiết của giao dịch, bao gồm số tiền và chi tiết mục hàng. 
                    return actions.order.create({
                        purchase_units: [{
                                amount: {
                                    value: '${total+0.5}'
                                }
                            }]
                    });
                },
                onApprove: function (data, actions) {
                    // Chức năng này thu tiền từ giao dịch.
                    return actions.order.capture().then(function (details) {
                        // Chức năng này hiển thị thông báo giao dịch thành công cho người mua của bạn.
                        document.getElementById("ppButton").click();
                    });
                }
            }).render('#paypal-button-container');
            //Chức năng này hiển thị các Nút thanh toán thông minh trên trang web của bạn.  


        </script>
    </body>
</html>
