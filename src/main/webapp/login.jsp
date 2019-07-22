<%@ include file="WEB-INF/view/header.jsp" %>

<div class="w3-container w3-padding w3-margin w3-display-container">
    <div class="w3-card-4">
        <div class="w3-center w3-green">
            <h2><fmt:message key="welcome-to-the-system-CMS"/></h2>
            <div class="w3-dropdown-hover w3-right">
                <button class="w3-button w3-blue"><fmt:message key="language"/></button>
                <div class="w3-dropdown-content w3-bar-block w3-border" style="right:0">
                    <a href="${pageContext.request.contextPath}/view/language//?language=UA" class="w3-bar-item w3-button"><fmt:message key="ukrainian"/></a>
                    <a href="${pageContext.request.contextPath}/view/language//?language=EN" class="w3-bar-item w3-button"><fmt:message key="english"/></a>
                </div>
            </div>
        </div>

        <form method="post" action="${pageContext.request.contextPath}/view/login"
              class="w3-selection w3-light-grey w3-padding">

            <label><fmt:message key="enter-login"/><input type="text" name="login" class="w3-input w3-border w3-round-large" style="width: 20%"> <br/></label>
            <c:if test="${requestScope.errLoginlMessage != null}">
                <small class="err-message-register"><c:out value="${requestScope.errLoginMessage}"/></small>
            </c:if>

            <label><fmt:message key="enter-password"/><input type="password" name="password"  class="w3-input w3-input w3-border w3-round-large" style="width: 20%"> <br/></label>
            <c:if test="${requestScope.errPassMessage != null}">
                <small class="err-message-register"><c:out value="${requestScope.errPassMessage}"/></small>
            </c:if>


            <div class="form-group form-check">
                <c:if test="${requestScope.error != null}">
                    <small class="err-message-register"><c:out value="${requestScope.error}"/></small>
                </c:if>
            </div>

            <div class="w3-bar">
                <button class="w3-btn w3-round w3-blue w3-hover-red" type="submit"><fmt:message key="submit"/></button>
            </div>
        </form>

        <div class="w3-red">
            <c:if test="${wrongPassOrLogin.equals(true)}">
                <fmt:message key="wrong-pass-or-login"/>
            </c:if>
        </div>
    </div>
</div>
<%@ include file="WEB-INF/view/footer.jsp" %>