<div id="conference-calendar" class="w3-container w3-border menu w3-white">
    <h2>conference-calendar (show registered)</h2>
    <div class="w3-container w3-margin">
        <table class="w3-table-all w3-centered">
            <thead>
            <tr class="w3-light-blue">
                <th>conference-id</th>
                <th>conference-start-date</th>
                <th>conference-end-date</th>
                <th>conference-title</th>
                <th>conference-city</th>
                <th>conference-hall ${noOfPages}</th>
                <th>conference-register currentPage ${currentPage}</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${conferences}" var="all_conferences_list">

                <tr>
                    <td>${all_conferences_list.getId_conference()}</td>
                    <td>${all_conferences_list.getStart_date()}</td>
                    <td>${all_conferences_list.getEnd_date()}</td>
                    <td>
                        <button class="w3-button w3-round-xxlarge w3-light-green w3-hover-red w3-tiny">
                                ${all_conferences_list.getConference_title()}
                        </button>
                    </td>
                    <td>${all_conferences_list.getConference_city()}</td>
                    <td>${all_conferences_list.getConference_place()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <nav>
        <ul>

            <c:if test="${currentPage != 1}">
                <li class="page-item">
                    <a class="in-table-link"
                       href="${pageContext.request.contextPath}/view/calendar_page?currentPage=${currentPage - 1}">
                        <fmt:message key="label.prev"/>
                    </a>
                </li>
            </c:if>


            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <li class="page-item active">
                            <a class="in-table-link" href="#"> ${i} </a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item">
                            <a class="in-table-link" href="${pageContext.request.contextPath}/view/calendar_page?currentPage=${i}">${i}</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>


            <c:if test="${currentPage lt noOfPages}">
                <li class="page-item"><a class="in-table-link" href="${pageContext.request.contextPath}/view/calendar_page?currentPage=${currentPage + 1}">
                    <fmt:message key="label.next"/></a>
                </li>
            </c:if>
        </ul>
    </nav>

</div>
