<button onclick="document.getElementById('${seminar.getIdGlobalSeminar()}day').style.display='block'"
        class="w3-green w3-border-0 w3-round-xxlarge">

    ${seminar.getDayConference()}

</button>
<div id="${seminar.getIdGlobalSeminar()}day" class="w3-modal">
    <div class="w3-modal-content w3-animate-top w3-card-4">
        <header class="w3-container w3-red">
            <span onclick="document.getElementById('${seminar.getIdGlobalSeminar()}day').style.display='none'"
                  class="w3-button w3-large w3-red w3-display-topright">&times;</span>
            <h2><fmt:message key="change-seminar-day"/></h2>
        </header>

        <div class="w3-container w3-left-align">
            <p><fmt:message key="dear-moderator"/></p>
            <p><fmt:message key="be-sure-you-are-doing-the-right-thing"/></p>
            <p>
                <fmt:message key="you-are-going-to-change-the-current-seminar-day"/>
                ${seminar.getDayConference()}
            </p>

            <h3><fmt:message key="make-your-choice-here"/></h3>
            <form action="${pageContext.request.contextPath}/view/change_seminar_day">
                <label class="w3-text-grey"><b><fmt:message key="seminar-day"/></b></label>
                <%--<input class="w3-input w3-border w3-margin-bottom" type="text" name="seminar_day">--%>

                <select name="seminar_day">

                    <%--request.getSession().getAttribute("conferenceDaysQty")--%>
                    <c:forEach var = "i" begin = "1" end = "${conferenceDaysQty}">
                 <%--   Item <c:out value = "${i}"/><p>
                    </c:forEach>--%>

                    <option class="w3-input w3-border w3-margin-bottom" type="text" value="<c:out value = "${i}"/>"><c:out value = "${i}"/></option>
                        </c:forEach>
                </select>



                <input type="hidden" name="seminar_id" value="${seminar.getIdGlobalSeminar()}">

                <div class="w3-center">
                    <button class="w3-btn w3-round-large w3-green w3-hover-red w3-margin-bottom"><fmt:message key="submit"/></button>
                </div>
            </form>
        </div>
    </div>
</div>