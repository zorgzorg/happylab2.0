<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="content" var="content"/>

<t:header />
<h2><fmt:message key="customers" bundle="${content}"/></h2>
<div class="container">
    <form action="/customer/edit.html" method="post"  role="form" data-toggle="validator">
        <div class="form-group col-xs-5">
            <label for="name" class="control-label col-xs-5"><fmt:message key="title" bundle="${content}"/></label>
            <input type="text" name="name" id="name" class="form-control" value="<c:out value='${data.name}'/>" required autofocus/>

            <label for="city" class="control-label col-xs-5"><fmt:message key="city" bundle="${content}"/></label>
            <input type="text" name="city" id="city" class="form-control" value="<c:out value='${data.city}'/>" required/>

            <label for="remark" class="control-label col-xs-5"><fmt:message key="remark" bundle="${content}"/></label>
            <textarea name="remark" id="remark" cols="50" rows="5" class="form-control">${data.remark}</textarea>
            </br>
            <t:buttonApplySaveCancel />
            <input type="hidden" name="option" value ="customer">
            <input type="hidden" name="recordId" value="${data.id}"/>
        </div>
    </form>
</div>
<t:footer />
