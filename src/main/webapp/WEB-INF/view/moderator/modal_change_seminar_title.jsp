<button onclick="document.getElementById('${seminar.getIdGlobalSeminar()}title').style.display='block'"
        class="w3-green w3-border-0 w3-round-xxlarge">

        <c:if test="${language == 'en'|| language == 'en-EN'}">${seminar.getSeminarTitle_eng()}></c:if>
        <c:if test="${language == 'uk-UA'}">${seminar.getSeminarTitle_ukr()}</c:if>

</button>
<div id="${seminar.getIdGlobalSeminar()}title" class="w3-modal">
    <div class="w3-modal-content w3-animate-top w3-card-4">
        <header class="w3-container w3-red">
            <span onclick="document.getElementById('${seminar.getIdGlobalSeminar()}title').style.display='none'"
                  class="w3-button w3-large w3-red w3-display-topright">&times;</span>
            <h2>change-seminar-topic</h2>
        </header>

        <div class="w3-container w3-left-align">
            <p>dear-moderator!</p>
            <p>be-sure-you-are-doing-the-right-thing.</p>
            <p>
                you-are-going-to-chang-the-current-seminar-topic:
                ${seminar.getSeminarTitle_eng()} and ${seminar.getSeminarTitle_ukr()}
            </p>

            <h3>make-your-choice-here:</h3>
            <form action="${pageContext.request.contextPath}/view/change_seminar_title">
                <label class="w3-text-grey"><b>seminar-topice</b></label>
                <input class="w3-input w3-border w3-margin-bottom" type="text" name="seminar_title_eng">
                <input class="w3-input w3-border w3-margin-bottom" type="text" name="seminar_title_ukr">
                <input type="hidden" name="seminar_id" value="${seminar.getIdGlobalSeminar()}">

                <div class="w3-center">
                    <button class="w3-btn w3-round-large w3-green w3-hover-red w3-margin-bottom">submit</button>
                </div>
            </form>
        </div>

<%--        <div class="w3-bar">


        </div>--%>

    </div>
</div>