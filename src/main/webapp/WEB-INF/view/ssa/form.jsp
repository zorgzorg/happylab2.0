<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="content" var="content"/>
<fmt:setBundle basename="analysis" var="analysis"/>

<t:header />
<h2><fmt:message key="semiquantitative_spectral_analysis" bundle="${analysis}"/></h2>
<t:message />
<c:choose>
    <c:when test="${empty data.data}">
        <t:createForm option="ssa" />
    </c:when>
    <c:otherwise>
        <c:set var = "code" scope = "page" value = "ssa"/>
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
                        <th>Au</th>
                        <th>B</th>
                        <th>Ba</th>
                        <th>Be</th>
                        <th>Bi</th>
                        <th>Cd</th>
                        <th>Ce</th>
                        <th>Co</th>
                        <th>Cr</th>
                        <th>Cu</th>
                        <th>Fe</th>
                        <th>Ga</th>
                        <th>Ge</th>
                        <th>Hf</th>
                        <th>In</th>
                        <th>La</th>
                        <th>Li</th>
                        <th>Mn</th>
                        <th>Mo</th>
                        <th>Nb</th>
                        <th>Ni</th>
                        <th>P</th>
                        <th>Pb</th>
                        <th>Pt</th>
                        <th>Sb</th>
                        <th>Sc</th>
                        <th>Sn</th>
                        <th>Sr</th>
                        <th>Ta</th>
                        <th>Te</th>
                        <th>Th</th>
                        <th>Ti</th>
                        <th>Tl</th>
                        <th>U</th>
                        <th>V</th>
                        <th>W</th>
                        <th>Y</th>
                        <th>Yb</th>
                        <th>Zn</th>
                        <th>Zr</th>
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
                        <td>${journal.gold}</td>
                        <td>${journal.boron}</td>
                        <td>${journal.barium}</td>
                        <td>${journal.beryllium}</td>
                        <td>${journal.bismuth}</td>
                        <td>${journal.cadmium}</td>
                        <td>${journal.cerium}</td>
                        <td>${journal.cobalt}</td>
                        <td>${journal.chromium}</td>
                        <td>${journal.copper}</td>
                        <td>${journal.iron}</td>
                        <td>${journal.gallium}</td>
                        <td>${journal.germanium}</td>
                        <td>${journal.hafnium}</td>
                        <td>${journal.indium}</td>
                        <td>${journal.lanthanum}</td>
                        <td>${journal.lithium}</td>
                        <td>${journal.manganese}</td>
                        <td>${journal.molybdenum}</td>
                        <td>${journal.niobium}</td>
                        <td>${journal.nickel}</td>
                        <td>${journal.phosphorus}</td>
                        <td>${journal.lead}</td>
                        <td>${journal.platinum}</td>
                        <td>${journal.antimony}</td>
                        <td>${journal.scandium}</td>
                        <td>${journal.tin}</td>
                        <td>${journal.strontium}</td>
                        <td>${journal.tantalum}</td>
                        <td>${journal.tellurium}</td>
                        <td>${journal.thorium}</td>
                        <td>${journal.titanium}</td>
                        <td>${journal.thallium}</td>
                        <td>${journal.uranium}</td>
                        <td>${journal.vanadium}</td>
                        <td>${journal.tungsten}</td>
                        <td>${journal.yttrium}</td>
                        <td>${journal.ytterbium}</td>
                        <td>${journal.zinc}</td>
                        <td>${journal.zirconium}</td>
                        <td width="30"><a href="/ssa/edit.html?option=ssa&action=edit&recordId=${journal.id}"
                         title="<fmt:message key='edit' bundle='${content}'/>"><span class="fa fa-pencil"/></a></td>
                        <td width="30"><a href="/report/form.html?option=report&&action=report&analysis=${code}&recordId=${journal.id}&probeId=${journal.probeId}"
                         title="<fmt:message key='make_report' bundle='${content}'/>"><span class="fa fa-print"/></a></td>
                        <td width="30"><a href="/ssa/form.html?option=ssa&action=delete&recordId=${journal.id}"
                         title="<fmt:message key='delete' bundle='${content}'/>"><span class="fa fa-trash-o"/></a></td>
                    </tr>
                </c:forEach>
                </tbody>
                <tfooter>
                    <tr>
                        <td></td>
                        <td colspan="48"></td>
                        <td><a href="/ssa/edit.html?option=ssa&action=add"><i class="fa fa-plus" title="<fmt:message key='create' bundle='${content}'/>"></i></a></td>
                    </tr>
                <tfooter>
            </table>
        </div>
    </c:otherwise>
</c:choose>
<t:footer />