class Point {
    constructor(x, y) {
        this.x = x;
        this.y = y;
    }

    getX() {
        return this.x;
    }

    getY() {
        return this.y;
    }
}

function fromPointsToPixels(x, y) {
    let pointX = centerPosX + (x * pixel_step);
    let pointY = centerPosY - (y * pixel_step);

    return new Point(pointX, pointY);
}

function fromPixelsToPoints(x, y) {
    let pointX = (x - centerPosX) / pixel_step;
    let pointY = (y - centerPosY) / -pixel_step;

    return new Point(pointX, pointY);
}



// Canvas init
let canvas = document.getElementById('Canvas');
let context = canvas.getContext("2d");

const centerPosX = canvas.offsetHeight / 2;
const centerPosY = canvas.offsetWidth / 2;

let r = document.getElementById("r");
let pixel_step;





// Map sprite
let mapSprite = new Image();
mapSprite.src = "img/areas.jpg";

let Marker = function () {
    this.Sprite = new Image();
    this.Sprite.src = "https://upload.wikimedia.org/wikipedia/commons/thumb/4/48/Bluedot.svg/1200px-Bluedot.svg.png"
    this.Width = 6;
    this.Height = 6;
    this.XPos = 0;
    this.YPos = 0;
}

let Markers = [];

function getClickXY(event) {
    pixel_step = 125 / r.value;

    let point = fromPixelsToPoints(event.offsetX, event.offsetY);
    console.log(point.getX(), point.getY());
}

let mouseClicked = function (mouse) {
    let rect = canvas.getBoundingClientRect();
    let mouseXPos = (mouse.x - rect.left);
    let mouseYPos = (mouse.y - rect.top);

    // Move the marker when placed to a better location
    let marker = new Marker();
    marker.XPos = mouseXPos - (marker.Width / 2);
    marker.YPos = mouseYPos - marker.Height;

    Markers.push(marker);
}

// Add mouse click event listeners to canvas
canvas.addEventListener("click", mouseClicked, false);
canvas.addEventListener('click', getClickXY, false);

let firstLoad = function () {
    /*
    console.log(localStorage['dots']);
    if (localStorage['dots'] !== null) {

    }
     */
}

firstLoad();


let draw = function () {
    // Clear Canvas
    context.fillStyle = "#000000";
    context.fillRect(0, 0, canvas.width, canvas.height);

    // Draw map
    // Sprite, X location, Y location, Image width, Image height
    // You can leave the image height and width off, if you do it will draw the image at default size
    context.drawImage(mapSprite, 0, 0, 350, 350);

    // Draw markers
    for (let i = 0; i < Markers.length; i++) {
        let tempMarker = Markers[i];
        context.drawImage(tempMarker.Sprite, tempMarker.XPos, tempMarker.YPos, tempMarker.Width, tempMarker.Height);
    }
};

setInterval(draw, (1000 / 60)); // Refresh 60 times a second

/*
function saveDots() {
    localStorage.setItem("dots", );
}

setInterval(saveDots, (1000 / 60));
 */