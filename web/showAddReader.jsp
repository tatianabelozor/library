<%-- 
    Document   : showAddReader
    Created on : May 10, 2019, 5:48:10 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Читатель</title>
    </head>
    <body>
        <form action="createReader" method="POST">
            Имя читателя:<br>
            <input type="text" name="name"><br>
            Фамилия читателя:<br>
            <input type="text" name="surname"><br>
            Телефон:<br>
            <input type="text" name="phone"><br>    
            <input type="submit" name="Создать"><br>
        </form>
    </body>
</html>
