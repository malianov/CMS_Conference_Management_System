<footer class="<%--w3-bottom--%> w3-container w3-blue-grey w3-opacity w3-teal w3-bottom">
    <p><fmt:message key="igor-malianov-2019"/></p>
</footer>

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
<script>
    function openCity(evt, cityName) {
        var i, x, tablinks;
        x = document.getElementsByClassName("city");
        for (i = 0; i < x.length; i++) {
            x[i].style.display = "none";
        }
        tablinks = document.getElementsByClassName("tablink");
        for (i = 0; i < x.length; i++) {
            tablinks[i].className = tablinks[i].className.replace(" w3-red", "");
        }
        document.getElementById(cityName).style.display = "block";
        evt.currentTarget.className += " w3-red";
    }
</script>
</body>
</html>
