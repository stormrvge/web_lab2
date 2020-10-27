function xButtonsValidate(input) {
    let buttons = document.getElementsByClassName("xButton");

    let hiddenInput = document.getElementById("xHiddenButton");

    hiddenInput.value = input.value;
    console.log(hiddenInput.value);

    for (let i = 0; i < buttons.length; i++)
    {
        if (buttons[i].className.includes(" greenButton"))
        {
            buttons[i].className = buttons[i].className.replace(" greenButton", "");
        }
    }

    input.className = input.className + " greenButton";
}

function checkInboundY(input) {
    if (isNaN(input.value) || (input.value < -3 || input.value > 5))
    {
        if (!input.className.includes("error")) {
            input.className = input.className + " error";
        }
    }
    else
    {
        input.className = input.className.replace(" error", "");
        return true;
    }
}

function checkInboundR(input) {
    if (isNaN(input.value) || (input.value < 1 || input.value > 4))
    {
        if (!input.className.includes("error")) {
            input.className = input.className + " error";
        }
    }
    else
    {
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
        document.getElementsByClassName("x")[0].style.backgroundColor = "#ffa6b5";
        setTimeout(function() {
            document.getElementsByClassName("x")[0].style.backgroundColor = "#f7f7f7";
        }, 4000);

        check = false;
    } else {
        document.getElementsByClassName("x")[0].style.backgroundColor = "#f7f7f7";
    }


    if (!checkInboundY(yInput) || yInput.value === "") {
        document.getElementsByClassName("y")[0].style.backgroundColor = "#ffa6b5";
        setTimeout(function() {
            document.getElementsByClassName("y")[0].style.backgroundColor = "#f7f7f7";
        }, 4000);

        check = false;
    } else {
        document.getElementsByClassName("y")[0].style.backgroundColor = "#f7f7f7";
    }

    if (!checkInboundR(rInput) || rInput.value === "") {
        document.getElementsByClassName("r")[0].style.backgroundColor = "#ffa6b5";
        setTimeout(function() {
            document.getElementsByClassName("r")[0].style.backgroundColor = "#f7f7f7";
        }, 4000);

        check = false;
    } else {
        document.getElementsByClassName("r")[0].style.backgroundColor = "#f7f7f7";
    }


    if (check === false) {
        $('.error_message').text('Данная точка не входит в множество');
        setTimeout(function() {
            $('.error_message').text(' ')
        }, 4000);
    }

    return check;
}


function clearButtons() {
    let buttons = document.getElementsByClassName("xButton");
    document.getElementById("xHiddenButton").value = "";

    for (let i = 0; i < buttons.length; i++)
    {
        if (buttons[i].className.includes(" greenButton"))
        {
            buttons[i].className = buttons[i].className.replace(" greenButton", "");
        }
    }

    document.getElementsByClassName("x")[0].style.backgroundColor = "#f7f7f7";
    document.getElementsByClassName("y")[0].style.backgroundColor = "#f7f7f7";
    document.getElementsByClassName("r")[0].style.backgroundColor = "#f7f7f7";
}

function clearTable() {
    Markers = [];
    localStorage.setItem("dots", Markers);

    $.ajax({
        url: "lab2",
        type: "post",
        data: {
            clearTable: "true",
        },
        success: function(answer) {
            location.reload();
            console.log("REQUEST SENT");
        }});
}