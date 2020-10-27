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
    pixel_step = 125 / r.value;

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

let MarkersMap = new Map();



// Map sprite
let spriteImage = "https://upload.wikimedia.org/wikipedia/commons/thumb/4/48/Bluedot.svg/1200px-Bluedot.svg.png";
let redDotSprite = "https://upload.wikimedia.org/wikipedia/commons/0/0e/Basic_red_dot.png";
let mapSprite = new Image();
mapSprite.src = "img/areas.jpg";

let Marker = function () {
    this.Sprite = new Image();
    this.Sprite.src = spriteImage;
    this.Width = 6;
    this.Height = 6;
    this.XPos = 0;
    this.YPos = 0;
    this.pixel_step = 0;
    this.XPoint = 0;
    this.YPoint = 0;
    this.hit = false;
    this.r = r.value;
}

let Markers = [];
let allMarkers = [];
let mouseClicked = function (mouse) {
    if (r.value >= 1 && r.value <= 4) {
        pixel_step = 125 / r.value;


        let point = fromPixelsToPoints(mouse.offsetX, mouse.offsetY);
        console.log(point.getX(), point.getY());

        let rect = canvas.getBoundingClientRect();
        let mouseXPos = (mouse.x - rect.left);
        let mouseYPos = (mouse.y - rect.top);

        // Move the marker when placed to a better location
        let marker = new Marker();
        marker.XPos = mouseXPos - (marker.Width / 2);
        marker.YPos = mouseYPos - marker.Height;
        marker.pixel_step = pixel_step;
        marker.XPoint = point.getX();
        marker.YPoint = point.getY();


        if ((marker.XPoint >= -2 && marker.XPoint <= 2) && (marker.YPoint >= -3 && marker.YPoint <= 5)) {
            Markers.push(marker);
            allMarkers.push(marker);

            $.ajax({
                url: "lab2",
                type: "get",
                data: {
                    x: Number((marker.XPoint).toFixed(2)),
                    y: Number((marker.YPoint).toFixed(2)),
                    r: $('#r').val(),
                    pic: "true"
                },

                success: function (response) {
                    let answer = response.split("ENDOFTABLE\n");

                    let table = $('#tableAnswer');
                    let tableColCount = table.find('tr').length;

                    if (tableColCount > 1)
                        table.find('tr').remove('tr:not(:first)')

                    table.append(answer[0]);
                    if (answer[1] === "true") {
                        marker.Sprite.src = spriteImage;
                        marker.hit = true;
                    } else {
                        marker.Sprite.src = redDotSprite;
                        marker.hit = false;
                    }
                }
            });
        } else {
            $('.error_message').text('Данная точка не входит в множество');
            setTimeout(function() {
                $('.error_message').text(' ')
            }, 4000);
        }
    } else {
        $('.error_message').text('Выберите радиус для r');
        setTimeout(function() {
            $('.error_message').text(' ')
        }, 4000);
    }
}

// Add mouse click event listeners to canvas
canvas.addEventListener("click", mouseClicked, false);
//canvas.addEventListener('click', getClickXY, false);

let firstLoad = function () {
    let tempMarkers;
    try {
        tempMarkers = JSON.parse(sessionStorage.getItem("dots"));
    } catch (e) {
        console.log(e);
    }

    console.log(tempMarkers);
    if (tempMarkers !== undefined && tempMarkers !== null) {
        Markers = tempMarkers;
        for (let i = 0; i < Markers.length; i++) {
            Markers[i].Sprite = new Image();
            if (Markers[i].hit === true) {
                Markers[i].Sprite.src = spriteImage;
            } else {
                Markers[i].Sprite.src = redDotSprite;
            }
        }
    }

    if (tempMarkers === null) {
        Markers = [];
    }
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

r.addEventListener('input', updateRadius);

function updateRadius() {
    Markers = [];
    sessionStorage.setItem("dots", Markers);
}

function saveDots() {
    sessionStorage.setItem("dots", JSON.stringify(Markers));
}

setInterval(saveDots, 0.01);
