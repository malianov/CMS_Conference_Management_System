<div class="w3-container">
    <h2>conference-schedule-by-days</h2>

    <%--    ${open_conference_plan_id}

        <p>${conferenceDaysQty}</p>--%>
</div>



    <div class="w3-bar w3-light-green">

        <c:forEach var="day" items="${open_conference_plan_id}">
            <%--Key = ${day.key}. value = ${day.value}--%>
            <c:if test="${day.key eq 'Day-1'}">
                <button class="w3-bar-item w3-button w3-border-black tabling w3-red" onclick="openDay(event,'${day.key}')">${day.key}</button>
                </c:if>
            <c:if test="${day.key ne 'Day-1'}">
            <button class="w3-bar-item w3-button w3-border-black tabling" onclick="openDay(event,'${day.key}')">${day.key}</button>
            </c:if>
        </c:forEach>
    </div>

<div class="w3-margin">

    <c:forEach var="day" items="${open_conference_plan_id}">
        <c:if test="${day.key ne 'Day-1'}">
            <div id="${day.key}" class="w3-container w3-display-container day" style="display:none">
        </c:if>
        <c:if test="${day.key eq 'Day-1'}">
            <div id="${day.key}" class="w3-container w3-display-container day">
        </c:if>
            <table class="w3-table-all w3-hoverable">
                <thead>
                <tr class="w3-light-grey">
                    <th>seminar-id</th>
                    <th>conference-day</th>
                    <th>seminar-time</th>
                    <th>seminar-topic</th>
                    <th>seminar-speaker</th>
                    <th>seminar-room</th>
                 </tr>
                </thead>

        <c:forEach items="${day.value}" var="seminar">
                <tr>
                    <td>${seminar.getIdSeminar()}</td>
                    <td>${seminar.getDayConference()}</td>
                    <td>
                        <%@ include file="../moderator/modal_change_seminar_time.jsp"%>
                    </td>
                    <td>
                        <%@ include file="../moderator/modal_change_seminar_topic.jsp"%>
                    </td>
                    <td>
                        <%@ include file="../moderator/modal_change_seminar_speaker.jsp"%>
                            <%--${seminar.getSeminarSpeaker()}--%>
                    </td>
                    <td>
                        <%@ include file="../moderator/modal_change_seminar_room.jsp"%>
                            <%--${seminar.getSeminarRoom()}</td>--%>
                    </td>
                </tr>
        </c:forEach>
            </table>


        </div>
        </c:forEach>

    <%--<div id="Paris" class="w3-container w3-display-container day" style="display:none">
        <h2>Paris</h2>
        <p>Paris is the capital of France.</p>
    </div>--%>
</div>
<br>
<%--    <script>
        function openDay(dayName) {
            var i;
            var x = document.getElementsByClassName("day");
            for (i = 0; i < x.length; i++) {
                x[i].style.display = "none";
            }
            document.getElementById(dayName).style.display = "block";
        }
    </script>--%>

        <script>
            function openDay(evt, dayName) {
                var i, x, tablings;
                x = document.getElementsByClassName("day");
                for (i = 0; i < x.length; i++) {
                    x[i].style.display = "none";
                }
                tablings = document.getElementsByClassName("tabling");
                for (i = 0; i < x.length; i++) {
                    tablings[i].className = tablings[i].className.replace(" w3-red", "");
                }
                document.getElementById(dayName).style.display = "block";
                evt.currentTarget.className += " w3-red";
            }
        </script>