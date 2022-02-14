<%-- 
    Document   : index
    Created on : Feb 12, 2022, 3:52:07 PM
    Author     : salva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actividad 4</title>
    </head>
    <body>
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
