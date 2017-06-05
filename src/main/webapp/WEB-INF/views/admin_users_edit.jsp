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




            <div class="container-fluid">


                <div><%@include file="/resources/layout/topBar.jsp" %></div>


                <div class="row">

                    <div>
                        <%@include file="/resources/layout/Leftmenu.jsp" %>

                    </div>



                    <div class="col-md-8" id="table">
                        <h1>Account Summary</h1>
                        <f:form action="update" modelAttribute="User">

                            <input type="hidden" name="userId" value="${user.userId}"/>

                            <label for="usernameid">Username: </label>
                            <input type="text" name="username" value="${user.username}" id="usernameid" class="input"/><br/>

                            <label for="passwordid">Password: </label>
                            <input type="password" name="password" id="passwordid" value="${user.password}" class="input"/><br/>

                            <label for="emailid">Correo: </label>
                            <input type="email" name="email" id="emailid" value="${user.email}" class="input"/><br/>

                            <label for="balance">Balance: </label>
                            <input type="text" name="account.balance" value="${user.getCuenta().getSaldo()}" id="balance" class="input"/><br/>

                            <br/>

                            <input type="submit" id="Save" value="save"/>

                        </f:form>
                    </div>

                    <div class="col-md-2" id="menuRight">

                        <br><br><br><br><br>

                    </div>


                </div>




            </div>



        </div>




    </body>
</html>
