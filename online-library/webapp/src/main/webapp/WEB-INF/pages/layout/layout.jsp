<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
<head>

    <tiles:importAttribute name="title-key" toName="titleKey" ignore="true"/>
    <c:if test="${empty titleKey}">
        <c:set var="titleKey" value="${sessionScope.titleKey}"/>
    </c:if>
    <title><spring:message code="${titleKey}"/></title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css"/>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>

</head>


<body>

<div class="container">
    <tiles:insertAttribute name="header"/>
    <tiles:insertAttribute name="body"/>

</div>

<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>