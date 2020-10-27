function xButtonsValidate(input) {
    let buttons = document.getElementsByClassName("xButton");
    let hiddenInput = document.getElementById("xHiddenButton");
    hiddenInput.value = input.value;

    for (let i = 0; i < buttons.length; i++)
    {
        if (buttons[i].className.includes(" greenButton"))
            buttons[i].className = buttons[i].className.replace(" greenButton", "");
    }

    input.className = input.className + " greenButton";
}

function checkInboundY(input) {
    if (isNaN(input.value) || (input.value < -3 || input.value > 5) && !input.className.includes("error")) {
        input.className = input.className + " error";
    } else {
        input.className = input.className.replace(" error", "");
        return true;
    }
}

function checkInboundR(input) {
    if (isNaN(input.value) || (input.value < 1 || input.value > 4) && !input.className.includes("error")) {
        input.className = input.className + " error";
    } else {
        input.className = input.className.replace(" error", "");
        return true;
    }
}

function validateForm() {
    let xButton = document.getElementById("xHiddenButton");
    let yInput = document.getElementById("y");
    let rInput = document.getElementById("r");

    let check = true;

    if (xButton.value === "" || (xButton.value < -2 || xButton.value > 2)) {
        errorBackground("x");
        check = false;
    } else {
        document.getElementsByClassName("x")[0].style.backgroundColor = "#f7f7f7";
    }

    if (!checkInboundY(yInput) || yInput.value === "") {
        errorBackground("y");
        check = false;
    } else {
        document.getElementsByClassName("y")[0].style.backgroundColor = "#f7f7f7";
    }

    if (!checkInboundR(rInput) || rInput.value === "") {
        errorBackground("r");
        check = false;
    } else {
        document.getElementsByClassName("r")[0].style.backgroundColor = "#f7f7f7";
    }

    if (check === false)
        printError("Данная точка не входит в множество");

    return check;
}


function clearButtons() {
    let buttons = document.getElementsByClassName("xButton");
    document.getElementById("xHiddenButton").value = "";

    for (let i = 0; i < buttons.length; i++)
    {
        if (buttons[i].className.includes(" greenButton"))
            buttons[i].className = buttons[i].className.replace(" greenButton", "");
    }

    document.getElementsByClassName("x")[0].style.backgroundColor = "#f7f7f7";
    document.getElementsByClassName("y")[0].style.backgroundColor = "#f7f7f7";
    document.getElementsByClassName("r")[0].style.backgroundColor = "#f7f7f7";
}

let errorBackground = function (classname) {
    document.getElementsByClassName(classname)[0].style.backgroundColor = "#ffa6b5";
    setTimeout(function() {
        document.getElementsByClassName(classname)[0].style.backgroundColor = "#f7f7f7";
    }, 4000);
}

function clearTable() {
    Markers = [];
    localStorage.setItem("dots", Markers);

    $.ajax({
        url: "lab2",
        type: "post",
        data: { clearTable: "true" },
        success: function() {
            location.reload();
        }});
}