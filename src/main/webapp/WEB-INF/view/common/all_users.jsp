<div id="all-users" class="w3-container w3-border menu w3-white">
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
                <c:choose><c:when test="${all_users_list.getIsActive() == 0}"><tr class="w3-black"></c:when></c:choose>
                <td>${all_users_list.getIdUser()}</td>
                <td>${all_users_list.getLogin()}</td>
                <td>${all_users_list.getName()}</td>
                <td>${all_users_list.getSurname()}</td>
                <td>${all_users_list.getEmail()}</td>
                <td>
                    <c:choose>
                        <c:when test="${sessionScope.role == 'ADMIN'}">
                            <%@ include file="../admin/modal_change_role.jsp" %>
                        </c:when>
                        <c:when test="${sessionScope.role == 'MODERATOR'}">
                            <%@ include file="../moderator/modal_change_role.jsp" %>
                        </c:when>
                        <c:when test="${sessionScope.role == 'SPEAKER'||sessionScope.role == 'PARTICIPANT'}">
                            ${all_users_list.getRole()}
                        </c:when>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${sessionScope.role == 'ADMIN'}">
                            <%@ include file="modal_change_activity_status.jsp" %>
                        </c:when>
                        <c:when test="${sessionScope.role == 'MODERATOR'}">
                            <%@ include file="../moderator/modal_change_activity_status.jsp" %>
                        </c:when>
                        <c:when test="${sessionScope.role == 'SPEAKER'}">
                            <c:choose>
                                <c:when test="${(all_users_list.getIsActive() == 1)}">active</c:when>
                                <c:when test="${(all_users_list.getIsActive() == 0)}">not-active</c:when>
                                <c:otherwise>status-incorrect</c:otherwise>
                            </c:choose>
                        </c:when>
                    </c:choose>
                </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div>
        <div class="w3-center">
            <div class="w3-bar w3-border w3-round w3-light-blue">
                <c:if test="${currentPage != 1}">
                    <a href="${pageContext.request.contextPath}/view/all_users_page?currentPage=${currentPage - 1}"
                       class="w3-bar-item w3-button w3-hover-blue">&laquo;</a>
                </c:if>
                <c:forEach begin="1" end="${noOfPages}" var="i">
                    <c:choose>
                        <c:when test="${currentPage eq i}">
                            <a href="${pageContext.request.contextPath}/view/all_users_page?currentPage=${i}"
                               class="w3-bar-item w3-button w3-red">${i}</a>
                        </c:when>
                        <c:otherwise>
                            <a href="${pageContext.request.contextPath}/view/all_users_page?currentPage=${i}"
                               class="w3-bar-item w3-button w3-hover-blue">${i}</a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:if test="${currentPage lt noOfPages}">
                    <a href="${pageContext.request.contextPath}/view/all_users_page?currentPage=${currentPage + 1}"
                       class="w3-bar-item w3-button w3-hover-blue">&raquo;</a>
                </c:if>
            </div>
            <%@ include file="modal_search_users.jsp" %>
        </div>
    </div>
</div>

<script>
    function myFunction() {
        var x = document.getElementById("Demo");
        if (x.className.indexOf("w3-show") == -1) {
            x.className += " w3-show";
        } else {
            x.className = x.className.replace(" w3-show", "");
        }
    }
</script>