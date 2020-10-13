<%@ page import="java.util.LinkedList" %>
<%@ page import="model.Response" %>
<%@ page import="model.Table" %>
<%@ page import="java.util.Iterator" %>
<%--
  Created by IntelliJ IDEA.
  User: stormrage
  Date: 08.10.2020
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Table with results</title>
    <style type="text/css">
        body {
            background-color: #e6e6e6;
            font-family: monospace;
            color: black;
        }
        table {
            margin: auto;
            border: 1px solid black;
            border-collapse: collapse;
            text-align: center;
        }
        td {
            border: 1px solid black;
        }
        td:nth-child(-n+3) {
            width: 25px;
        }

    </style>
</head>
<body>
    <table>
        <tr>
            <td>X</td>
            <td>Y</td>
            <td>R</td>
            <td>Ответ</td>
            <td>Время работы скрипта (мс)</td>
        </tr>

        <%
            LinkedList<Response> responses = Table.getResponses();
            Iterator<Response> it = responses.iterator();
            while (it.hasNext()) {
                Response resp = it.next();
                System.out.println("<tr>" +
                        "<td>" + resp.getX() + "</td>" +
                        "<td>" + resp.getY() + "</td>" +
                        "<td>" + resp.getR() + "</td>" +
                        "<td>" + "DATE" + "</td>" +
                        "<td>" + "TIME" + "</td>");
            }
        %>
    </table>
</body>
</html>
