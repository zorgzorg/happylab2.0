<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="content" var="content"/>
<fmt:setBundle basename="analysis" var="analysis"/>

<t:header />
<h2><fmt:message key="semiquantitative_spectral_analysis" bundle="${analysis}"/></h2>
<form action="/ssa/form.html" method="post" role="form" data-toggle="validator" class="form-horizontal">
<div class="form-group">
        <label for="probeId" class="col-sm-2 control-label"><fmt:message key="probeId" bundle="${analysis}"/></label>
        <div class="col-sm-2">
            <select name="probeId" id="probeId" class="form-control" required>
                <option value="">--<fmt:message key="choose_probe" bundle="${analysis}"/>--</option>
                <c:forEach var="probe" items="${data.filterList[0]}">
                    <c:choose>
                      <c:when test="${probe.id==data.probeId}">
                          <option value="${probe.id}" selected>${probe.numberLab}</option>
                      </c:when>
                      <c:otherwise>
                          <option value="${probe.id}">${probe.numberLab}</option>
                      </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label for="date" class="col-sm-2 control-label"><fmt:message key="date" bundle="${analysis}"/></label>
        <div class="col-sm-2">
           <fmt:formatDate var="dateFmt" dateStyle = "short" value = "${data.date}"/>
           <input type="text" name="date" id="date" class="form-control" value="${dateFmt}"
           placeholder="<fmt:message key='date_placeholder' bundle='${content}'/>" required/>
        </div>
    </div>
    <div class="form-group">
        <label for="employeeId" class="col-sm-2 control-label"><fmt:message key="employeeId" bundle="${analysis}"/></label>
        <div class="col-sm-2">
            <select name="employeeId" id="employeeId" class="form-control" required>
              <option value="">--<fmt:message key="choose_assistant" bundle="${analysis}"/>--</option>
              <c:forEach var="employee" items="${data.filterList[1]}">
              <c:choose>
                  <c:when test="${employee.id==data.employeeId}">
                      <option value="${employee.id}" selected>${employee.lastname}</option>
                  </c:when>
                  <c:otherwise>
                  <option value="${employee.id}">${employee.lastname}</option>
              </c:otherwise>
          </c:choose>
          </c:forEach>
          </select>
          </div>
    </div>
    <t:inputDouble label="Ag" name="Ag" value="${data.silver}" />
    <t:inputDouble label="Al" name="Al" value="${data.aluminium}" />
    <t:inputDouble label="As" name="As" value="${data.arsenic}" />
    <t:inputDouble label="Au" name="Au" value="${data.gold}" />
    <t:inputDouble label="B" name="B" value="${data.boron}" />
    <t:inputDouble label="Ba" name="Ba" value="${data.barium}" />
    <t:inputDouble label="Be" name="Be" value="${data.beryllium}" />
    <t:inputDouble label="Bi" name="Bi" value="${data.bismuth}" />
    <t:inputDouble label="Cd" name="Cd" value="${data.cadmium}" />
    <t:inputDouble label="Ce" name="Ce" value="${data.cerium}" />
    <t:inputDouble label="Co" name="Co" value="${data.cobalt}" />
    <t:inputDouble label="Cr" name="Cr" value="${data.chromium}" />
    <t:inputDouble label="Cu" name="Cu" value="${data.copper}" />
    <t:inputDouble label="Fe" name="Fe" value="${data.iron}" />
    <t:inputDouble label="Ga" name="Ga" value="${data.gallium}" />
    <t:inputDouble label="Ge" name="Ge" value="${data.germanium}" />
    <t:inputDouble label="Hf" name="Hf" value="${data.hafnium}" />
    <t:inputDouble label="In" name="In" value="${data.indium}" />
    <t:inputDouble label="La" name="La" value="${data.lanthanum}" />
    <t:inputDouble label="Li" name="Li" value="${data.lithium}" />
    <t:inputDouble label="Mn" name="Mn" value="${data.manganese}" />
    <t:inputDouble label="Mo" name="Mo" value="${data.molybdenum}" />
    <t:inputDouble label="Nb" name="Nb" value="${data.niobium}" />
    <t:inputDouble label="Ni" name="Ni" value="${data.nickel}" />
    <t:inputDouble label="P" name="P" value="${data.phosphorus}" />
    <t:inputDouble label="Pb" name="Pb" value="${data.lead}" />
    <t:inputDouble label="Pt" name="Pt" value="${data.platinum}" />
    <t:inputDouble label="Sb" name="Sb" value="${data.antimony}" />
    <t:inputDouble label="Sc" name="Sc" value="${data.scandium}" />
    <t:inputDouble label="Sn" name="Sn" value="${data.tin}" />
    <t:inputDouble label="Sr" name="Sr" value="${data.strontium}" />
    <t:inputDouble label="Ta" name="Ta" value="${data.tantalum}" />
    <t:inputDouble label="Te" name="Te" value="${data.tellurium}" />
    <t:inputDouble label="Th" name="Th" value="${data.thorium}" />
    <t:inputDouble label="Ti" name="Ti" value="${data.titanium}" />
    <t:inputDouble label="Tl" name="Tl" value="${data.thallium}" />
    <t:inputDouble label="U" name="U" value="${data.uranium}" />
    <t:inputDouble label="V" name="V" value="${data.vanadium}" />
    <t:inputDouble label="W" name="W" value="${data.tungsten}" />
    <t:inputDouble label="Y" name="Y" value="${data.yttrium}" />
    <t:inputDouble label="Yb" name="Yb" value="${data.ytterbium}" />
    <t:inputDouble label="Zn" name="Zn" value="${data.zinc}" />
    <t:inputDouble label="Zr" name="Zr" value="${data.zirconium}" />
    </br>
    <t:buttonApplySaveCancel />
    <input type="hidden" name="recordId" value="${data.id}"/>
    <input type="hidden" name="option" value ="ssa">
</form>
<t:footer />