<c:if test="${all_users_list.getRole() eq 'ADMIN' || all_users_list.getRole() eq 'MODERATOR'}">
    <c:choose>
        <c:when test="${(all_users_list.getIsActive() == 1)}"><fmt:message key="active"/></c:when>
        <c:when test="${(all_users_list.getIsActive() == 0)}"><fmt:message key="not-active"/></c:when>
        <c:otherwise><fmt:message key="status-incorrect"/></c:otherwise>
    </c:choose>
</c:if>


<c:if test="${all_users_list.getRole() eq 'SPEAKER' || all_users_list.getRole() eq 'PARTICIPANT'}">
    <button onclick="document.getElementById('${all_users_list.getLogin()}').style.display='block'"
            class="w3-green w3-border-0 w3-round-xxlarge">
        <c:choose>
            <c:when test="${(all_users_list.getIsActive() == 1)}"><fmt:message key="active"/></c:when>
            <c:when test="${(all_users_list.getIsActive() == 0)}"><fmt:message key="not-active"/></c:when>
            <c:otherwise><fmt:message key="status-incorrect"/></c:otherwise>
        </c:choose>
    </button>
    <div id="${all_users_list.getLogin()}" class="w3-modal">
        <div class="w3-modal-content w3-animate-top w3-card-4">
            <header class="w3-container w3-red">
            <span onclick="document.getElementById('${all_users_list.getLogin()}').style.display='none'"
                  class="w3-button w3-large w3-red w3-display-topright">&times;</span>
                <h2><fmt:message key="change-user-activity-status"/></h2>
            </header>

            <div class="w3-container w3-left-align">
                <p><fmt:message key="dear-moderator"/></p>
                <p><fmt:message key="be-sure-you-are-doing-the-right-thing"/></p>
                <p>
                    <fmt:message key="you-are-going-to-chang-the-current-activity-status-for-user"/> ${all_users_list.getLogin()} ${all_users_list.getName()} ${all_users_list.getSurname()}</p>
                <p><fmt:message key="now-his-activity-status-is"/> ${all_users_list.getIsActive()}</p>

                <h3><fmt:message key="make-your-choice-here"/></h3>
            </div>

            <div class="w3-bar">
                <c:if test="${all_users_list.getIsActive() ne '1'}">
                    <form method="post" action="${pageContext.request.contextPath}/view/change_user_activity_status">
                        <button class="w3-bar-item w3-button w3-red w3-border w3-border-white w3-round-large"
                                style="width:33.3%"><fmt:message key="make-as-active"/>
                            <input type="hidden" name="newAcivityStatus" value="1">
                            <input type="hidden" name="userLogin" value="${all_users_list.getLogin()}">
                            <input type="hidden" name="page" value="${currentPage}">
                        </button>
                    </form>
                </c:if>
                <c:if test="${all_users_list.getIsActive() ne '0'}">
                    <form method="post" action="${pageContext.request.contextPath}/view/change_user_activity_status">
                        <button class="w3-bar-item w3-button w3-red w3-border w3-border-white w3-round-large"
                                style="width:33.3%"><fmt:message key="make-as-not-active"/>
                            <input type="hidden" name="newAcivityStatus" value="0">
                            <input type="hidden" name="userLogin" value="${all_users_list.getLogin()}">
                            <input type="hidden" name="page" value="${currentPage}">
                        </button>
                    </form>
                </c:if>
            </div>
        </div>
    </div>
</c:if>