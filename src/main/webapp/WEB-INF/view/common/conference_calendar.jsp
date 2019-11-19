<div id="conference-calendar-moderator" class="w3-container w3-border menu w3-white">
    <h2><fmt:message key="conference-catalog"/></h2>
    <div class="w3-container w3-margin">
        <table class="w3-table-all w3-centered">
            <thead>
            <tr class="w3-light-blue">
                <th><fmt:message key="conference-id"/></th>
                <th><fmt:message key="start-conference-date"/></th>
                <th><fmt:message key="end-conference-date"/></th>
                <th><fmt:message key="conference-title"/></th>
                <th><fmt:message key="conference-city"/></th>
                <th><fmt:message key="conference-place"/></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${conferences}" var="all_conferences_list">
                <tr>
                    <td>${all_conferences_list.getIdConference()}</td>
                    <c:choose>
                        <c:when test="${sessionScope.role == 'ADMIN' || sessionScope.role == 'SPEAKER' || sessionScope.role == 'PARTICIPANT'}">
                            <td>${all_conferences_list.getStartDate()}</td>
                            <td>${all_conferences_list.getEndDate()}</td>
                        </c:when>
                        <c:when test="${sessionScope.role == 'MODERATOR'}">
                            <td>
                                <%@ include file="../moderator/modal_change_start_date.jsp" %>
                            </td>
                            <td>
                                <%@ include file="../moderator/modal_change_end_date.jsp" %>
                            </td>
                        </c:when>
                    </c:choose>

                    <c:if test="${language eq 'en' || language eq 'en-EN'}">
                        <c:choose>
                            <c:when test="${sessionScope.role == 'ADMIN'}">
                                <td>
                                    <%@ include file="../admin/modal_change_conference_title.jsp" %>
                                </td>
                            </c:when>
                            <c:when test="${sessionScope.role == 'MODERATOR'}">
                                <td>
                                    <form action="${pageContext.request.contextPath}/view/change_program">
                                        <button class="w3-button w3-green w3-round-large">${all_conferences_list.getConferenceTitleEng()}
                                            <input type="hidden" name="conference_change_id"
                                                   value="${all_conferences_list.getIdConference()}">
                                        </button>
                                    </form>
                                </td>
                            </c:when>
                            <c:when test="${sessionScope.role == 'SPEAKER'}">
                                <td>
                                    <form action="${pageContext.request.contextPath}/view/change_program">
                                        <button class="w3-button w3-green w3-round-large">${all_conferences_list.getConferenceTitleEng()}
                                            <input type="hidden" name="conference_change_id"
                                                   value="${all_conferences_list.getIdConference()}">
                                        </button>
                                    </form>
                                </td>
                            </c:when>
                            <c:when test="${sessionScope.role == 'PARTICIPANT'}">
                                <td>
                                    <form action="${pageContext.request.contextPath}/view/change_program">
                                        <button class="w3-button w3-green w3-round-large">${all_conferences_list.getConferenceTitleEng()}
                                            <input type="hidden" name="conference_change_id"
                                                   value="${all_conferences_list.getIdConference()}">
                                        </button>
                                    </form>
                                </td>
                            </c:when>
                        </c:choose>

                        <c:choose>
                            <c:when test="${sessionScope.role == 'ADMIN' || sessionScope.role == 'SPEAKER' || sessionScope.role == 'PARTICIPANT'}">
                                <td>${all_conferences_list.getConferenceCityEng()}</td>
                                <td>${all_conferences_list.getConferencePlaceEng()}</td>
                            </c:when>
                            <c:when test="${sessionScope.role == 'MODERATOR'}">
                                <td>
                                    <%@ include file="../moderator/modal_change_conference_city.jsp" %>
                                </td>
                                <td>
                                    <%@ include file="../moderator/modal_change_conference_place.jsp" %>
                                </td>
                            </c:when>
                        </c:choose>
                    </c:if>

                    <c:if test="${language eq 'uk-UA'}">
                        <c:choose>
                            <c:when test="${sessionScope.role == 'ADMIN'}">
                                <td>
                                    <%@ include file="../admin/modal_change_conference_title.jsp" %>
                                </td>
                            </c:when>
                            <c:when test="${sessionScope.role == 'MODERATOR'}">
                                <td>
                                    <form action="${pageContext.request.contextPath}/view/change_program">
                                        <button class="w3-button w3-red w3-round-large">${all_conferences_list.getConferenceTitleUkr()}
                                            <input type="hidden" name="conference_change_id"
                                                   value="${all_conferences_list.getIdConference()}">
                                        </button>
                                    </form>
                                </td>
                            </c:when>
                            <c:when test="${sessionScope.role == 'SPEAKER'}">
                                <td>
                                    <form action="${pageContext.request.contextPath}/view/view/change_program">
                                        <button class="w3-button w3-green w3-round-large">${all_conferences_list.getConferenceTitleUkr()}
                                            <input type="hidden" name="conference_change_id"
                                                   value="${all_conferences_list.getIdConference()}">
                                        </button>
                                    </form>
                                </td>
                            </c:when>
                            <c:when test="${sessionScope.role == 'PARTICIPANT'}">
                                <td>
                                    <form action="${pageContext.request.contextPath}/view/view/change_program">
                                        <button class="w3-button w3-green w3-round-large">${all_conferences_list.getConferenceTitleUkr()}
                                            <input type="hidden" name="conference_change_id"
                                                   value="${all_conferences_list.getIdConference()}">
                                        </button>
                                    </form>
                                </td>
                            </c:when>
                        </c:choose>
                        <c:choose>
                            <c:when test="${sessionScope.role == 'ADMIN' || sessionScope.role == 'SPEAKER' || sessionScope.role == 'PARTICIPANT'}">
                                <td>${all_conferences_list.getConferenceCityUkr()}</td>
                                <td>${all_conferences_list.getConferencePlaceUkr()}</td>
                            </c:when>
                            <c:when test="${sessionScope.role == 'MODERATOR'}">
                                <td>
                                    <%@ include file="../moderator/modal_change_conference_city.jsp" %>
                                </td>
                                <td>
                                    <%@ include file="../moderator/modal_change_conference_place.jsp" %>
                                </td>
                            </c:when>
                        </c:choose>
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

        <c:choose>
            <c:when test="${sessionScope.role == 'ADMIN'}">
                <%@ include file="../admin/modal_create_conference.jsp" %>
            </c:when>
        </c:choose>
    </div>
</div>