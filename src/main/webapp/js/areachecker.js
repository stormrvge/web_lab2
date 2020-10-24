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

let area = document.getElementById('area');
area.addEventListener('click', getClickXY, false);
let r = document.getElementById("r");

const centerPosX = area.offsetHeight / 2;
const centerPosY = area.offsetWidth / 2;

let pixel_step;

function getClickXY(event) {
    pixel_step = 125 / r.value;
    let testPoint = fromPointsToPixels(2, 3);

    console.log(testPoint.getX(), testPoint.getY());
    console.log(centerPosX, centerPosY);
    console.log(event.offsetX, event.offsetY);
}

function fromPointsToPixels(x, y) {
    let pointX = centerPosX + (x * pixel_step);
    let pointY = centerPosY - (y * pixel_step);

    return new Point(pointX, pointY);
}



