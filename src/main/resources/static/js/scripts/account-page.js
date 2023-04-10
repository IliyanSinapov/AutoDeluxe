const activeDiv = document.querySelector(".active-page");
const pageLinks = document.getElementsByClassName("page-link-container");
const changeUsermameForm = document.querySelector(".change-username");

function handleClick() {
    if (changeUsermameForm.style.display === "none")
        changeUsermameForm.style.display = "block";
    else
        changeUsermameForm.style.display = "none";
}

for (let i = 0; i < pageLinks.length; i++) {
    pageLinks[i].addEventListener("mouseover", () => {
        switch (i) {
            case 0:
                activeDiv.style.top = "10.39vh";
                break;

            case 1:
                activeDiv.style.top = "14.54vh";
                break;

            case 2:
                activeDiv.style.top = "18.74vh";
                break;

            case 3:
                activeDiv.style.top = "23vh";
                break;

            default:
                activeDiv.style.top = "9.36vh";
                break;
        }
    })

    pageLinks[i].addEventListener("mouseleave", () => {
        activeDiv.style.top = "9.36vh"
    })
}