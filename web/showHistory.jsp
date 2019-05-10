<%-- 
    Document   : showHistory
    Created on : May 10, 2019, 6:45:43 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>История</title>
    </head>
    <body>
        <form action="createHistory" method="POST">
            ID книги:<br>
            <input type="text" name="ID"><br>
            Читатель:<br>
            <input type="text" name="reader"><br>
            Книга:<br>
            <input type="text" name="book"><br>    
            Дата взятия книги:<br>
            <input type="text" name="dateTakeBook"><br>  
            Дата возврата книги:<br>
            <input type="text" name="dateReturnBook"><br>              
            <input type="submit" name="Создать"><br>
        </form>
    </body>
</html>
