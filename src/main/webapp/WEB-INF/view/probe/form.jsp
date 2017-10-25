<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="content" var="content"/>

<t:header />
<h2><fmt:message key="probes" bundle="${content}"/></h2>
<t:message />
<div class="container">
<form action="/order/form.html" method="POST" name="filterForm" role="form">
    <div class="form-group col-xs-10">
        <select name="filter" onchange="document.filterForm.submit();" class="form-control" >
            <option value="0" selected>--<fmt:message key="choose_order" bundle="${content}"/>--</option>
            <c:forEach var="order" items="${data.filterList}">
                <c:choose>
                    <c:when test="${order.id==data.filter}">
                        <option value="${order.id}" selected>${order.number} (${order.name} - ${order.probesQuantity})</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${order.id}">${order.number} (${order.name} - ${order.probesQuantity})</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
        <br />
        <c:if test="${empty data.data}">
            <button type="submit" class="btn btn-primary  btn-md" name="action" value ="add"><fmt:message key="create" bundle="${content}"/></button>
        </c:if>
        <input type="hidden" name="option" value ="probe">
        <input type="hidden" name="filter" value ="${data.filter}">
    </div>
</form>
</div>
<c:choose>
    <c:when test="${empty data.data}">
        <div class="alert alert-info">
            <fmt:message key="probe_not_found" bundle="${content}"/>
        </div>
    </c:when>
    <c:otherwise>
        <table id="advancedTable" class="table table-striped table-hover table-condensed">
            <thead>
                <tr>
                    <th>№</th>
                    <th><fmt:message key="order_number" bundle="${content}"/></th>
                    <th><fmt:message key="probe_number_laboratory" bundle="${content}"/></th>
                    <th><fmt:message key="probe_number_customer" bundle="${content}"/></th>
                    <th><fmt:message key="date_receiving" bundle="${content}"/></th>
                    <th><fmt:message key="point_sampling" bundle="${content}"/></th>
                    <th><fmt:message key="date_sampling" bundle="${content}"/></th>
                    <th><fmt:message key="remark" bundle="${content}"/></th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="probe" items="${data.data}">
                <tr class="serial">
                    <td></td>
                    <td>${probe.number}</td>
                    <td>${probe.numberLab}</td>
                    <td>${probe.numberCustomer}</td>
                    <td><fmt:formatDate dateStyle = "short" value = "${probe.dateReceiving}" /></td>
                    <td>${probe.pointSampling}</td>
                    <td><fmt:formatDate dateStyle = "short" value = "${probe.dateSampling}" /></td>
                    <td>${probe.remark}</td>
                    <td width="30"><a href="/probe/edit.html?option=probe&action=edit&recordId=${probe.id}&filter=${data.filter}"
                     title="<fmt:message key='edit' bundle='${content}'/>"><span class="fa fa-pencil"/></a></td>
                    <td width="30"><a href="/probe/form.html?option=probe&action=delete&recordId=${probe.id}&filter=${data.filter}"
                     title="<fmt:message key='delete' bundle='${content}'/>"><span class="fa fa-trash-o"/></a></td>
                </tr>
            </c:forEach>
            </tbody>
            <tfooter>
              <tr>
                  <td></td>
                  <td colspan="8"></td>
                  <td><a href="/probe/edit.html?option=probe&action=add&filter=${data.filter}"><i class="fa fa-plus" title="<fmt:message key='create' bundle='${content}'/>"></i></a></td>
              </tr>
            <tfooter>
        </table>
    </c:otherwise>
</c:choose>
<t:footer />
