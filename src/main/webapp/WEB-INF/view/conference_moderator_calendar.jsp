<div id="conference-calendar-moderator" class="w3-container w3-border menu w3-white">
    <h2>conference-calendar-moderator (show registered)</h2>
    <div class="w3-container w3-margin">
        <table class="w3-table-all w3-centered">
            <thead>
            <tr class="w3-light-blue">
                <th>conference-id</th>
                <th>conference-start-date</th>
                <th>conference-end-date</th>
                <th>conference-title</th>
                <th>conference-city</th>
                <th>conference-place</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${conferences}" var="all_conferences_list">
                <tr>
                    <td>${all_conferences_list.getIdConference()}</td>

                    <td><%@ include file="modal_change_start_date.jsp"%></td>
                    <td><%@ include file="modal_change_end_date.jsp"%></td>

                    <c:if test="${language == 'en' or 'en-EN'}">
                        <td>${all_conferences_list.getConferenceTitleEng()}</td>
                        <td>${all_conferences_list.getConferenceCityEng()}</td>
                        <td>${all_conferences_list.getConferencePlaceEng()}</td>
                    </c:if>
                    <c:if test="${language == 'uk-UA'}">
                        <td>${all_conferences_list.getConferenceTitleUkr()}</td>
                        <td>${all_conferences_list.getConferenceCityUkr()}</td>
                        <td>${all_conferences_list.getConferencePlaceUkr()}</td>
                    </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="w3-center">
        <div class="w3-bar w3-border w3-round w3-light-blue">
            <c:if test="${currentPage != 1}">
                <a href="${pageContext.request.contextPath}/view/calendar_page?currentPage=${currentPage - 1}"
                   class="w3-bar-item w3-button w3-hover-blue">&laquo;</a>
            </c:if>
            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <a href="${pageContext.request.contextPath}/view/calendar_page?currentPage=${i}"
                           class="w3-bar-item w3-button w3-red">${i}</a>
                    </c:when>
                    <c:otherwise>
                        <a href="${pageContext.request.contextPath}/view/calendar_page?currentPage=${i}"
                           class="w3-bar-item w3-button w3-hover-blue">${i}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:if test="${currentPage lt noOfPages}">
                <a href="${pageContext.request.contextPath}/view/calendar_page?currentPage=${currentPage + 1}"
                   class="w3-bar-item w3-button w3-hover-blue">&raquo;</a>
            </c:if>

        </div>
        <%@ include file="modal_create_conference.jsp" %>
    </div>
</div>