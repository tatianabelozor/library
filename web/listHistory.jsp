<%-- 
    Document   : listHistory
    Created on : May 10, 2019, 6:46:00 PM
    Author     : User
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список взятий и возврата книг</title>
    </head>
    <body>
          <h1>История взятия и возврата книг</h1>
        <c:forEach var="history" items="${listHistory}">
            <p>${history}</p>
        </c:forEach>
    </body>
</html>
