<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h3>
    <c:choose>

        <c:when test="${requestScope.userForm.id == null}">
            <spring:message code="user.page.header.create"/>
        </c:when>
        <c:otherwise>
            <spring:message code="user.page.header.edit"/>
        </c:otherwise>

    </c:choose>
</h3>

<spring:hasBindErrors name="userForm">
    <c:if test="${errors.hasGlobalErrors()}">
        <c:set var="passwordEqualError">${errors.globalError.defaultMessage}</c:set>
    </c:if>
</spring:hasBindErrors>
<div style="margin-top: 15px">
    <form:form modelAttribute="userForm" cssClass="form-horizontal"
               action="${pageContext.request.contextPath}/admin/users/${requestScope.userForm.id == null ? 'create' : 'edit'}"
               method="post" role="form">
        <form:input type="hidden" path="id" class="id-holder" role="form"/>

        <spring:bind path="login">
            <div class='form-group ${status.error ? "has-error" : ""}'>
                <label class="col-sm-2 control-label" for="login"><spring:message code="user.page.login"/>:</label>
                <form:input path="login" cssClass="col-sm-6 form-control" id="login" cssStyle="width: 300px;"
                            readonly="${requestScope.userForm.id != null}"/>
                <form:errors path="login" cssClass="col-sm-4 help-block"/>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class='form-group ${status.error || passwordEqualError!=null ? "has-error" : ""}'>
                <label class="col-sm-2 control-label" for="password"><spring:message
                        code="user.page.password"/>:</label>
                <form:password path="password" cssClass="col-sm-6 form-control" id="login" cssStyle="width: 300px;"/>
                <form:errors path="password" cssClass="col-sm-4 help-block"/>
            </div>
        </spring:bind>

        <spring:bind path="confirmPassword">
            <div class='form-group ${status.error || passwordEqualError!=null ? "has-error" : ""}'>
                <label class="col-sm-2 control-label" for="confirmPassword"><spring:message
                        code="user.page.confirmPassword"/>:</label>
                <form:password path="confirmPassword" cssClass="col-sm-6 form-control" id="login" cssStyle="width: 300px;"/>
                <form:errors path="confirmPassword" cssClass="col-sm-4 help-block"/>

                <%--<c:if test="${passwordEqualError!=null}">--%>
                    <%--<span class="col-sm-4 help-block">${passwordEqualError}</span>--%>
                <%--</c:if>--%>
            </div>
        </spring:bind>

        <spring:bind path="lastName">
            <div class='form-group ${status.error ? "has-error" : ""}'>
                <label class="col-sm-2 control-label" for="lastName"><spring:message
                        code="user.page.lastName"/>:</label>
                <form:input path="lastName" cssClass="col-sm-6 form-control" id="login" cssStyle="width: 300px;"/>
                <form:errors path="lastName" cssClass="col-sm-4 help-block"/>
            </div>
        </spring:bind>

        <spring:bind path="firstName">
            <div class='form-group ${status.error ? "has-error" : ""}'>
                <label class="col-sm-2 control-label" for="firstName"><spring:message
                        code="user.page.firstName"/>:</label>
                <form:input path="firstName" cssClass="col-sm-6 form-control" id="login" cssStyle="width: 300px;"/>
                <form:errors path="firstName" cssClass="col-sm-4 help-block"/>
            </div>
        </spring:bind>

        <div class="form-group">
            <div class="col-sm-offset-2">
                <input type="submit" class="btn btn-default" value='<spring:message code="button.save"/>'>

                <a class="btn btn-default" href="${pageContext.request.contextPath}/admin/users">
                    <spring:message code="button.cancel"/>
                </a>
            </div>
        </div>

    </form:form>
</div>