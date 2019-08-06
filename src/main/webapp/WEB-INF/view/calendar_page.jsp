<%@ include file="header.jsp" %>

<div class="w3-container w3-padding w3-margin w3-display-container">
    <div class="w3-card-4">
        <div class="w3-container w3-center w3-green">
            <h2>
                <c:if test="${language == 'en'}"><c:out value=" ${user.getName()},"/></c:if>
                <c:if test="${language == 'en-EN'}"><c:out value=" ${user.getName()},"/></c:if>
                <c:if test="${language == 'uk-UA'}"><c:out value=" ${user.getName()},"/></c:if>
                <fmt:message key="welcome-to-the-system-CMS_admin"/></h2>
        </div>

        <div class="w3-bar w3-light-blue">
            <a href="${pageContext.request.contextPath}/view/main_page" class="w3-bar-item w3-button w3-hover-red"><fmt:message key="main-admin-page"/></a>
            <c:if test="${sessionScope.role != 'PARTICIPANT'}">
                <a href="${pageContext.request.contextPath}/view/all_users_page"
                   class="w3-bar-item w3-button w3-hover-red"><fmt:message key="all-users"/></a>
            </c:if>
            <a href="${pageContext.request.contextPath}/view/calendar_page" class="w3-bar-item w3-button w3-hover-red w3-green"><fmt:message key="conference-calendar"/></a>
            <a href="${pageContext.request.contextPath}/view/archive_page" class="w3-bar-item w3-button w3-hover-red"><fmt:message key="conference-archive"/></a>

            <button class="w3-bar-item w3-button tablink w3-right"
                    onclick="location.href='${pageContext.request.contextPath}/view/logout'"><fmt:message
                    key="logout"/></button>

            <div class="w3-dropdown-hover w3-right">
                <button class="w3-button"><fmt:message key="language"/></button>
                <div class="w3-dropdown-content w3-bar-block w3-card-4">
                    <a href="${pageContext.request.contextPath}/view/language/calendar_page?language=UA"
                       class="w3-bar-item w3-button"><fmt:message key="ukrainian"/></a>
                    <a href="${pageContext.request.contextPath}/view/language/calendar_page?language=EN"
                       class="w3-bar-item w3-button"><fmt:message key="english"/></a>
                </div>
            </div>

            <div class="w3-dropdown-hover tablink w3-right">
                <button class="w3-button"><fmt:message key="my-box(4)"/></button>
            </div>

        </div>

        <c:choose>
            <c:when test="${sessionScope.role == 'ADMIN'}">
                <%@ include file="conference_admin_calendar.jsp"%>
            </c:when>
            <c:when test="${sessionScope.role == 'MODERATOR'}">
                 <%@ include file="conference_moderator_calendar.jsp"%>
            </c:when>
            <c:when test="${sessionScope.role == 'SPEAKER'}">
                <%@ include file="conference_admin_calendar.jsp"%>
            </c:when>
            <c:when test="${sessionScope.role == 'PARTICIPANT'}">
                <%@ include file="conference_admin_calendar.jsp"%>
            </c:when>
        </c:choose>

    </div>
</div>


<footer class="<%--w3-bottom--%> w3-container w3-blue-grey w3-opacity w3-teal w3-bottom">
    <p>igor-malianov-2019</p>
</footer>


</body>
</html>