<div class="w3-content w3-section" style="max-width:500px">
<%--    <img class="mySlides w3-animate-fading" src='<c:url value="${pageContext.request.contextPath}/images/java_5.jpg"/>' style="width:100%">--%>
<%--    <img class="mySlides w3-animate-fading" src='<c:url value="${pageContext.request.contextPath}/images/java_6.jpg"/>' style="width:100%">--%>
<%--    <img class="mySlides w3-animate-fading" src='<c:url value="${pageContext.request.contextPath}/images/java_7.jpg"/>' style="width:100%">--%>
<%--    <img class="mySlides w3-animate-fading" src='<c:url value="${pageContext.request.contextPath}/images/java_8.jpg"/>' style="width:100%">--%>
    <img src="/resources/java_9.jpg">
</div>

<script>
    var myIndex = 0;
    carousel();

    function carousel() {
        var i;
        var x = document.getElementsByClassName("mySlides");
        for (i = 0; i < x.length; i++) {
            x[i].style.display = "none";
        }
        myIndex++;
        if (myIndex > x.length) {myIndex = 1}
        x[myIndex-1].style.display = "block";
        setTimeout(carousel, 3000);
    }
</script>