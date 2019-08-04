<button onclick="document.getElementById('${all_users_list.getId_user()}').style.display='block'"
        class="w3-green w3-border-0 w3-round-xxlarge">${all_users_list.getRole()}</button>
<div id="${all_users_list.getId_user()}" class="w3-modal">
    <div class="w3-modal-content w3-animate-top w3-card-4">
        <header class="w3-container w3-red">
            <span onclick="document.getElementById('${all_users_list.getId_user()}').style.display='none'"
                  class="w3-button w3-large w3-red w3-display-topright">&times;</span>
            <h2>change-user-role</h2>
        </header>
        <form  class="w3-container" method="post" action="${pageContext.request.contextPath}/view/all_users_page?currentPage=${currentPage}">
            <div class="w3-container w3-left-align">
                <p>dear-admin!</p>
                <p>be-sure-you-are-doing-the-right-thing.</p>
                <p>you-are-going-to-chang-the-current-role-for-user: ${all_users_list.getName()} ${all_users_list.getSurname()}</p>
                <p>now-his-role-is: ${all_users_list.getRole()}</p>

                <h3>make-your-choice-here:</h3>


                <c:if test="${all_users_list.getRole() ne 'ADMIN'}">
                    <input class="w3-radio" type="radio" name="user-status-change" value="administrator"><label>admin</label>
                </c:if>
                <c:if test="${all_users_list.getRole() ne 'MODERATOR'}">
                    <input class="w3-radio" type="radio" name="user-status-change" value="moderator"><label>moderator</label>
                </c:if>
                <c:if test="${all_users_list.getRole() ne 'SPEAKER'}">
                    <input class="w3-radio" type="radio" name="user-status-change" value="speaker"><label>speaker</label>
                </c:if>
                <c:if test="${all_users_list.getRole() ne 'PARTICIPANT'}">
                    <input class="w3-radio" type="radio" name="user-status-change" value="user"><label>participant</label>
                </c:if>


            </div>
            <footer class="w3-container w3-red w3-display-container w3-center">
                <p>please-confirm-your-choice <%--<span
                                            onclick="document.getElementById('${all_users_list.getId_user()}').style.display='none'"
                                            class="w3-button w3-light-blue w3-round-xxlarge w3-display-right" type="submit">confirm</span>--%>
                    <button class="w3-button w3-light-blue w3-round-xxlarge w3-display-right" type="submit">Confirm</button>
                </p>
            </footer>
        </form>
    </div>
</div>