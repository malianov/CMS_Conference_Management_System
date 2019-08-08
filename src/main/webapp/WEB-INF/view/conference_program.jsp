<div class="w3-container w3-padding-32">
    <header class="w3-container w3-blue">
        <h2>
            ${all_conferences_list.getConferenceTitleEng()}
        </h2>
    </header>
    <div class="w3-bar w3-border-bottom">
        <button class="tablink_day w3-bar-item w3-button" onclick="openDay(event, 'Day-1')">Day-1</button>
        <button class="tablink_day w3-bar-item w3-button" onclick="openDay(event, 'Day-2')">Day-2</button>
        <button class="tablink_day w3-bar-item w3-button" onclick="openDay(event, 'Day-3')">Day-3</button>
    </div>
    <div id="Day-1" class="w3-container day">
        <h1>Day-1</h1>
        <p>London is the most populous city in the United Kingdom, with a
            metropolitan area of over 9 million
            inhabitants.</p>
        <table class="w3-table-all w3-hoverable">
            <thead>
            <tr class="w3-light-grey">
                <th>Seminar id</th>
                <th>Start time</th>
                <th>End time</th>
                <th>Topic</th>
                <th>Speaker</th>
                <th>Hall</th>
            </tr>
            </thead>
            <tr>
                <td>1</td>
                <td>9:15</td>
                <td>10:00</td>
                <td>How to live without Java?</td>
                <td>Igor Malianov</td>
                <td>Ocean Room</td>
            </tr>
            <tr>
                <td>2</td>
                <td>10:15</td>
                <td>11:00</td>
                <td>How to live without HTML?</td>
                <td>Igor Malianov</td>
                <td>Ocean Room</td>
            </tr>
            <tr>
                <td>3</td>
                <td>11:15</td>
                <td>12:00</td>
                <td>How to live without CSS?</td>
                <td>Igor Malianov</td>
                <td>Ocean Room</td>
            </tr>
        </table>
    </div>
    <div id="Day-2" class="w3-container day"><h1>Day-2</h1></div>
    <div id="Day-3" class="w3-container day"><h1>Day-3</h1></div>
</div>
</div>
</div>
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
    // Filter
    function myFunction() {
        var input, filter, ul, li, a, i;
        input = document.getElementById("myInput");
        filter = input.value.toUpperCase();
        div = document.getElementById("myDIV");
        a = div.getElementsByTagName("a");
        for (i = 0; i < a.length; i++) {
            txtValue = a[i].textContent || a[i].innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                a[i].style.display = "";
            } else {
                a[i].style.display = "none";
            }
        }
    }
</script>




