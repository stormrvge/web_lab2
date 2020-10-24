$(document).ready(function () {
    $('#send_button').click(function () {
        $.ajax({
            url: "mainTable",
            type: "get",
            data: {
                x: $('#xHiddenButton').val(),
                y: $('#y').val(),
                r: $('#r').val()
            },
            success: function (response) {
                if (validateForm()) {
                    let table = $('#tableAnswer');
                    let tableColCount = table.find('tr').length;

                    if (tableColCount > 1)
                        table.find('tr').remove('tr:not(:first)')

                    table.append(response);
                }
            }
        })
        return false;
    })
    return false;
});

$(document).ready(function(){
    $.ajax({
        url: "mainTable",
        type: "get",
        success: function(response) {
            let table = $('#tableAnswer');
            table.append(response);
        }});
});

$(document).ready(function () {
        $.ajax({
            url: "mainTable",
            type: "get",
            data: {
                x: $('#xHiddenButton').val(),
                y: $('#y').val(),
                r: $('#r').val()
            },
            success: function (response) {
                    let table = $('#tableAnswer');
                    let tableColCount = table.find('tr').length;

                    if (tableColCount > 1)
                        table.find('tr').remove('tr:not(:first)')

                    table.append(response);
            }
        })
        return false;
});