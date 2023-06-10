<%-- 
    Document   : MyNewGame
    Created on : 01-Sep-2020, 16:51:16
    Author     : acer
--%>

<%@page import="primoAppello.Minesweeper"%>
<%@page import="primoAppello.Cell"%>
<%@page import="primoAppello.Bomb"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"  session="true" %>
<%@page import="primoAppello.Field" %>

<% 
    String sid = session.getId();
    Minesweeper ms = (Minesweeper) session.getAttribute("minesweeper");
    String name = (String) request.getParameter("player_name");
    if (ms == null) ms = new Minesweeper(); 
    if (session.getAttribute("name") == null) session.setAttribute("name", name);
    session.setAttribute("minesweeper",ms);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../resources/css/styles.css">
        <script src="../resources/javascript/operations.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello <%= session.getAttribute("name") %>!</h1>
        
        <table border="0" id="ms-table">
            
            <% for (int i = 0; i < ms.MAXDIM; i++) { %>
            <tr>
                <% for (int j = 0; j < ms.MAXDIM; j++) { %>
                <td id="cell-<%= i + "" + j %>" 
                    class="cell-box <% if(ms.emptyField[i][j] instanceof Bomb) out.print("bomb"); %>" 
                    onclick='loadDoc(<%= i + "," + j %>)'>
                    <%= ms.emptyField[i][j].content %>
                </td>
                <% } %>
            </tr>
            <% } %>
            
        </table>
            
        <br>
        <input type="submit" value="Test" onclick='loadDoc(null)'>
        <select id="row">
            <% for (int i = 1; i <= ms.MAXDIM; i++) out.print("<option>" + i + "</option>"); %>
        </select>
        <select id="column">
            <% for (int i = 1; i <= ms.MAXDIM; i++) out.print("<option>" + i + "</option>"); %>
        </select>
        <span id="result"></span>
        <br>
        <form action="../Destroy"><input type="submit" value="Restart"></form>
     
    </body>
</html>
