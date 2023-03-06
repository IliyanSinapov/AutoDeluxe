var main = document.getElementById("main");

var updateTime = 100;
var drawTime = 100;
var clear = true;
var color = "black";
var drawPriority = 1;
var elementType = "div";
var lineWidth = 3;
var innerText = "";
var mouseX = 0;
var mouseY = 0;
var circle = Math.PI*2

function linearInterpolation(a, b, t) {
    return a + (b - a) * t;
}

function distance(startX, startY, endX, endY) {
    return Math.sqrt(Math.pow(startX - endX, 2) + Math.pow(startY - endY, 2));
}

function fillRect(startX, startY, endX, endY) {
    let newDiv = document.createElement(elementType);
    main.appendChild(newDiv);
    newDiv.style.position = "absolute";
    newDiv.style.left = `${startX}rem`;
    newDiv.style.top = `${startY}rem`;
    newDiv.style.width = `${endX}rem`;
    newDiv.style.height = `${endY}rem`;
    newDiv.style.zIndex = Math.floor(drawPriority * 1000);
    newDiv.style.backgroundColor = color;
    newDiv.innerText = innerText;
    return newDiv;
}

function drawLine(startX, startY, endX, endY) {
    let dist = 1 / distance(startX, startY, endX, endY);
    for (let i = 0; i < 1; i += dist * 3) {
        fillRect(
            linearInterpolation(startX, endX, i),
            linearInterpolation(startY, endY, i),
            lineWidth,
            lineWidth
        );
    }
}

document.addEventListener("mousemove", function (event) {
    mouseX = event.clientX;
    mouseY = event.clientY;
});

var iredrawables = document.getElementById("iredrawables");

function iredrawable(startX, startY, endX, endY) {
    let newDiv = document.createElement(elementType);
    iredrawables.appendChild(newDiv);
    newDiv.style.position = "absolute";
    newDiv.style.left = `${startX}rem`;
    newDiv.style.top = `${startY}rem`;
    newDiv.style.width = `${endX}rem`;
    newDiv.style.height = `${endY}rem`;
    newDiv.style.zIndex = Math.floor(drawPriority * 1000);
    newDiv.style.backgroundColor = color;
    newDiv.innerText = innerText;
    return newDiv;
}

function changeX(element, position) {
    element.style.left = `${position}rem`;
}

function changeY(element, position) {
    element.style.top = `${position}rem`;
}

function getX(element) {
    return parseInt(element.style.left.slice(0, -2));
}

function getY(element) {
    return parseInt(element.style.top.slice(0, -2));
}

function getEndX(element) {
    return parseInt(element.style.width.slice(0, -2)) + getX(element);
}

function getEndY(element) {
    return parseInt(element.style.height.slice(0, -2)) + getY(element);
}

function areColliding(Ax, Ay, Awidth, Aheight, Bx, By, Bwidth, Bheight) {
    if (
        Bx <= Ax + Awidth &&
        Ax <= Bx + Bwidth &&
        By <= Ay + Aheight &&
        Ay <= By + Bheight
    ) {
        return 1;
    }
    return 0;
}

function drawImage(src, startX, startY, endX, endY) {
    let newDiv = document.createElement('img');
    main.appendChild(newDiv);
    newDiv.style.position = "absolute";
    newDiv.style.left = `${startX}rem`;
    newDiv.style.top = `${startY}rem`;
    newDiv.style.width = `${endX}rem`;
    newDiv.style.height = `${endY}rem`;
    newDiv.style.zIndex = Math.floor(drawPriority * 1000);
    newDiv.setAttribute('src', src);
    return newDiv;
}

function advancedMove(x,y,a,r){
    return {x:x + Math.cos(a)*r, y:y + Math.sin(a)*r}
}

function drawCircle(x,y,r,quality){
    for(let a = 0; a < circle; a += circle/quality){
        newPos = advancedMove(x,y,a,r)
        fillRect(newPos.x,newPos.y,lineWidth,lineWidth)
    }
}