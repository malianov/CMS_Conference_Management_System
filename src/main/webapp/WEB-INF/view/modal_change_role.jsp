<button onclick="document.getElementById('${all_users_list.getIdUser()}').style.display='block'"
        class="w3-green w3-border-0 w3-round-xxlarge">${all_users_list.getRole()}</button>
<div id="${all_users_list.getIdUser()}" class="w3-modal">
    <div class="w3-modal-content w3-animate-top w3-card-4">
        <header class="w3-container w3-red">
            <span onclick="document.getElementById('${all_users_list.getIdUser()}').style.display='none'"
                  class="w3-button w3-large w3-red w3-display-topright">&times;</span>
            <h2>change-user-role</h2>
        </header>

        <div class="w3-container w3-left-align">
            <p>dear-admin!</p>
            <p>be-sure-you-are-doing-the-right-thing.</p>
            <p>
                you-are-going-to-chang-the-current-role-for-user: ${all_users_list.getName()} ${all_users_list.getSurname()}</p>
            <p>now-his-role-is: ${all_users_list.getRole()}</p>

            <h3>make-your-choice-here:</h3>
        </div>

        <div class="w3-bar">

            <c:if test="${all_users_list.getRole() ne 'ADMIN'}">
                <form method="post" action="${pageContext.request.contextPath}/view/change_user_role">
                    <button class="w3-bar-item w3-button w3-red w3-border w3-border-white w3-round-large"
                            style="width:33.3%">make-as-admin
                        <input type="hidden" name="newRole" value="0">
                        <input type="hidden" name="userLogin" value="${all_users_list.getLogin()}">
                        <input type="hidden" name="page" value="${currentPage}">
                    </button>
                </form>
            </c:if>
            <c:if test="${all_users_list.getRole() ne 'MODERATOR'}">
                <form method="post" action="${pageContext.request.contextPath}/view/change_user_role">
                    <button class="w3-bar-item w3-button w3-blue w3-border w3-border-white w3-round-large"
                            style="width:33.3%">make-as-moderator
                        <input type="hidden" name="newRole" value="1">
                        <input type="hidden" name="userLogin" value="${all_users_list.getLogin()}">
                        <input type="hidden" name="page" value="${currentPage}">
                    </button>
                </form>
            </c:if>
            <c:if test="${all_users_list.getRole() ne 'SPEAKER'}">
                <form method="post" action="${pageContext.request.contextPath}/view/change_user_role">
                    <button class="w3-bar-item w3-button w3-green w3-border w3-border-white w3-round-large"
                            style="width:33.3%">make-as-speaker
                        <input type="hidden" name="newRole" value="2">
                        <input type="hidden" name="userLogin" value="${all_users_list.getLogin()}">
                        <input type="hidden" name="page" value="${currentPage}">
                    </button>
                </form>
            </c:if>
            <c:if test="${all_users_list.getRole() ne 'PARTICIPANT'}">
                <form method="post" action="${pageContext.request.contextPath}/view/change_user_role">
                    <button class="w3-bar-item w3-button w3-light-grey w3-border w3-border-white w3-round-large"
                            style="width:33.3%">make-as-participant
                        <input type="hidden" name="newRole" value="3">
                        <input type="hidden" name="userLogin" value="${all_users_list.getLogin()}">
                        <input type="hidden" name="currentPage" value="${currentPage}">
                        <input type="hidden" name="page" value="${currentPage}">
                    </button>
                </form>
            </c:if>

        </div>

    </div>
</div>