$(document).ready(function () {
    $('#send_button').click(function () {
        $.ajax({
            url: "table",
            type: "get",
            data: {
                x: $('#x').val(),
                y: $('#y').val(),
                r: $('#rHiddenButton').val()
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
    })
    return false;
});

$(document).ready(function(){
    $.ajax({
        url: "table",
        success: function(response) {
            let table = $('#tableAnswer');
            table.append(response);
        }});
});