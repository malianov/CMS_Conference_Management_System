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
