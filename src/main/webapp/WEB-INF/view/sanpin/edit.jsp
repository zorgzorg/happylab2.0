<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="content" var="content"/>
<fmt:setBundle basename="analysis" var="analysis"/>

<t:header />
<h2><fmt:message key="SANPIN" bundle="${analysis}"/></h2>
<form action="/sanpin/form.html" method="post" role="form" data-toggle="validator" class="form-horizontal">
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
    <t:inputDouble label="Ag" name="Ag" value="${data.aluminium}" />
    <t:inputDouble label="Al" name="Al" value="${data.silver}" />
    <t:inputDouble label="As" name="As" value="${data.arsenic}" />
    <t:inputDouble label="B" name="B" value="${data.boron}" />
    <t:inputDouble label="Ba" name="Ba" value="${data.barium}" />
    <t:inputDouble label="Be" name="Be" value="${data.beryllium}" />
    <t:inputDouble label="Bi" name="Bi" value="${data.bismuth}" />
    <t:inputDouble label="Cd" name="Cd" value="${data.cadmium}" />
    <t:inputDouble label="Co" name="Co" value="${data.cobalt}" />
    <t:inputDouble label="Cr6" name="Cr6" value="${data.chromium6}" />
    <t:inputDouble label="Cr" name="Cr" value="${data.chromium}" />
    <t:inputDouble label="Cu" name="Cu" value="${data.copper}" />
    <t:inputDouble label="Fe" name="Fe" value="${data.iron}" />
    <t:inputDouble label="Li" name="Li" value="${data.lithium}" />
    <t:inputDouble label="Mn" name="Mn" value="${data.manganese}" />
    <t:inputDouble label="Mo" name="Mo" value="${data.molybdenum}" />
    <t:inputDouble label="Nb" name="Nb" value="${data.niobium}" />
    <t:inputDouble label="Na+Ka" name="Na+Ka" value="${data.sodiumK}" />
    <t:inputDouble label="Ni" name="Ni" value="${data.nickel}" />
    <t:inputDouble label="NH3" name="NH3" value="${data.ammonia}" />
    <t:inputDouble label="NO2" name="NO2" value="${data.nitrite}" />
    <t:inputDouble label="Pb" name="Pb" value="${data.lead}" />
    <t:inputDouble label="Sb" name="Sb" value="${data.antimony}" />
    <t:inputDouble label="Se" name="Se" value="${data.selenium}" />
    <t:inputDouble label="SiAcid" name="SiAcid" value="${data.siliconAcid}" />
    <t:inputDouble label="Si" name="Si" value="${data.silicon}" />
    <t:inputDouble label="Sr" name="Sr" value="${data.strontium}" />
    <t:inputDouble label="Te" name="Te" value="${data.tellurium}" />
    <t:inputDouble label="Rodanide" name="Rodanide" value="${data.rodanideIon}" />
    <t:inputDouble label="Tl" name="Tl" value="${data.thallium}" />
    <t:inputDouble label="V" name="V" value="${data.vanadium}" />
    <t:inputDouble label="W" name="W" value="${data.tungsten}" />
    <t:inputDouble label="Zn" name="Zn" value="${data.zinc}" />
    <t:inputDoubleTranslate label="odour" name="odour" value="${data.odour}" />
    <t:inputDoubleTranslate label="flavor" name="flavor" value="${data.flavor}" />
    <t:inputDoubleTranslate label="chromaticity" name="chromaticity" value="${data.chromaticity}" />
    <t:inputDoubleTranslate label="turbidity" name="turbidity" value="${data.turbidity}" />
    <t:inputDoubleTranslate label="hydrogenIndex" name="hydrogenIndex" value="${data.hydrogenIndex}" />
    <t:inputDoubleTranslate label="mineralization" name="mineralization" value="${data.mineralization}" />
    <t:inputDoubleTranslate label="dryResidue" name="dryResidue" value="${data.dryResidue}" />
    <t:inputDoubleTranslate label="anion" name="anion" value="${data.anion}" />
    <t:inputDoubleTranslate label="stiffness" name="stiffness" value="${data.stiffness}" />
    <t:inputDoubleTranslate label="oilProduct" name="oilProduct" value="${data.oilProduct}" />
    <t:inputDoubleTranslate label="nitrate" name="nitrate" value="${data.nitrate}" />
    <t:inputDoubleTranslate label="permaganate" name="permaganate" value="${data.permaganate}" />
    <t:inputDoubleTranslate label="mercury" name="mercury" value="${data.mercury}" />
    <t:inputDoubleTranslate label="sulfate" name="sulfate" value="${data.sulfate}" />
    <t:inputDoubleTranslate label="fluoride" name="fluoride" value="${data.fluoride}" />
    <t:inputDoubleTranslate label="phenolicIndex" name="phenolicIndex" value="${data.phenolicIndex}" />
    <t:inputDoubleTranslate label="chloride" name="chloride" value="${data.chloride}" />
    <t:inputDoubleTranslate label="cyanide" name="cyanide" value="${data.cyanide}" />
    <t:inputDoubleTranslate label="dissolvedOxygen" name="dissolvedOxygen" value="${data.dissolvedOxygen}" />
    <t:inputDoubleTranslate label="biologicalOxygenDemand" name="biologicalOxygenDemand" value="${data.biologicalOxygenDemand}" />
    <t:inputDoubleTranslate label="chemicalOxygenDemand" name="chemicalOxygenDemand" value="${data.chemicalOxygenDemand}" />
    <t:inputDoubleTranslate label="suspendedSolid" name="suspendedSolid" value="${data.suspendedSolid}" />
    <t:inputDoubleTranslate label="pesticideLindane" name="pesticideLindane" value="${data.pesticideLindane}" />
    <t:inputDoubleTranslate label="pesticideIsomer" name="pesticideIsomer" value="${data.pesticideIsomer}" />
    <t:inputDoubleTranslate label="radioactivityA" name="radioactivityA" value="${data.radioactivityA}" />
    <t:inputDoubleTranslate label="radioactivityB" name="radioactivityB" value="${data.radioactivityB}" />
    <t:inputDoubleTranslate label="polyphosphate" name="polyphosphate" value="${data.polyphosphate}" />
    <button class="btn btn-primary btn-md" type="submit" name="action" value="apply"><fmt:message key="apply" bundle="${content}"/></button>
    <button class="btn btn-primary btn-md" type="submit" name="action" value="save"><fmt:message key="save" bundle="${content}"/></button>
    <button class="btn btn-primary btn-md" type="reset"><fmt:message key="reset" bundle="${content}"/></button>
    <button class="btn btn-primary btn-md" type="cancel"><fmt:message key="cancel" bundle="${content}"/></button>
    <input type="hidden" name="recordId" value="${data.id}"/>
    <input type="hidden" name="option" value ="sanpin">
</form>
<t:footer />