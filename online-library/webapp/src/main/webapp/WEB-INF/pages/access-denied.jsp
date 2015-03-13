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

</head>
<body>
<div class="container" style="margin-top: 150px">

    <div class="jumbotron center-block" style="width: 50%">

        <h2 class="text-center" style="color: red">Access denied</h2>


    </div>
</div>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>
