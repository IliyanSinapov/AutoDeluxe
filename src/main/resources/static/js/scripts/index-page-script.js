//region getLoggedUser region
let loggedUser;
let xhr = new XMLHttpRequest();

xhr.open('GET', '/api/logged-user');

xhr.onload = function() {
    if (xhr.status === 200) {
        loggedUser = JSON.parse(xhr.responseText);
        console.log(loggedUser.username);
    } else {
        console.log('Request failed.  Returned status of ' + xhr.status);
    }
};

xhr.send();

//endregion

const welcomeDiv = document.querySelector(".welcome-index-div");

if (loggedUser.id == null)
    welcomeDiv.style.display = "block";
else
    welcomeDiv.style.display = "none";

console.log(loggedUser);