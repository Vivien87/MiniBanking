<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/resources/layout/taglibs.jsp" %>
<!DOCTYPE html>

<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <style type="text/css"><%@include file="/resources/css/styles.css" %></style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Banking ComunidadIT</title>
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
                        
                        <h4>Nº account: 648418/${session_user.getUserId()}</h4>
                        <h4>ID: ${session_user.getPersona().getId()}</h4>
                        <br>
                        <h4>Balance: $${session_user.getAccount().getBalance()}</h4>
                        <h3>Last movements</h3>
                        <table class="table table-hover" border="0">
                            <tr>
                                <th>Date</th>
                                <th>Movements</th>
                            </tr>
                            <c:forEach items="${session_user.getAccount().getMovements()}" var="p">
                                <tr>
                                    
                                    <td>${p.action}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                    <div class="col-md-2" id="rightMenu">
                        <br><br><br><br><br>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
