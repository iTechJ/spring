<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h3><spring:message code="users.page.title"/></h3>

<table class="table" style="margin-top: 20px">
    <tr>
        <th><spring:message code="users.page.table.column.login"/></th>
        <th><spring:message code="users.page.table.column.lastname"/></th>
        <th><spring:message code="users.page.table.column.firstname"/></th>
        <th class="text-center"><spring:message code="users.page.table.column.status"/></th>
        <th><spring:message code="users.page.table.column.roles"/></th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td class="col-md-2">
                <a href="${pageContext.request.contextPath}/admin/users/${user.id}/editing">
                        ${user.login}
                </a>
            </td>
            <td class="col-md-2">${user.lastName}</td>
            <td class="col-md-2">${user.firstName}</td>
            <td class="col-md-1 text-center">
                <a href="${pageContext.request.contextPath}/admin/users/${user.id}/change-status?current=${user.status}">
                    <spring:message code="user.status.${user.status}"/>
                </a>
            </td>
            <td class="col-md-2">${user.roles}</td>
        </tr>
    </c:forEach>
</table>
<div class="btn-group">
    <a class="btn btn-default" href="${pageContext.request.contextPath}/admin/users/creating">
        <spring:message code="users.page.create"/>
    </a>
</div>