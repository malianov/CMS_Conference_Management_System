<div class="w3-dropdown-hover tablink w3-right">
    <button onclick="document.getElementById('id0125').style.display='block'"
            class="w3-button w3-border w3-round w3-light-blue">
        <fmt:message key="search"/></button>

    <div id="id0125" class="w3-modal w3-large">
        <div class="w3-modal-content">
            <header class="w3-container w3-teal">
                            <span onclick="document.getElementById('id0125').style.display='none'"
                                  class="w3-display-topright">&times;</span>
                <h2>search-panel</h2>
            </header>
            <div class="w3-container">
                <form class="w3-light-grey w3-padding"
                      action="${pageContext.request.contextPath}/view/all_users_page">
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
                                    <input type="hidden" name="page" value="${currentPage}">
                                    <td>
                                        <input class="w3-input w3-border" type="text" name="search_user_id">
                                    </td>
                                    <td>
                                        <input class="w3-input w3-border" type="text" name="search_user_login">
                                    </td>
                                    <td>
                                        <input class="w3-input w3-border" type="text" name="search_user_name">
                                    </td>
                                    <td>
                                        <input class="w3-input w3-border" type="text" name="search_user_surname">
                                    </td>
                                    <td>
                                        <input class="w3-input w3-border" type="text" name="search_user_email">
                                    </td>
                                </tr>
                                </tbody>
                            </table>
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
