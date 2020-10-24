$(document).ready(function(){
    $.ajax({
        url: "tableServlet",
        type: "get",
        success: function(response) {
            let table = $('#tableAnswer');
            table.append(response);
        }});
});