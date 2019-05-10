<%-- 
    Document   : listReader
    Created on : May 10, 2019, 6:10:04 PM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список читателей</title>
    </head>
    <body>
        <h1>Наши читатели</h1>
        <c:forEach var="reader" items="${listReaders}">
         <p>${reader}</p>   
        </c:forEach>
    </body>
</html>
