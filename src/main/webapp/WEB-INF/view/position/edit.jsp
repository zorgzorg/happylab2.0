<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="content" var="content"/>

<t:header />
<h2><fmt:message key="position" bundle="${content}"/></h2>
<div class="container">
    <form action="/position/form.html" method="post"  role="form" data-toggle="validator">
        <div class="form-group col-xs-5">
            <label for="position" class="control-label col-xs-5"><fmt:message key="title" bundle="${content}"/></label>
            <input type="text" name="position" id="position" class="form-control" value="${data.position}" required autofocus/>

            <label for="remark" class="control-label col-xs-5"><fmt:message key="remark" bundle="${content}"/></label>
            <textarea name="remark" id="remark" cols="50" rows="5" class="form-control">${data.remark}</textarea>
            </br>
            <t:buttonApplySaveCancel />
            <input type="hidden" name="option" value ="position">
            <input type="hidden" name="recordId" value="${data.id}"/>
        </div>
    </form>
</div>
<t:footer />
