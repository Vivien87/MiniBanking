<div class="row">
    <div class="col-md-6" id="topBar">
        <b>You are welcome <sec:authentication property="principal.username"/></b>
    </div>
    <div class="col-md-6" id="topBar">
        <a href="<c:url value="/logout" />">Logout</a>
    </div>
</div>