//Desktop device
const navbar = document.getElementById("desktop-user");
//Mobile device
const sidebar = document.getElementById("mobile-user");
//Navigation span for css
const span = document.getElementById("navigation-css");
const link = document.createElement("link");

//dropdown
const accDropdown  = document.querySelector(".dropdown");
const dropdownHeader  = document.querySelector(".dropdown-header");

accDropdown.addEventListener("click", (event) => {
    event.preventDefault()
    const dropdownMenu = event.target.querySelector(".dropdown-menu");
    dropdownMenu.classList.toggle("show");
})

dropdownHeader.addEventListener("click", (event) => {
    event.preventDefault()
    const dropdown = dropdownHeader.parentElement;
    const dropdownMenu = dropdown.children[1];
    dropdownMenu.classList.toggle("show");
})

function checkUserDevice() {
    if (screen.width < 811) {
        navbar.style.display = "none";
        sidebar.style.display = "block";


        link.setAttribute("rel", "stylesheet");
        link.setAttribute("type", "text/css");
        link.setAttribute("href", "css/styles/sidebar-style.css")
        span.innerHTML = "";

        const bodyEl = document.body
        const hamburgerEl = document.querySelector('.hamburger')

        hamburgerEl.addEventListener('click', () => {
            bodyEl.classList.toggle('active')
        })
    } else {
        link.setAttribute("rel", "stylesheet");
        link.setAttribute("type", "text/css");
        link.setAttribute("href", "css/styles/navbar-style.css")
        span.innerHTML = "";

        navbar.style.display = "block";
        sidebar.style.display = "none";
    }
    span.appendChild(link);
}

setInterval(() => {
    checkUserDevice();
}, 250);