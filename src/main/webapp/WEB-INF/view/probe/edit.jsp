<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="content" var="content"/>

<t:header />
<h2><fmt:message key="probe" bundle="${content}"/></h2>
<div class="container">
<form action="/order/form.html" method="post" role="form" data-toggle="validator">
    <div class="form-group col-xs-5">

        <c:if test="${data.id == 0}"> <c:set var = "filterOrder" scope = "page" value = "${data.filter}"/></c:if>
        <c:if test="${data.id != 0}"> <c:set var = "filterOrder" scope = "page" value = "${data.orderId}"/></c:if>
        <label for="order" class="control-label col-xs-5"><fmt:message key="order" bundle="${content}"/></label>
        <select name="orderId" id="orderId" class="form-control" required autofocus>
            <option value="" selected>--<fmt:message key="choose_order" bundle="${content}"/>--</option>
            <c:forEach var="order" items="${data.filterList}">
                <c:choose>
                    <c:when test="${order.id==filterOrder}">
                        <option value="${order.id}" selected>${order.number} (${order.name} - ${order.probesQuantity})</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${order.id}">${order.number} (${order.name} - ${order.probesQuantity})</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>

        <label for="numberLab" class="control-label col-xs-5"><fmt:message key="probe_number_laboratory" bundle="${content}"/></label>
        <input type="number" name="numberLab" id="numberLab" class="form-control" min="1" value="${data.numberLab}" required/>

        <label for="numberCustomer" class="control-label col-xs-5"><fmt:message key="probe_number_customer" bundle="${content}"/></label>
        <input type="number" name="numberCustomer" id="numberLab" class="form-control" min="1"value="${data.numberCustomer}" required/>

        <label for="dateReceiving" class="control-label col-xs-5"><fmt:message key="date_receiving" bundle="${content}"/></label>
        <c:if test="${data.id == 0}"> <c:set var = "date" scope = "page" value = "${data.date}"/></c:if>
        <c:if test="${data.id != 0}"> <c:set var = "date" scope = "page" value = "${data.dateReceiving}"/></c:if>
        <fmt:formatDate var="dateReceivingFmt" dateStyle = "short" value = "${date}"/>
        <input type="text" name="dateReceiving" id="dateReceiving" class="form-control" value="${dateReceivingFmt}"  placeholder="<fmt:message key='date_placeholder' bundle='${content}'/>" required/>

        <label for="pointSampling" class="control-label col-xs-5"><fmt:message key="point_sampling" bundle="${content}"/></label>
        <input type="text" name="pointSampling" id="pointSampling" class="form-control" value="${data.pointSampling}" required/>

        <label for="dateSampling" class="control-label col-xs-5"><fmt:message key="date_sampling" bundle="${content}"/></label>
        <fmt:formatDate var="dateSamplingFmt" dateStyle = "short" value = "${data.dateSampling}"/>
        <input type="text" name="dateSampling" id="dateSampling" class="form-control" value="${dateSamplingFmt}"  placeholder="<fmt:message key='date_placeholder' bundle='${content}'/>" required/>

        <label for="remark" class="control-label col-xs-5"><fmt:message key="remark" bundle="${content}"/></label>
        <textarea name="remark" id="remark" cols="50" rows="5" class="form-control">${data.remark}</textarea>
        </br>
        <t:buttonApplySaveCancel />
    </div>
    <input type="hidden" name="option" value ="probe">
    <input type="hidden" name="filter" value ="${data.filter}">
    <input type="hidden" name="recordId" value="${data.id}"/>
</form>
</div>
<t:footer />
