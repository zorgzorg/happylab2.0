<%@ tag body-content="empty"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="content" var="content"/>

<c:if test="${not empty message}">
    <div class="alert alert-success"><fmt:message key="${message}" bundle="${content}"/></div>
</c:if>
<c:if test="${not empty message_danger}">
    <div class="alert alert-danger"><fmt:message key="${message_danger}" bundle="${content}"/></div>
</c:if>