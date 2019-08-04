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
                <td>${all_users_list.getId_user()}</td>
                <td>${all_users_list.getLogin()}</td>
                <td>${all_users_list.getName()}</td>
                <td>${all_users_list.getSurname()}</td>
                <td>${all_users_list.getEmail()}</td>
                <td>${all_users_list.getRole()}</td>
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


            <div class="w3-dropdown-hover tablink w3-right">
                <button onclick="document.getElementById('id01').style.display='block'" class="w3-button w3-border w3-round w3-light-blue">
                    <fmt:message key="search"/></button>

                <div id="id01" class="w3-modal w3-large">
                    <div class="w3-modal-content">
                        <header class="w3-container w3-teal">
                            <span onclick="document.getElementById('id01').style.display='none'" class="w3-display-topright">&times;</span>
                            <h2>search-panel</h2>
                        </header>
                        <div class="w3-container">
                            <form class="w3-light-grey w3-padding" action="${pageContext.request.contextPath}/view/all_users_page?currentPage=${currentPage}">
                                <p>you-can-find-a-list-users-based-on-any-criteria-or-its-combination</p>
                                <div>
                                    <div class="w3-margin">
                                        <table class="w3-table-all w3-centered w3-card-4">
                                            <thead>
                                            <tr class="w3-light-blue">
                                                <th>user-id</th>
                                                <th>login</th>
                                                <th>user-name</th>
                                                <th>user-surname</th>
                                                <th>user-email</th>
                                            </tr>
                                            </thead>

                                            <tbody>

                                            <tr>
                                                <td><input class="w3-input w3-border" type="text" name="search_user_id"></td>
                                                <td><input class="w3-input w3-border" type="text" name="search_user_login"></td>
                                                <td><input class="w3-input w3-border" type="text" name="search_user_name"></td>
                                                <td><input class="w3-input w3-border" type="text" name="search_user_surname"></td>
                                                <td><input class="w3-input w3-border" type="text" name="search_user_email">
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div>
                                        <div class="w3-half w3-row-padding">
                                            <input class="w3-check" type="checkbox" checked="checked" name="search_administrator" value="search_administrator"><label>administrator</label>
                                            <input class="w3-check" type="checkbox" checked="checked" name="search_moderator" value="search_moderator"><label>moderator</label>
                                            <input class="w3-check" type="checkbox" checked="checked" name="search_speaker" value="search_speaker"><label>speaker</label>
                                            <input class="w3-check" type="checkbox" checked="checked" name="search_participant" value="search_participant"><label>participant</label>
                                        </div>
                                        <div class="w3-half w3-row-padding">
                                            <input class="w3-check" type="checkbox" checked="checked" name="search_active" value="search_active"><label>active</label>
                                            <input class="w3-check" type="checkbox" checked="checked" name="search_deactivated" value="search_deactivated"><label>deactivated</label>
                                        </div>
                                    </div>
                                </div>
                                <br>
                                <div class="w3-center">
                                    <button class="w3-btn w3-round-large w3-green w3-hover-red w3-margin-bottom"/>submit</button>
                                    <input class="w3-btn w3-round-large w3-blue w3-hover-red w3-margin-bottom" type="reset" value="reset">
                                </div>
                            </form>
                        </div>
                        <footer class="w3-container w3-teal"><p>igor-malianov-2019</p></footer>
                    </div>
                </div>
            </div>
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
<%--<div class="w3-tag w3-round w3-green" style="padding:3px">
    <div class="w3-tag w3-round w3-green w3-border w3-border-white">
        Falcon Ridge Parkway
    </div>
</div>--%>
