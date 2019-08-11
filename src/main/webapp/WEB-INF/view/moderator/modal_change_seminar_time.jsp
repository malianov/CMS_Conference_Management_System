<button onclick="document.getElementById('${seminar.getIdGlobalSeminar()}time').style.display='block'"
        class="w3-green w3-border-0 w3-round-xxlarge">

    ${seminar.getSeminarTime()}

</button>
<div id="${seminar.getIdGlobalSeminar()}time" class="w3-modal">
    <div class="w3-modal-content w3-animate-top w3-card-4">
        <header class="w3-container w3-red">
            <span onclick="document.getElementById('${seminar.getIdGlobalSeminar()}time').style.display='none'"
                  class="w3-button w3-large w3-red w3-display-topright">&times;</span>
            <h2><fmt:message key="change-seminar-time"/></h2>
        </header>

        <div class="w3-container w3-left-align">
            <p><fmt:message key="dear-moderator"/></p>
            <p><fmt:message key="be-sure-you-are-doing-the-right-thing"/></p>
            <p>
                <fmt:message key="you-are-going-to-chang-the-current-seminar-time"/>
                ${seminar.getSeminarTime()}
            </p>
            <p><fmt:message key="for-seminar"/>
                <c:if test="${language == 'en'|| language == 'en-EN'}">${seminar.getSeminarTitle_eng()}></c:if>
                <c:if test="${language == 'uk-UA'}">${seminar.getSeminarTitle_ukr()}</c:if>
            </p>


            <h3><fmt:message key="make-your-choice-here"/></h3>
            <form action="${pageContext.request.contextPath}/view/change_seminar_time">
                <label class="w3-text-grey"><b><fmt:message key="seminar-time"/></b></label>
                <%--<input class="w3-input w3-border w3-margin-bottom" type="text" name="seminar_time">--%>
                <select name="seminar_time">
                    <option class="w3-input w3-border w3-margin-bottom" type="text" value="08:00 - 08:45">08:00 - 08:45</option>
                    <option class="w3-input w3-border w3-margin-bottom" type="text" value="09:00 - 09:45">09:00 - 09:45</option>
                    <option class="w3-input w3-border w3-margin-bottom" type="text" value="10:00 - 10:45">10:00 - 10:45</option>
                    <option class="w3-input w3-border w3-margin-bottom" type="text" value="11:00 - 11:45">11:00 - 11:45</option>
                    <option class="w3-input w3-border w3-margin-bottom" type="text" value="12:00 - 12:45">12:00 - 12:45</option>
                    <option class="w3-input w3-border w3-margin-bottom" type="text" value="13:00 - 13:45">13:00 - 13:45</option>
                    <option class="w3-input w3-border w3-margin-bottom" type="text" value="14:00 - 14:45">14:00 - 14:45</option>
                    <option class="w3-input w3-border w3-margin-bottom" type="text" value="15:00 - 15:45">15:00 - 15:45</option>
                    <option class="w3-input w3-border w3-margin-bottom" type="text" value="16:00 - 16:45">16:00 - 16:45</option>
                    <option class="w3-input w3-border w3-margin-bottom" type="text" value="17:00 - 17:45">17:00 - 17:45</option>
                    <option class="w3-input w3-border w3-margin-bottom" type="text" value="18:00 - 18:45">18:00 - 18:45</option>
                    <option class="w3-input w3-border w3-margin-bottom" type="text" value="19:00 - 19:45">19:00 - 19:45</option>
                    <option class="w3-input w3-border w3-margin-bottom" type="text" value="20:00 - 20:45">20:00 - 20:45</option>
                </select>
                <input type="hidden" name="seminar_id" value="${seminar.getIdGlobalSeminar()}">

                <div class="w3-center">
                    <button class="w3-btn w3-round-large w3-green w3-hover-red w3-margin-bottom"><fmt:message key="submit"/></button>
                </div>
            </form>
        </div>

<%--        <div class="w3-bar">


        </div>--%>

    </div>
</div>