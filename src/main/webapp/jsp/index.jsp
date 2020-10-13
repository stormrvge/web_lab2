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
            Вариант 2220 <br>
        </span>
    </header>

    <div class="info">
        <p id="lab1_text">Лабораторная работа №1</p>

        <div class="image">
            <img src="img/areas.jpg">
        </div>

        <div class="input_forms">
            <form method="get" onsubmit="return validateForm();">
                <div class="x">
                    <p> Type X: </p>
                    <div class="x-row">
                        <label for="x1">
                            <input type="checkbox" name="x" value="-4" class="xRadioButton" id="x1" onclick="checkboxValidate(this)">
                            <span class="xText">-4</span>
                        </label>

                        <label for="x2">
                            <input type="checkbox" name="x" value="-3" class="xRadioButton" id="x2" onclick="checkboxValidate(this)">
                            <span class="xText">-3</span>
                        </label>

                        <label for="x3">
                            <input type="checkbox" name="x" value="-2" class="xRadioButton" id="x3" onclick="checkboxValidate(this)">
                            <span class="xText">-2</span>
                        </label>
                    </div>

                    <div class="x-row">
                        <label for="x4">
                            <input type="checkbox" name="x" value="-1" class="xRadioButton" id="x4" onclick="checkboxValidate(this)">
                            <span class="xText">-1</span>
                        </label>

                        <label for="x5">
                            <input type="checkbox" name="x" value="0" class="xRadioButton" id="x5" onclick="checkboxValidate(this)">
                            <span class="xText">&nbsp;0</span>
                        </label>

                        <label for="x6">
                            <input type="checkbox" name="x" value="1" class="xRadioButton" id="x6" onclick="checkboxValidate(this)">
                            <span class="xText">&nbsp;1</span>
                        </label>
                    </div>

                    <div class="x-row">
                        <label for="x7">
                            <input type="checkbox" name="x" value="2" class="xRadioButton" id="x7" onclick="checkboxValidate(this)">
                            <span class="xText">&nbsp;2</span>
                        </label>

                        <label for="x8">
                            <input type="checkbox" name="x" value="3" class="xRadioButton" id="x8" onclick="checkboxValidate(this)">
                            <span class="xText">&nbsp;3</span>
                        </label>

                        <label for="x9">
                            <input type="checkbox" name="x" value="4" class="xRadioButton" id="x9" onclick="checkboxValidate(this)">
                            <span class="xText">&nbsp;4</span>
                        </label>
                    </div>
                </div>

                <div class="y">
                    <label for="y">
                        <span> Enter Y: </span>
                        <span id="yInbound"> ∈ [-3; 3]</span>
                        <input id="y" type="text" name="y" placeholder="Y" oninput="checkInbound(this)">
                    </label>
                </div>

                <div class="r">
                    <input type="hidden" name="r" value="" id="rHiddenButton">
                    Choose R: <br>

                    <label for="r1">
                        <input type="button" name="r1" value="1" class="rButton" onclick="rButtonsValidate(this)">
                    </label>

                    <label for="r2">
                        <input type="button" name="r2" value="2" class="rButton" onclick="rButtonsValidate(this)">
                    </label>

                    <label for="r3">
                        <input type="button" name="r3" value="3" class="rButton" onclick="rButtonsValidate(this)">
                    </label>

                    <label for="r4">
                        <input type="button" name="r4" value="4" class="rButton" onclick="rButtonsValidate(this)">
                    </label>

                    <label for="r5">
                        <input type="button" name="r5" value="5" class="rButton" onclick="rButtonsValidate(this)">
                    </label>
                </div>

                <div class="php_buttons">
                    <input type="submit" id="send_button" name="send">
                    <input type="reset" name="reset" value="Очистить" onclick="clearButtons()">
                </div>
            </form>
        </div>

        <div class="table" id="table">
            <table id="tableAnswer">
                <tr>
                    <td>X</td>
                    <td>Y</td>
                    <td>R</td>
                    <td>Ответ</td>
                    <td>Время</td>
                    <td>Время работы скрипта (мс)</td>
                </tr>
            </table>
        </div>
    </div>



    <footer>
        Footer of the site.
    </footer>
</div>

<script src="http://code.jquery.com/jquery-2.2.4.js" type="text/javascript"></script>
<script type="text/javascript" src="js/validator.js"></script>
<script src="js/ajax-response.js" type="text/javascript"></script>
</body>
</html>