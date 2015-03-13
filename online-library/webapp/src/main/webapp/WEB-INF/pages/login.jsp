<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/custom.css" rel="stylesheet"/>

    <script src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>
    <title><spring:message code="login.page.title"/></title>


    <script>
        $(function () {
            $('#username').focus();
            $('input[type=text],input[type=password]').keypress(function (e) {
                if (e.which == 13) {
                    $("form").submit();
                }
            });
        });

        function closeAlert(button) {
            $(button).parents(".alert:first").hide();
        }
    </script>
</head>
<body>
<div class="container" style="margin-top: 150px">

    <div class="jumbotron center-block" style="width: 50%">
    <form class="form-signin" role="form" action="<c:url value='j_spring_security_check' />" method='POST'>
        <h2 class="form-signin-heading" style="text-align: center;margin-bottom: 20px"><spring:message code="login.page.title"/></h2>

        <c:if test="${not empty sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}">
            <div class="alert alert-danger fade in" style="display: block">
                <button class="close" aria-hidden="true" type="button" onclick="closeAlert(this);">x</button>
                    ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
            </div>
        </c:if>

        <input type="text" class="form-control" id="username"
               placeholder='<spring:message code="login.form.username.placeholder"/>' name='j_username'/>
        <input type="password" id="password" class="form-control"
               placeholder='<spring:message code="login.form.password.placeholder"/>' name='j_password'/>


        <button class="btn btn-lg btn-primary btn-block" style="margin-top: 10px" type="submit"><spring:message
                code="login.form.enter"/></button>

    </form>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>
