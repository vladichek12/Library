<%--
  Created by IntelliJ IDEA.
  User: HOME
  Date: 20.12.2021
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Library</title>
</head>
<body>

<h1><%= "BOOK REGISTRATION" %></h1>
<form method = "post" action="index.jsp">
    <input class="flex-box" type = "submit" value="Tut budet norm logo">
</form>

<form action="bookRegistration.jsp" method="get">
    Book title in russian: <input type = "text" name = "russianName">
    <br />
    Book original title: <input type = "text" name = "originalName">
    <br />
    Book genres: <input type = "text" name = "genres">
    <br />
    Book price: <input type = "number" name = "price">
    <br />
    Book number of copies: <input type = "number" name = "numberOfCopies">
    <br />
    Book authors: <input type = "text" name = "authors">
    <br />
    Book cover photo: <input type = "text" name = "coverPhoto">
    <br />
    Book price per day: <input type = "number" name = "pricePerDay">
    <br />
    <input type = "submit" value = "Submit" />
</form>
</body>
</html>
