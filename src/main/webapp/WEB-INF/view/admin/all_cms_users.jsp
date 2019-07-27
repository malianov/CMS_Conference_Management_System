<div id="all-cms-users" class="w3-container w3-border menu w3-white">

    <h2>these-are-all-cms-users</h2>
    <div class="w3-container w3-margin">
        <table class="w3-table-all w3-centered w3-hoverable w3-card-4">
            <thead>
            <tr class="w3-light-blue">
                <th>user-id</th>
                <th>user-login</th>
                <th>user-name</th>
                <th>user-surname</th>
                <th>user-email</th>
                <th>user-status</th>
                <th>user-activity-status</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${users}" var="all_users_list">
                <c:choose>
                    <c:when test="${all_users_list.getIsActive() == 0}">
                        <tr class="w3-black">
                    </c:when>
                </c:choose>
                <td>
                        ${all_users_list.getId()}
                </td>
                <td>
                        ${all_users_list.getLogin()}
                </td>
                <td>
                        ${all_users_list.getName()}
                </td>
                <td>
                        ${all_users_list.getSurname()}
                </td>
                <td>
                        ${all_users_list.getEmail()}
                </td>
                <td>
                    <c:choose>
                        <c:when test="${all_users_list.getRole() == 0}">administrator</c:when>
                        <c:when test="${all_users_list.getRole() == 1}">moderator</c:when>
                        <c:when test="${all_users_list.getRole() == 2}">speaker</c:when>
                        <c:when test="${all_users_list.getRole() == 3}">participant</c:when>
                        <c:otherwise>status-incorrect</c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${(all_users_list.getIsActive() == 1)}">active</c:when>
                        <c:when test="${(all_users_list.getIsActive() == 0)}">not-active</c:when>
                        <c:otherwise>status-incorrect</c:otherwise>
                    </c:choose>
                </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <div class="w3-center">
            <div class="w3-bar w3-border w3-round">
                <a href="${pageContext.request.contextPath}/view/admin_all_users_page" class="w3-bar-item w3-button w3-hover-blue">&laquo;</a>
                <a href="${pageContext.request.contextPath}/view/admin_all_users_page" class="w3-bar-item w3-button w3-hover-blue">1</a>
                <a href="${pageContext.request.contextPath}/view/admin_all_users_page" class="w3-bar-item w3-button w3-hover-blue">2</a>
                <a href="${pageContext.request.contextPath}/view/admin_all_users_page" class="w3-bar-item w3-button w3-hover-blue">3</a>
                <a href="${pageContext.request.contextPath}/view/admin_all_users_page" class="w3-bar-item w3-button w3-hover-blue">4</a>
                <a href="${pageContext.request.contextPath}/view/admin_all_users_page" class="w3-bar-item w3-button w3-hover-blue">&raquo;</a>
            </div>
        </div>

    </div>
</div>
