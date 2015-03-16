<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="jumbotron">
    <c:set var="username" scope="page"><sec:authentication property="principal.fullName"/></c:set>
    <spring:message code="welcome.page.text" arguments="${username}"/>
</div>