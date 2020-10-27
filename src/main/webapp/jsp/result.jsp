<%--
  Created by IntelliJ IDEA.
  User: stormrage
  Date: 27.10.2020
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="styles/main.css">
    <title>Table with results</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <meta charset="utf-8">
</head>
<body>
<div class="container">
    <header class="header">
        <img src="img/logo.png">
        <span id="header_text">
            	Свистухин Андрей Николаевич <br>
            	P3211 <br>
            	Вариант 2445 <br>
        	</span>
    </header>

    <div class="image">
        <canvas id="Canvas" width="350" height="350"></canvas>
    </div>

    <div class="info">
        <input type="button" onclick="location.href='${pageContext.request.contextPath}/lab2';"
               value="Новый запрос" class="link_button"/>
        <p id="lab1_text">Результат</p>
    </div>


    <div class="table" id="table">
        <table id="tableAnswer">
            <tr>
                <td>X</td>
                <td>Y</td>
                <td>R</td>
                <td>Ответ</td>
                <td>Время</td>
                <td>Время работы скрипта (мкс)</td>
            </tr>

        </table>
    </div>
</div>
</body>

<script src="http://code.jquery.com/jquery-2.2.4.js" type="text/javascript"></script>
<script type="text/javascript" src="js/tablePageAjax.js"></script>
</html>
