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
            <button class="w3-bar-item w3-button tablink w3-red"  onclick="tab(event,'Home')">Home</button>
            <button class="w3-bar-item w3-button tablink" onclick="tab(event,'Schedule')">Schedule</button>
            <button class="w3-bar-item w3-button tablink" onclick="tab(event,'Materials')">Materials</button>
            <button class="w3-bar-item w3-button tablink" onclick="tab(event,'Speakers')">Speakers</button>
        </div>

        <div id="Home" class="w3-container w3-border topic">
            <h2>Home</h2>
            <p>Home is the capital city of England.</p>
        </div>

        <div id="Schedule" class="w3-container w3-border topic" style="display:none">
            <h2>Schedule</h2>
            <p>Schedule is the capital of France.</p>
        </div>

        <div id="Materials" class="w3-container w3-border topic" style="display:none">
            <h2>Materials</h2>
            <p>Materials is the capital of Japan.</p>
        </div>

        <div id="Speakers" class="w3-container w3-border topic" style="display:none">
            <h2>Speakers</h2>
            <p>Speakers is the capital of Japan.</p>
        </div>
