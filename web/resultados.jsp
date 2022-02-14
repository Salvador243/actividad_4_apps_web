<%-- 
    Document   : index
    Created on : Feb 12, 2022, 3:52:07 PM
    Author     : salva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actividad 4</title>
    </head>
    <body>
        <table border="4px">
            <tr>
                <td></td>
                <td>Cliente</td>
                <td>Servidor</td>
            </tr>
            <tr>
                <td>Juega</td>
                <td> <% out.println(request.getAttribute("cliente")); %> </td>
                <td> <% out.println(request.getAttribute("servidor")); %> </td>
            </tr>
            <tr>
                <td>Jugada Ganadora</td>
                <td colspan="2"><% out.println(request.getAttribute("ganadas")); %></td>
            </tr>
            <tr>
                <td>Jugadas Ganadas</td>
                <td><% out.println(request.getAttribute("ganada_cli")); %></td>
                <td><% out.println(request.getAttribute("ganada_ser")); %></td>
            </tr>
            <tr>
                <td>Jugadas Empatadas</td>
                <td colspan="2"><% out.println(request.getAttribute("empates")); %></td>
            </tr>
            <tr>
                <td>Partidas Ganadas</td>
                <td><% out.println(request.getAttribute("win_server")); %></td>
                <td><% out.println(request.getAttribute("win_cliente")); %></td>
            </tr>
            <tr>
                <td>Partidas Empatadas</td>
                <td colspan="2"><% out.println(request.getAttribute("win_empate")); %></td>
            </tr>
        </table>
        <fieldset>
            <legend>Juego Piedra, Papel o Tijeras</legend>
            <form action="server" method="post">
                <label>piedra</label>
                <input type="checkbox" name="tiro" value="1">
                <label>papel</label>
                <input type="checkbox" name="tiro" value="2">
                <label>tijera</label>
                <input type="checkbox" name="tiro" value="3">
                <br>
                <button type="submit">Jugar</button>
            </form>
        </fieldset>
    </body>
</html>
