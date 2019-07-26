<div id="all-cms-users" class="w3-container w3-border menu w3-white">
    <h2>these-are-all-cms-users</h2>
    <div class="w3-container w3-margin">
        <table class="w3-table-all w3-centered w3-hoverable w3-card-4">
            <thead>
            <tr class="w3-light-blue">
                <th>
                    <div class="w3-dropdown-hover">
                        <button class="w3-button w3-light-blue">user-id</button>
                        <div class="w3-dropdown-content w3-bar-block w3-card w3-light-grey">
                            <input class="w3-input w3-padding" type="text" placeholder="Search.."
                                   id="user-id" onkeyup="myFunction()">
                        </div>
                    </div>
                </th>
                <th>
                    <div class="w3-dropdown-hover">
                        <button class="w3-button w3-light-blue">user-login</button>
                        <div class="w3-dropdown-content w3-bar-block w3-card w3-light-grey">
                            <input class="w3-input w3-padding" type="text" placeholder="Search.."
                                   id="user-login" onkeyup="myFunction()">
                        </div>
                    </div>
                </th>
                <th>
                    <div class="w3-dropdown-hover">
                        <button class="w3-button w3-light-blue">user-name</button>
                        <div class="w3-dropdown-content w3-bar-block w3-card w3-light-grey">
                            <input class="w3-input w3-padding" type="text" placeholder="Search.."
                                   id="user-name" onkeyup="myFunction()">
                        </div>
                    </div>
                </th>
                <th>
                    <div class="w3-dropdown-hover">
                        <button class="w3-button w3-light-blue">user-surname</button>
                        <div class="w3-dropdown-content w3-bar-block w3-card w3-light-grey">
                            <input class="w3-input w3-padding" type="text" placeholder="Search.."
                                   id="user-surname" onkeyup="myFunction()">
                        </div>
                    </div>
                </th>
                <th>
                    <div class="w3-dropdown-hover">
                        <button class="w3-button w3-light-blue">user-email</button>
                        <div class="w3-dropdown-content w3-bar-block w3-card w3-light-grey">
                            <input class="w3-input w3-padding" type="text" placeholder="Search.."
                                   id="user-email" onkeyup="myFunction()">
                        </div>
                    </div>
                </th>
                <th>
                    <div class="w3-dropdown-hover">
                        <button class="w3-button w3-light-blue">user-activity-status</button>
                        <div class="w3-dropdown-content w3-bar-block w3-card w3-light-grey">
                            <a class="w3-bar-item w3-button" href="#user">user</a>
                            <a class="w3-bar-item w3-button" href="#speaker">speaker</a>
                            <a class="w3-bar-item w3-button" href="#moderator">moderator</a>
                            <a class="w3-bar-item w3-button" href="#administrator">administrator</a>
                        </div>
                    </div>
                </th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td class="w3-center">1.</td>
                <td>eigomal</td>
                <td>Igor</td>
                <td>Malianov</td>
                <td>m_igor@ukr.net</td>
                <td>
                    <button onclick="document.getElementById('id01').style.display='block'"
                            class="w3-green w3-border-0 w3-round-xxlarge">admin
                    </button>
                    <div id="id01" class="w3-modal">
                        <div class="w3-modal-content w3-animate-top w3-card-4">
                            <header class="w3-container w3-red">
                                            <span onclick="document.getElementById('id01').style.display='none'"
                                                  class="w3-button w3-large w3-red w3-display-topright">&times;</span>
                                <h2>change-user-role</h2>
                            </header>
                            <div class="w3-container w3-left-align">
                                <p>dear-admin!</p>
                                <p>be-sure-you-are-doing-the-right-thing.</p>
                                <p>the-current-status-for-this-user-is</p>
                                <form>
                                    <h3>make-yout-choice-here:</h3>

                                    <input class="w3-radio" type="radio" name="user-status-change"
                                           value="user" checked>
                                    <label>user</label>

                                    <input class="w3-radio" type="radio" name="user-status-change"
                                           value="speaker">
                                    <label>speaker</label>

                                    <input class="w3-radio" type="radio" name="user-status-change"
                                           value="moderator">
                                    <label>moderator</label>

                                    <input class="w3-radio" type="radio" name="user-status-change"
                                           value="administrator">
                                    <label>administrator</label>
                                </form>
                            </div>
                            <footer class="w3-container w3-red w3-display-container w3-center">
                                <p>please-confirm-your-choice <span
                                        onclick="document.getElementById('id01').style.display='none'"
                                        class="w3-button w3-light-blue w3-round-xxlarge w3-display-right">confirm</span>
                                </p>
                            </footer>
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td>2.</td>
                <td>eperkon</td>
                <td>Konstantin</td>
                <td>Peyakovrm</td>
                <td>k@ua.net</td>
                <td>speaker</td>
            </tr>
            <tr>
                <td>3.</td>
                <td>ealelob</td>
                <td>Alexahder</td>
                <td>Lobas</td>
                <td>al@mail.ua</td>
                <td>user</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
