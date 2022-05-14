<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Power Plant Details</title>
    <link rel="stylesheet" type="text/css" href="text.css" media="screen" />

 <link rel="stylesheet" href="Views/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script type="text/javascript">
$(document).ready(function () {
    $.getJSON("http://localhost:8080/crud/webapi/powerplants/retrieve",
    function (json) {
        var tr;
        for (var i = 0; i < json.length; i++) {
            tr = $('<tr/>');
            tr.append("<td>" + json[i].id + "</td>");
            tr.append("<td>" + json[i].name + "</td>");
            tr.append("<td>" + json[i].type + "</td>");
            tr.append("<td>" + json[i].address + "</td>");
            tr.append("<td>" + json[i].capacity + "</td>");
            

            $('table').append(tr);
        }
    });
});
</script>
        <a href="create.jsp">Create</a>

</head>
<body>
<div align="left" style="margin-top: 10%;">
    <fieldset style="border: none;">
        <legend><strong>Power Plants List</strong></legend>
        <!-- table to show data -->
        <table class="greyGridTable">
            <thead>
            <tr>
                <th>ID      </th>
                <th>Name    </th>
                <th>Type    </th>
                <th>Address </th>
                <th>Capacity</th>
                
                
                
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </fieldset>
</div>
</body>
</html>