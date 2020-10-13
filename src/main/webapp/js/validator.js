function checkInbound(input) {
    if (isNaN(input.value) || (input.value < -3 || input.value > 3))
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

function checkboxValidate(input) {
    let checkboxes = document.getElementsByClassName("xRadioButton");

    for (let i = 0; i < checkboxes.length; i++)
    {
        if (checkboxes[i].checked === true) {
            checkboxes[i].checked = false;
        }
    }

    input.checked = input.checked !== true;
}

function rButtonsValidate(input) {
    let buttons = document.getElementsByClassName("rButton");

    let hiddenInput = document.getElementById("rHiddenButton");

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

function validateForm() {
    let checkboxes = document.getElementsByClassName("xRadioButton");
    let checkedButtons = 0;

    let yInput = document.getElementById("y");
    let rButton = document.getElementById("rHiddenButton");

    let check = true;

    for (let i = 0; i < checkboxes.length; i++)
    {
        if (checkboxes[i].checked === true)
            checkedButtons++;
    }

    if (checkedButtons !== 1) {
        document.getElementsByClassName("x")[0].style.backgroundColor = "#ffa6b5";
        check = false;
    } else {
        document.getElementsByClassName("x")[0].style.backgroundColor = "#f7f7f7";
    }

    if (!checkInbound(yInput) || yInput.value === "") {
        document.getElementsByClassName("y")[0].style.backgroundColor = "#ffa6b5";
        check = false;
    } else {
        document.getElementsByClassName("y")[0].style.backgroundColor = "#f7f7f7";
    }

    if (rButton.value < 1 || rButton.value > 5) {
        document.getElementsByClassName("r")[0].style.backgroundColor = "#ffa6b5";
        check = false;
    } else {
        document.getElementsByClassName("r")[0].style.backgroundColor = "#f7f7f7";
    }

    console.log("validate " + check);
    return check;
}


function clearButtons() {
    let buttons = document.getElementsByClassName("rButton");
    document.getElementById("rHiddenButton").value = "";

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