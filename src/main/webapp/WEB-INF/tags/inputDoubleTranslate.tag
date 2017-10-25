<%@ tag body-content="empty"%>
<%@ attribute name="label" required="true"%>
<%@ attribute name="name" required="true"%>
<%@ attribute name="value" required="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="analysis" var="analysis"/>
<div class="form-group">
   <label for="${name}" class="col-sm-2 control-label"><fmt:message key="${label}" bundle="${analysis}"/></label>
   <div class="col-sm-2">
       <input type="number" step="any" name="${name}" id="${name}" class="form-control" min="0" value="${value}"/>
   </div>
</div>
