<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<h2><spring:message code="books.page.title"/></h2>

<table class="table" style="margin-top: 20px">
    <tr>
        <th><spring:message code="books.page.table.column.title"/></th>
        <th><spring:message code="books.page.table.column.author"/></th>
        <th class="text-center"><spring:message code="books.page.table.column.year"/></th>
        <th class="text-center"><spring:message code="books.page.table.column.price"/></th>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td class="col-md-3">${book.title}</td>
            <td class="col-md-2">${book.author}</td>
            <td class="col-md-1 text-center">${book.publicationYear}</td>
            <td class="col-md-1 text-center">${book.price}</td>
        </tr>
    </c:forEach>
</table>