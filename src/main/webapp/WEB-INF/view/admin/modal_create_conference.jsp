<div class="w3-dropdown-hover tablink w3-right">
    <button onclick="document.getElementById('id71').style.display='block'"
            class="w3-button w3-border w3-round w3-light-blue">
        <fmt:message key="create-conference"/></button>

    <div id="id71" class="w3-modal w3-large">
        <div class="w3-modal-content">
            <header class="w3-container w3-teal">
                            <span onclick="document.getElementById('id71').style.display='none'"
                                  class="w3-display-topright">&times;</span>
                <h2>create-panel</h2>
            </header>
            <div class="w3-container">
                <form class="w3-light-grey w3-padding"
                      action="${pageContext.request.contextPath}/view/create_conference">
                    <p>you-can-create-a-new-conference</p>
                    <div>
                        <div class="w3-margin">
                            <table class="w3-table-all w3-centered w3-card-4">
                                <thead>
                                <tr class="w3-light-blue">
                                    <th>start-date</th>
                                    <th>end-date</th>
                                    <th>title-eng</th>
                                    <th>title-ukr</th>
                                </tr>
                                </thead>

                                <tbody>

                                <tr>
                                    <%--<input type="hidden" name="page" value="${currentPage}">--%>
                                    <td>
                                         <input class="w3-input w3-border" type="date" name="start_date">
                                    </td>
                                    <td>
                                        <input class="w3-input w3-border" type="date" name="end_date">
                                    </td>
                                    <td>
                                        <input class="w3-input w3-border" type="text" name="title_eng">
                                    </td>
                                    <td>
                                        <input class="w3-input w3-border" type="text" name="title_ukr">
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        <br>
                            <table class="w3-table-all w3-centered w3-card-4">
                                <thead>
                                <tr class="w3-light-blue">
                                    <th>city-eng</th>
                                    <th>city-ukr</th>
                                    <th>place-eng</th>
                                    <th>place-ukr</th>
                                </tr>
                                </thead>

                                <tbody>

                                <tr>
                                    <%--<input type="hidden" name="page" value="${currentPage}">--%>
                                    <td>
                                        <input class="w3-input w3-border" type="text" name="city_eng">
                                    </td>
                                    <td>
                                        <input class="w3-input w3-border" type="text" name="city_ukr">
                                    </td>
                                    <td>
                                        <input class="w3-input w3-border" type="text" name="place_eng">
                                    </td>
                                    <td>
                                        <input class="w3-input w3-border" type="text" name="place_ukr">
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <br>
                    <div class="w3-center">
                        <button class="w3-btn w3-round-large w3-green w3-hover-red w3-margin-bottom">submit</button>
                        <input class="w3-btn w3-round-large w3-blue w3-hover-red w3-margin-bottom" type="reset" value="reset">
                    </div>
                </form>
            </div>
            <footer class="w3-container w3-teal"><p>igor-malianov-2019</p></footer>
        </div>
    </div>
</div>
