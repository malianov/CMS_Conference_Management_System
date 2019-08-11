<button onclick="document.getElementById('${all_conferences_list.getIdConference()}title').style.display='block'"
        class="w3-green w3-border-0 w3-round-xxlarge">

    <c:if test="${language == 'en' || language == 'en-EN'}">${all_conferences_list.getConferenceTitleEng()}</c:if>
    <c:if test="${language == 'uk-UA'}">${all_conferences_list.getConferenceTitleUkr()}</c:if>

</button>
<div id="${all_conferences_list.getIdConference()}title" class="w3-modal">
    <div class="w3-modal-content w3-animate-top w3-card-4">
        <header class="w3-container w3-red">
            <span onclick="document.getElementById('${all_conferences_list.getIdConference()}title').style.display='none'"
                  class="w3-button w3-large w3-red w3-display-topright">&times;</span>
            <h2><fmt:message key="change-conference-title"/></h2>
        </header>

        <div class="w3-container w3-left-align">
            <p><fmt:message key="dear-administrator"/></p>
            <p><fmt:message key="be-sure-you-are-doing-the-right-thing"/></p>
            <p>
                <fmt:message key="you-are-going-to-chang-the-current-conference-title"/>
                ${all_conferences_list.getConferenceTitleEng()}
                <%--                ${all_conferences_list.getConferenceTopicUkr()}--%>
            </p>
            <p><fmt:message key="for-conference"/>
                <c:if test="${language == 'en' || language == 'en-EN'}">
                    ${all_conferences_list.getConferenceTitleEng()}
                </c:if>
                <c:if test="${language == 'uk-UA'}">
                    ${all_conferences_list.getConferenceTitleUkr()}
                </c:if>
            </p>

            <h3><fmt:message key="make-your-choice-here"/></h3>
            <form action="${pageContext.request.contextPath}/view/change_conference_title">
                <label class="w3-text-grey"><b><fmt:message key="title-in-english"/></b></label>
                <input class="w3-input w3-border w3-margin-bottom" type="text" name="conference_title_eng">
                <label class="w3-text-grey"><b><fmt:message key="title-in-ukrainian"/></b></label>
                <input class="w3-input w3-border w3-margin-bottom" type="text" name="conference_title_ukr">
                <input type="hidden" name="conferenceId" value="${all_conferences_list.getIdConference()}">

                <div class="w3-center">
                    <button class="w3-btn w3-round-large w3-green w3-hover-red w3-margin-bottom">confirm</button>
                </div>
            </form>
        </div>
    </div>
</div>