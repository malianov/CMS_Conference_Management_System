<div id="my-conferences" class="w3-container w3-border menu w3-white">
    <h2>you-are-registered-to-these-conferences</h2>
    <div class="w3-container w3-margin">
        <table class="w3-table-all w3-centered w3-hoverable w3-card-4">
            <thead>
            <tr class="w3-light-blue">
                <th>conference-id</th>
                <th>conference-start-date</th>
                <th>conference-end-date</th>
                <th>conference-title</th>
                <th>conference-city</th>
                <th>conference-hall</th>
            </tr>
            </thead>

            <tbody>

            <tr>
                <td>1.</td>
                <td>
                    <div class="w3-container">
                        <button onclick="document.getElementById('id01').style.display='block'"
                                class="w3-button w3-light-green w3-hover-red w3-tiny w3-round-xxlarge">
                            DEVOXX
                        </button>

                        <div id="id01" class="w3-modal">
                            <div class="w3-modal-content w3-card-4 w3-animate-zoom">
                                <header class="w3-container w3-blue">
   <span onclick="document.getElementById('id01').style.display='none'"
         class="w3-button w3-blue w3-xlarge w3-display-topright">&times;</span>
                                    <h2>DeVOXX</h2>
                                </header>

                                <div class="w3-bar w3-border-bottom">
                                    <button class="tablink_day w3-bar-item w3-button"
                                            onclick="openDay(event, 'Day-1')">Day-1
                                    </button>
                                    <button class="tablink_day w3-bar-item w3-button"
                                            onclick="openDay(event, 'Day-2')">Day-2
                                    </button>
                                    <button class="tablink_day w3-bar-item w3-button"
                                            onclick="openDay(event, 'Day-3')">Day-3
                                    </button>
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
                                            <th>To Plan</th>
                                            <th>CheckOut</th>
                                        </tr>
                                        </thead>
                                        <tr>
                                            <td>1</td>
                                            <td>9:15</td>
                                            <td>10:00</td>
                                            <td>How to live without Java?</td>
                                            <td>Igor Malianov</td>
                                            <td>Ocean Room</td>
                                            <td>Plan</td>
                                            <td>CheckOut</td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>10:15</td>
                                            <td>11:00</td>
                                            <td>How to live without HTML?</td>
                                            <td>Igor Malianov</td>
                                            <td>Ocean Room</td>
                                            <td>Plan</td>
                                            <td>CheckOut</td>
                                        </tr>
                                        <tr>
                                            <td>3</td>
                                            <td>11:15</td>
                                            <td>12:00</td>
                                            <td>How to live without CSS?</td>
                                            <td>Igor Malianov</td>
                                            <td>Ocean Room</td>
                                            <td>Plan</td>
                                            <td>CheckOut</td>
                                        </tr>
                                    </table>


                                </div>

                                <div id="Day-2" class="w3-container day">
                                    <h1>Day-2</h1>
                                    <p>Paris is the capital of France.</p>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                                </div>

                                <div id="Day-3" class="w3-container day">
                                    <h1>Day-3</h1>
                                    <p>Tokyo is the capital of Japan.</p><br>
                                </div>

                                <div class="w3-container w3-light-grey w3-padding">
                                    <button class="w3-button w3-right w3-white w3-border"
                                            onclick="document.getElementById('id01').style.display='none'">
                                        Close
                                    </button>
                                </div>
                            </div>
                        </div>

                    </div>
                </td>
                <td>
                    20.07.2019
                </td>
                <td>23.07.2019</td>
                <td>Kyiv</td>
                <td>Mercury</td>
            </tr>

            <tr>
                <td>2.</td>
                <td>
                    <button class="w3-button w3-round-xxlarge w3-light-green w3-hover-red w3-tiny">
                        JavaDay
                    </button>
                </td>
                <td>15.08.2019</td>
                <td>16.08.2019</td>
                <td>Kharkiv</td>
                <td>Ukraininan House</td>
            </tr>
            <tr>
                <td>3.</td>
                <td>
                    <button class="w3-button w3-round-xxlarge w3-light-green w3-hover-red w3-tiny">
                        JUG
                    </button>
                </td>
                <td>19.09.2019</td>
                <td>23.09.2019</td>
                <td>Odessa</td>
                <td>Hotel Odessa</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
