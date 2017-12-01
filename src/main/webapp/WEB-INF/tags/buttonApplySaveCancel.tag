<%@ tag body-content="empty"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="content" var="content"/>
<button class="btn btn-primary btn-md" type="submit" name="action" value="apply"><fmt:message key="apply" bundle="${content}"/></button>
<button class="btn btn-primary btn-md" type="submit" name="action" value="save"><fmt:message key="save" bundle="${content}"/></button>
<button class="btn btn-primary btn-md" type="reset"><fmt:message key="reset" bundle="${content}"/></button>
<button class="btn btn-primary btn-md" type="cancel"><fmt:message key="cancel" bundle="${content}"/></button>
