//region navigation region
//Desktop device
const navbar = document.getElementById("desktop-user");
//Mobile device
const sidebar = document.getElementById("mobile-user");
//Navigation span for css
const span = document.getElementById("navigation-css");
const link = document.createElement("link");
//endregion

//region dropdown region
//dropdown
const accDropdown  = document.querySelector(".dropdown");
const dropdownHeader  = document.querySelector(".dropdown-header");
const dropdown = dropdownHeader.parentElement;
const dropdownIcon = dropdown.children[1];
//endregion

//region activeDivVars region
const activeDiv = document.querySelector(".active");
const dropdownHeaderValue = dropdownHeader.textContent;

dropdownIcon.addEventListener("mouseout", () => {
    activeDiv.style.width = "10rem";
})

dropdownHeader.addEventListener("mouseout", () => {
    activeDiv.style.width = "10rem";
})

dropdownHeader.addEventListener("mouseover", () => {
    activeDiv.style.width = (dropdownHeaderValue.length * 3) + "rem";
})

dropdownIcon.addEventListener("mouseover", () => {
    activeDiv.style.width = (dropdownHeaderValue.length * 3) + "rem";
})
//endregion

//region dropdownClickFunctions region
accDropdown.addEventListener("click", (event) => {
    event.preventDefault()
    const dropdownMenu = dropdown.children[2];
    dropdownMenu.classList.toggle("show");
})
dropdownHeader.addEventListener("click", (event) => {
    event.preventDefault()
    const dropdownMenu = dropdown.children[2];
    dropdownMenu.classList.toggle("show");
    console.log("clicked")
})
dropdownIcon.addEventListener("click", (event) => {
    event.preventDefault()
    const dropdownMenu = dropdown.children[2];
    dropdownMenu.classList.toggle("show");
    console.log("clicked")
})
//endregion

function checkUserDevice() {
    if (screen.width < 811) {
        navbar.style.display = "none";
        sidebar.style.display = "block";


        link.setAttribute("rel", "stylesheet");
        link.setAttribute("type", "text/css");
        link.setAttribute("href", "/css/styles/sidebar-style.css")
        span.innerHTML = "";

        const bodyEl = document.body
        const hamburgerEl = document.querySelector('.hamburger')

        hamburgerEl.addEventListener('click', () => {
            bodyEl.classList.toggle('active')
        })
    } else {
        link.setAttribute("rel", "stylesheet");
        link.setAttribute("type", "text/css");
        link.setAttribute("href", "/css/styles/navbar-style.css")
        span.innerHTML = "";

        navbar.style.display = "block";
        sidebar.style.display = "none";
    }
    span.appendChild(link);
}
setInterval(() => {
    checkUserDevice();
}, 250);