<div class="w3-dropdown-hover tablink w3-right">
    <div class="w3-container">
        <button onclick="document.getElementById('id5555').style.display='block'" class="w3-button w3-light-blue">
            <fmt:message key="inbox"/>
        </button>
        <div id="id5555" class="w3-modal">
            <div class="w3-modal-content w3-card-4 w3-animate-zoom">
                <header class="w3-container w3-blue">
                                    <span onclick="document.getElementById('id5555').style.display='none'" class="w3-button w3-blue w3-xlarge
                                    w3-display-topright">&times;</span>
                    <h2><fmt:message key="inbox"/></h2>
                </header>

                <div class="w3-container">

                    <ul class="w3-ul w3-card-4">
                        <li class="w3-bar">
                            <div class="w3-block" onclick="this.parentElement.style.display='none'">
                                <img src="${pageContext.request.contextPath}/images/avatar1.png"
                                     class="w3-bar-item w3-circle w3-hide-small" style="width:85px">
                                <span class="w3-large"><b>Mike</b></span><br>
                                <span><fmt:message key="i-choosed-a-free-topic-and-want-to-be-a-speaker-for-this-topic-[]"/></span><br>
                                <span class="w3-bar-item w3-left">
                                                    <button class="w3-btn w3-light-green w3-round-large w3-left-align"><fmt:message key="confirm"/></button>
                                                    <button class="w3-btn w3-red w3-round-large w3-left-align"><fmt:message key="decline"/></button></span>
                            </div>
                        </li>
                        <li class="w3-bar">
                            <div class="w3-block" onclick="this.parentElement.style.display='none'">
                                <img src="${pageContext.request.contextPath}/images/avatar2.png"
                                     class="w3-bar-item w3-circle w3-hide-small"
                                     style="width:85px">
                                <span class="w3-large"><b>Jill</b></span><br>
                                <span><fmt:message key="i-propose-a-new-topic"/></span><br>
                                <span class="w3-bar-item w3-left">
                                                    <button class="w3-btn w3-light-green w3-round-large w3-left-align"><fmt:message key="confirm"/></button>
                                                    <button class="w3-btn w3-red w3-round-large w3-left-align"><fmt:message key="decline"/></button></span>
                            </div>
                        </li>
                        <li class="w3-bar">
                            <div class="w3-block" onclick="this.parentElement.style.display='none'">
                                <img src="${pageContext.request.contextPath}/images/avatar3.png"
                                     class="w3-bar-item w3-circle w3-hide-small"
                                     style="width:85px">
                                <span class="w3-large"><b>Jane</b></span><br>
                                <span><fmt:message key="i-reject-my-participation-as-a-speaker"/></span><br>
                                <span class="w3-bar-item w3-left">
                                                    <button class="w3-btn w3-light-green w3-round-large w3-left-align"><fmt:message key="confirm"/></button>
                                                    <button class="w3-btn w3-red w3-round-large w3-left-align"><fmt:message key="decline"/></button></span>
                            </div>
                        </li>
                        <li class="w3-bar">
                            <div class="w3-block" onclick="this.parentElement.style.display='none'">
                                <img src="${pageContext.request.contextPath}/images/avatar4.png"
                                     class="w3-bar-item w3-circle w3-hide-small"
                                     style="width:85px">
                                <span class="w3-large"><b>Jill</b></span><br>
                                <span><fmt:message key="i-propose-to-rename-a-topic-for-meeting-before-it-was-[],-i-propose-[]"/></span><br>
                                <span class="w3-bar-item w3-left">
                                                    <button class="w3-btn w3-light-green w3-round-large"><fmt:message key="confirm"/></button>
                                                    <button class="w3-btn w3-red w3-round-large"><fmt:message key="decline"/></button></span>
                            </div>
                        </li>
                    </ul>
                </div>
                <div class="w3-container w3-light-grey w3-padding">
                    <button class="w3-button w3-right w3-white w3-border"
                            onclick="document.getElementById('id5555').style.display='none'">close
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>