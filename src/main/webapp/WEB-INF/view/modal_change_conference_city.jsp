<button onclick="document.getElementById('${all_conferences_list.getIdConference()}city').style.display='block'"
        class="w3-green w3-border-0 w3-round-xxlarge">

    <c:if test="${language == 'en'}">${all_conferences_list.getConferenceCityEng()}</c:if>
    <c:if test="${language == 'en-EN'}">${all_conferences_list.getConferenceCityEng()}</c:if>
    <c:if test="${language == 'uk-UA'}">${all_conferences_list.getConferenceCityUkr()}</c:if>

</button>
<div id="${all_conferences_list.getIdConference()}city" class="w3-modal">
    <div class="w3-modal-content w3-animate-top w3-card-4">
        <header class="w3-container w3-red">
            <span onclick="document.getElementById('${all_conferences_list.getIdConference()}city').style.display='none'"
                  class="w3-button w3-large w3-red w3-display-topright">&times;</span>
            <h2>change-conference-city</h2>
        </header>

        <div class="w3-container w3-left-align">
            <p>dear-moderator!</p>
            <p>be-sure-you-are-doing-the-right-thing.</p>
            <p>
                you-are-going-to-chang-the-current-conference-city:
                ${all_conferences_list.getConferenceCityEng()}
                ${all_conferences_list.getConferenceCityUkr()}
            </p>
            <p>for-conference:
                <c:if test="${language == 'en' or 'en-EN'}">
                    ${all_conferences_list.getConferenceTitleEng()}
                </c:if>
                <c:if test="${language == 'uk-UA'}">
                    ${all_conferences_list.getConferenceTitleUkr()}
                </c:if>
            </p>


            <h3>make-your-choice-here:</h3>
            <form action="${pageContext.request.contextPath}/view/change_conference_city">
                <label class="w3-text-grey"><b>city-in-english</b></label>
                <input class="w3-input w3-border w3-margin-bottom" type="text" name="city_eng">
                <label class="w3-text-grey"><b>city-in-ukraine</b></label>
                <input class="w3-input w3-border w3-margin-bottom" type="text" name="city_ukr">
                <input type="hidden" name="conferenceId" value="${all_conferences_list.getIdConference()}">

                <div class="w3-center">
                    <button class="w3-btn w3-round-large w3-green w3-hover-red w3-margin-bottom">submit</button>
                </div>
            </form>
        </div>

        <div class="w3-bar">


        </div>

    </div>
</div>