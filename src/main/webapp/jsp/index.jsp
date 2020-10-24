<%--
  Created by IntelliJ IDEA.
  User: stormrage
  Date: 06.10.2020
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lab 1</title>
    <link rel="shortcut icon" href="img/favicon.ico" type="image/ico">
    <link rel="stylesheet" type="text/css" href="styles/main.css">
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

    <div class="info">
        <p id="lab1_text">Лабораторная работа №2</p>

        <div class="image">
            <img src="img/areas.jpg" alt="areas" id="area">
        </div>

        <div class="input_forms">
            <form method="get">
                <div class="x">
                    <input type="hidden" name="x" value="" id="xHiddenButton">
                    Choose X: <br>

                    <label for="x1">
                        <input type="button" id="x1" value="-2" class="xButton" onclick="xButtonsValidate(this)">
                    </label>

                    <label for="x2">
                        <input type="button" id="x2" value="-1.5" class="xButton" onclick="xButtonsValidate(this)">
                    </label>

                    <label for="x3">
                        <input type="button" id="x3" value="-1" class="xButton" onclick="xButtonsValidate(this)">
                    </label>

                    <label for="x4">
                        <input type="button" id="x4" value="-0.5" class="xButton" onclick="xButtonsValidate(this)">
                    </label>

                    <label for="x5">
                        <input type="button" id="x5" value="0" class="xButton" onclick="xButtonsValidate(this)">
                    </label>

                    <label for="x6">
                        <input type="button" id="x6" value="0.5" class="xButton" onclick="xButtonsValidate(this)">
                    </label>

                    <label for="x7">
                        <input type="button" id="x7" value="1" class="xButton" onclick="xButtonsValidate(this)">
                    </label>

                    <label for="x8">
                        <input type="button" id="x8" value="1.5" class="xButton" onclick="xButtonsValidate(this)">
                    </label>

                    <label for="x9">
                        <input type="button" id="x9" value="2" class="xButton" onclick="xButtonsValidate(this)">
                    </label>
                </div>

                <div class="y">
                    <label for="y">
                        <span> Enter Y: </span>
                        <span id="yInbound"> ∈ [-3; 5]</span>
                        <input id="y" type="text" name="y" placeholder="Y" oninput="checkInboundY(this)">
                    </label>
                </div>

                <div class="r">
                    <label for="r">
                        <span> Enter R: </span>
                        <span id="rInbound"> ∈ [1; 4]</span>
                        <input id="r" type="text" name="r" placeholder="R" oninput="checkInboundR(this)">
                    </label>
                </div>


                <div class="form_buttons">
                    <input type="submit" id="send_button" name="send" onclick="">
                    <input type="reset" name="reset" value="Очистить" onclick="clearButtons()">
                </div>
            </form>
        </div>

        <input type="button" onclick="location.href='${pageContext.request.contextPath}/table';"
               value="Открыть таблицу" class="link_button"/>

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

    <p>Click on the map to place a marker</p>
    <canvas id="Canvas" width="350" height="350"></canvas>


    <footer>
        Footer of the site.
    </footer>
</div>

<script src="http://code.jquery.com/jquery-2.2.4.js" type="text/javascript"></script>
<script type="text/javascript" src="js/validator.js"></script>
<script src="js/indexPageAjax.js" type="text/javascript"></script>
<script src="js/areachecker.js" type="text/javascript"></script>
</body>
</html>