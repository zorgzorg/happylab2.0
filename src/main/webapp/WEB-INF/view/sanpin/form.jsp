<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="content" var="content"/>
<fmt:setBundle basename="analysis" var="analysis"/>

<t:header />
<h2><fmt:message key="SANPIN" bundle="${analysis}"/></h2>
<t:message />
<c:choose>
    <c:when test="${empty data.data}">
        <t:createForm option="sanpin" />
    </c:when>
    <c:otherwise>
        <c:set var = "code" scope = "page" value = "sanpin"/>
        <div class="table-responsive">
            <table id="advancedTable" class="table table-striped table-hover table-condensed">
                <thead>
                    <tr>
                        <th><fmt:message key="#" bundle="${content}"/></th>
                        <th><fmt:message key="numberLab" bundle="${analysis}"/></th>
                        <th><fmt:message key="assistant" bundle="${analysis}"/></th>
                        <th><fmt:message key="date" bundle="${analysis}"/></th>
                        <th>Ag</th>
                        <th>Al</th>
                        <th>As</th>
                        <th>B</th>
                        <th>Ba</th>
                        <th>Be</th>
                        <th>Bi</th>
                        <th>Cd</th>
                        <th>Co</th>
                        <th>Cr6</th>
                        <th>Cr</th>
                        <th>Cu</th>
                        <th>Fe</th>
                        <th>Li</th>
                        <th>Mn</th>
                        <th>Mo</th>
                        <th>Nb</th>
                        <th>Na+Ka</th>
                        <th>Ni</th>
                        <th>NH3</th>
                        <th>NO2</th>
                        <th>Pb</th>
                        <th>Sb</th>
                        <th>Se</th>
                        <th>SiAcid</th>
                        <th>Si</th>
                        <th>Sr</th>
                        <th>Te</th>
                        <th>Rodanide</th>
                        <th>Tl</th>
                        <th>V</th>
                        <th>W</th>
                        <th>Zn</th>
                        <th><fmt:message key="odour" bundle='${analysis}'/></th>
                        <th><fmt:message key="flavor" bundle='${analysis}'/></th>
                        <th><fmt:message key="chromaticity" bundle='${analysis}'/></th>
                        <th><fmt:message key="turbidity" bundle='${analysis}'/></th>
                        <th><fmt:message key="hydrogenIndex" bundle='${analysis}'/></th>
                        <th><fmt:message key="mineralization" bundle='${analysis}'/></th>
                        <th><fmt:message key="dryResidue" bundle='${analysis}'/></th>
                        <th><fmt:message key="anion" bundle='${analysis}'/></th>
                        <th><fmt:message key="stiffness" bundle='${analysis}'/></th>
                        <th><fmt:message key="oilProduct" bundle='${analysis}'/></th>
                        <th><fmt:message key="nitrate" bundle='${analysis}'/></th>
                        <th><fmt:message key="permaganate" bundle='${analysis}'/></th>
                        <th><fmt:message key="mercury" bundle='${analysis}'/></th>
                        <th><fmt:message key="sulfate" bundle='${analysis}'/></th>
                        <th><fmt:message key="fluoride" bundle='${analysis}'/></th>
                        <th><fmt:message key="phenolicIndex" bundle='${analysis}'/></th>
                        <th><fmt:message key="chloride" bundle='${analysis}'/></th>
                        <th><fmt:message key="cyanide" bundle='${analysis}'/></th>
                        <th><fmt:message key="dissolvedOxygen" bundle='${analysis}'/></th>
                        <th><fmt:message key="biologicalOxygenDemand" bundle='${analysis}'/></th>
                        <th><fmt:message key="chemicalOxygenDemand" bundle='${analysis}'/></th>
                        <th><fmt:message key="suspendedSolid" bundle='${analysis}'/></th>
                        <th><fmt:message key="pesticideLindane" bundle='${analysis}'/></th>
                        <th><fmt:message key="pesticideIsomer" bundle='${analysis}'/></th>
                        <th><fmt:message key="radioactivityA" bundle='${analysis}'/></th>
                        <th><fmt:message key="radioactivityB" bundle='${analysis}'/></th>
                        <th><fmt:message key="polyphosphate" bundle='${analysis}'/></th>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="journal" items="${data.data}">
                    <tr class="serial">
                        <td></td>
                        <td>${journal.numberLab}</td>
                        <td>${journal.assistant}</td>
                        <td><fmt:formatDate dateStyle = "short" value = "${journal.date}"/></td>
                        <td>${journal.silver}</td>
                        <td>${journal.aluminium}</td>
                        <td>${journal.arsenic}</td>
                        <td>${journal.boron}</td>
                        <td>${journal.barium}</td>
                        <td>${journal.beryllium}</td>
                        <td>${journal.bismuth}</td>
                        <td>${journal.cadmium}</td>
                        <td>${journal.cobalt}</td>
                        <td>${journal.chromium6}</td>
                        <td>${journal.chromium}</td>
                        <td>${journal.copper}</td>
                        <td>${journal.iron}</td>
                        <td>${journal.lithium}</td>
                        <td>${journal.manganese}</td>
                        <td>${journal.molybdenum}</td>
                        <td>${journal.niobium}</td>
                        <td>${journal.sodiumK}</td>
                        <td>${journal.nickel}</td>
                        <td>${journal.ammonia}</td>
                        <td>${journal.nitrite}</td>
                        <td>${journal.lead}</td>
                        <td>${journal.antimony}</td>
                        <td>${journal.selenium}</td>
                        <td>${journal.siliconAcid}</td>
                        <td>${journal.silicon}</td>
                        <td>${journal.strontium}</td>
                        <td>${journal.tellurium}</td>
                        <td>${journal.rodanideIon}</td>
                        <td>${journal.thallium}</td>
                        <td>${journal.vanadium}</td>
                        <td>${journal.tungsten}</td>
                        <td>${journal.zinc}</td>
                        <td>${journal.odour}</td>
                        <td>${journal.flavor}</td>
                        <td>${journal.chromaticity}</td>
                        <td>${journal.turbidity}</td>
                        <td>${journal.hydrogenIndex}</td>
                        <td>${journal.mineralization}</td>
                        <td>${journal.dryResidue}</td>
                        <td>${journal.anion}</td>
                        <td>${journal.stiffness}</td>
                        <td>${journal.oilProduct}</td>
                        <td>${journal.nitrate}</td>
                        <td>${journal.permaganate}</td>
                        <td>${journal.mercury}</td>
                        <td>${journal.sulfate}</td>
                        <td>${journal.fluoride}</td>
                        <td>${journal.phenolicIndex}</td>
                        <td>${journal.chloride}</td>
                        <td>${journal.cyanide}</td>
                        <td>${journal.dissolvedOxygen}</td>
                        <td>${journal.biologicalOxygenDemand}</td>
                        <td>${journal.chemicalOxygenDemand}</td>
                        <td>${journal.suspendedSolid}</td>
                        <td>${journal.pesticideLindane}</td>
                        <td>${journal.pesticideIsomer}</td>
                        <td>${journal.radioactivityA}</td>
                        <td>${journal.radioactivityB}</td>
                        <td>${journal.polyphosphate}</td>
                        <td width="30"><a href="/sanpin/edit.html?option=sanpin&action=edit&recordId=${journal.id}"
                        title="<fmt:message key='edit' bundle='${content}'/>"><span class="fa fa-pencil"/></a></td>
                        <td width="30"><a href="/report/form.html?option=report&action=report&analysis=${code}&recordId=${journal.id}&probeId=${journal.probeId}"
                        title="<fmt:message key='make_report' bundle='${content}'/>"><span class="fa fa-print"/></a></td>
                        <td width="30"><a href="/sanpin/form.html?option=sanpin&action=delete&recordId=${journal.id}"
                        title="<fmt:message key='delete' bundle='${content}'/>"><span class="fa fa-trash-o"/></a></td>
                    </tr>
                </c:forEach>
                </tbody>
                <tfooter>
                    <tr>
                        <td></td>
                        <td colspan="65"></td>
                        <td><a href="/sanpin/edit.html?option=sanpin&action=add"><i class="fa fa-plus" title="<fmt:message key='create' bundle='${content}'/>"></i></a></td>
                    </tr>
                <tfooter>
            </table>
        </div>
    </c:otherwise>
</c:choose>
<t:footer />