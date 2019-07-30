<%--
<%@ include file="../header.jsp" %>

<div class="w3-container w3-padding w3-margin w3-display-container">
    <div class="w3-card-4">
        <div class="w3-container w3-center w3-green">
            <h2>
                <c:if test="${language == 'en'}"><c:out value=" ${user.getName()},"/></c:if>
                <c:if test="${language == 'en-EN'}"><c:out value=" ${user.getName()},"/></c:if>
                <c:if test="${language == 'uk-UA'}"><c:out value=" ${user.getName()},"/></c:if>
                <fmt:message key="welcome-to-the-system-CMS_speaker"/></h2>
        </div>

        <div class="w3-bar w3-light-blue">
            <button class="w3-bar-item w3-button tablink w3-red" onclick="openMenu(event,'my-conferences')"><fmt:message key="my-conferences"/></button>
            <button class="w3-bar-item w3-button tablink" onclick="openMenu(event,'conference-calendar')"><fmt:message key="conference-calendar"/></button>
            <button class="w3-bar-item w3-button tablink" onclick="openMenu(event,'conference-archive')"><fmt:message key="conference-archive"/></button>

            <button class="w3-bar-item w3-button w3-right" onclick="location.href='${pageContext.request.contextPath}/view/logout'"><fmt:message key="logout"/></button>

            <div class="w3-dropdown-hover w3-right">
                <button class="w3-button"><fmt:message key="language"/></button>
                <div class="w3-dropdown-content w3-bar-block w3-card-4">
                    <a href="${pageContext.request.contextPath}/view/language/speaker_page?language=UA"
                       class="w3-bar-item w3-button"><fmt:message key="ukrainian"/></a>
                    <a href="${pageContext.request.contextPath}/view/language/speaker_page?language=EN"
                       class="w3-bar-item w3-button"><fmt:message key="english"/></a>
                </div>
            </div>

            <div class="w3-dropdown-hover tablink w3-right"><button class="w3-button"><fmt:message key="my-box(4)"/></button></div>

        </div>

        <%@ include file="../speaker/speaker_registered_conferences.jsp" %>
        <%@ include file="../common/calendar_conferences.jsp" %>
        <%@ include file="../common/archive_conferences.jsp" %>

    </div>
</div>
</div>

<script>
    function tab(evt, topicName) {
        var i, x, tablinks;
        x = document.getElementsByClassName("topic");
        for (i = 0; i < x.length; i++) {
            x[i].style.display = "none";
        }
        tablinks = document.getElementsByClassName("tablink");
        for (i = 0; i < x.length; i++) {
            tablinks[i].className = tablinks[i].className.replace(" w3-red", "");
        }
        document.getElementById(topicName).style.display = "block";
        evt.currentTarget.className += " w3-red";
    }
</script>

<script>
    document.getElementsByClassName("tablink_day")[0].click();

    function openDay(evt, dayName) {
        var k, y, tablinks;
        y = document.getElementsByClassName("day");
        for (k = 0; k < y.length; k++) {
            y[k].style.display = "none";
        }
        tablinks = document.getElementsByClassName("tablink_day");
        for (k = 0; k < y.length; y++) {
            tablinks[k].classList.remove("w3-light-grey");
        }
        document.getElementById(dayName).style.display = "block";
        evt.currentTarget.classList.add("w3-light-grey");
    }
</script>
<script>
    function openMenu(evt, menuName) {
        var i, x, tablinks;
        x = document.getElementsByClassName("menu");
        for (i = 0; i < x.length; i++) {
            x[i].style.display = "none";
        }
        tablinks = document.getElementsByClassName("tablink");
        for (i = 0; i < x.length; i++) {
            tablinks[i].className = tablinks[i].className.replace(" w3-red", "");
        }
        document.getElementById(menuName).style.display = "block";
        evt.currentTarget.className += " w3-red";
    }
</script>

<footer class="&lt;%&ndash;w3-bottom&ndash;%&gt; w3-container w3-blue-grey w3-opacity w3-teal w3-bottom">
    <p>igor-malianov-2019</p>
</footer>


</body>
</html>
--%>
