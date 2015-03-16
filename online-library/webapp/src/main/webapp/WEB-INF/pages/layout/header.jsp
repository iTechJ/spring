<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed"
                    data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}"><spring:message code="system.name"/></a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}/books"><spring:message code="header.books"/></a></li>

                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <li><a href="${pageContext.request.contextPath}/admin/users"><spring:message
                            code="header.users"/></a></li>
                </sec:authorize>
            </ul>

            <form class="navbar-form navbar-right" role="navigation">

                <a class="btn btn-default" href="${pageContext.request.contextPath}/logout"
                   title="<spring:message code="header.exit"/>">
                    <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
                </a>

            </form>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <p class="navbar-text"><sec:authentication property="principal.username"/></p>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                        <spring:message code="header.lang"/><span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="${pageContext.request.contextPath}?lang=ru"><spring:message code="header.lang.ru"/></a></li>
                        <li><a href="${pageContext.request.contextPath}?lang=en"><spring:message code="header.lang.en"/></a></li>
                    </ul>
                </li>
            </ul>

        </div>
        <!--/.nav-collapse -->
    </div>
    <!--/.container-fluid -->
</nav>




