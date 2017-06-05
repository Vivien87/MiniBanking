<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/resources/layout/taglibs.jsp" %>

<!DOCTYPE html>

<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <style type="text/css"><%@include file="/resources/css/styles.css" %></style>
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
                        <h1>Transfer</h1>
                        <h3 style="color: green">${ok}</h3>
                        <f:form action="transferencias">
                            <input type="hidden" name="Origin Account" id="a" value="${session_user.getAccount().getId()}"/><br>

                            <label for="userB">Nº Account destination : </label> <br>
                            <input type="text" name="AccountDestin" id="b" value="" class="input" required/><br>

                            <label for="money">Quantity: </label> <br>
                            <input type="text" name="money" id="money" value="0" class="input" required/><br>


                            <input type="submit" class="btn btn-success btn-sm" value="Trasnfer"/>

                        </f:form>







                    </div>

                    <div class="col-md-2" id="rightMenu">

                        <br><br><br><br><br>

                    </div>


                </div>




            </div>



        </div>
    </body>
</html>
