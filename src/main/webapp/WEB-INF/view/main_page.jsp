<%@ include file="header.jsp" %>

<div class="w3-container w3-padding w3-margin w3-display-container">
    <div class="w3-card-4">
        <div class="w3-container w3-center w3-green">
            <h2>
                <c:if test="${language == 'en'}"><c:out value=" ${user.getName()},"/></c:if>
                <c:if test="${language == 'en-EN'}"><c:out value=" ${user.getName()},"/></c:if>
                <c:if test="${language == 'uk-UA'}"><c:out value=" ${user.getName()},"/></c:if>
                <fmt:message key="you-are-inside-the-LMS"/></h2>
        </div>

        <div class="w3-bar w3-light-blue">
            <button class="w3-bar-item w3-button tablink w3-red" onclick="tab(event,'Home')"><fmt:message key="home"/></button>
            <button class="w3-bar-item w3-button tablink" onclick="tab(event,'Schedule')"><fmt:message key="schedule"/></button>
            <button class="w3-bar-item w3-button tablink" onclick="tab(event,'Materials')"><fmt:message key="materials"/></button>
            <button class="w3-bar-item w3-button tablink" onclick="tab(event,'Speakers')"><fmt:message key="speakers"/></button>

            <button class="w3-bar-item w3-button w3-right"
                    onclick="location.href='${pageContext.request.contextPath}/view/logout'">
                <fmt:message key="logout"/>
            </button>

            <div class="w3-dropdown-hover w3-right">
                <button class="w3-button"><fmt:message key="language"/></button>
                <div class="w3-dropdown-content w3-bar-block w3-card-4">
                    <a href="${pageContext.request.contextPath}/view/language/main_page?language=UA"
                       class="w3-bar-item w3-button"><fmt:message key="ukrainian"/></a>
                    <a href="${pageContext.request.contextPath}/view/language/main_page?language=EN"
                       class="w3-bar-item w3-button"><fmt:message key="english"/></a>
                </div>
            </div>



            <button class="w3-bar-item w3-button w3-right tablink" onclick="tab(event,'MyCabinet')"><fmt:message key="my-cabinet"/></button>

        </div>

        <div id="Home" class="w3-container w3-border topic">
            <%@ include file="home.jsp" %>
        </div>

        <div id="Schedule" class="w3-container w3-border topic" style="display:none">
            <%@ include file="schedule.jsp" %>
        </div>

        <div id="Materials" class="w3-container w3-border topic" style="display:none">
            <%@ include file="materials.jsp" %>
        </div>

        <div id="Speakers" class="w3-container w3-border topic" style="display:none">
            <%@ include file="speakers.jsp" %>
        </div>

        <div id="MyCabinet" class="w3-container w3-border topic" style="display:none">
            <%@ include file="mycabinet.jsp" %>
        </div>


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

<footer class="<%--w3-bottom--%> w3-container w3-blue-grey w3-opacity w3-teal w3-bottom">
    <p>igor-malianov-2019</p>
</footer>


</body>
</html>