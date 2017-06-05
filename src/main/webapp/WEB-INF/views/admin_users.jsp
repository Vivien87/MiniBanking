<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/resources/layout/taglibs.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <style type="text/css">
            <%@include file="/resources/css/styles.css" %>
        </style> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Banking ITCommunity</title>
    </head>

    <body>

        <div class="container">

            <header>
                <%@include file="/resources/layout/header.jsp" %>
            </header>



            <div class="container-fluid" > 


                <div><%@include file="/resources/layout/topBar.jsp" %></div>

                <div class="row">

                    <div>
                       <%@include file="/resources/layout/Leftmenu.jsp" %>

                    </div>




                    <div class="col-md-8" id="table">
                        
                        <h2>User administration</h2>
                        <a href="<c:url value="/user/registr"/>">Add</a>
                        <table class="table table-hover" border="0">
                            <tr>
                                <th>ID</th>
                                <th>Username</th>
                                <th>Password</th>
                                <th>Email</th>
                                <th>Balance</th>
                                <th>Action</th>
                            </tr>
                            <c:forEach items="${lst}" var="p">
                                <tr>
                                    <td>${p.userId}</td>
                                    <td>${p.username}</td>
                                    <td>${p.password}</td>
                                    <td>${p.email}</td>
                                    <td>$ ${p.getAccount().getBalance()}</td>


                                    <td>
                                        <a href="edit?id=${p.userId}">Edit</a>
                                        <a href="remove?id=${p.userId}" onclick="return confirm('Are you sure?')">Remove</a>
                                    </td>


                                </tr>
                            </c:forEach>



                        </table>

                    </div>
                        
                        <div class="col-md-2" id="menuRight">

                        <br><br><br><br><br>

                    </div>
                </div>
            </div>

        </div>

    </body>
</html>
