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

<form action="book-registration_servlet" method="post">
    Book title in russian: <input type = "text" name = "russianName">
    <br />
    Book original title: <input type = "text" name = "originalName">
    <br />
<%--    Book genres: <input type = "text" name = "genres">--%>
    Book genres:
    <select name="genres" size = "5" multiple = "multiple" >
        <option disabled>choose genres </option>
        <option value="Crime">Crime</option>
        <option value="Detective">Detective</option>
        <option value="Science">Science</option>
        <option value="Distopia">Distopia</option>
        <option value="Cyberpunk">Cyberpunk</option>
        <option value="Fantasy">Fantasy</option>
        <option value="Western">Western</option>
        <option value="Horror">Horror</option>
        <option value="Classic">Classic</option>
        <option value="Folklore">Folklore</option>
        <option value="Humor">Humor</option>
        <option value="Mystery">Mystery</option>
        <option value="Thriller">Thriller</option>
        <option value="Biography">Biography</option>
        <option value="Autobiography">Autobiography</option>
        <option value="Essay">Essay</option>
        <option value="Journalism">Journalism</option>
        <option value="Memoir">Memoir</option>
        <option value="Encyclopedia">Encyclopedia</option>
        <option value="Dictionary">Dictionary</option>
        <option value="Cookbook">Cookbook</option>
    </select>
    <br />
    Book price: <input type = "number" step="0.01" name = "price">
    <br />
    Book number of copies: <input type = "number" name = "numberOfCopies">
    <br />
    Book authors:
<%--    <input type = "text" name = "authors">--%>
    <textarea name ="authors">Input authors</textarea>
    <br />
    Book cover photo: <input type = "text" name = "coverPhoto">
    <br />
    Book price per day: <input type = "number" step="0.01" name = "pricePerDay">
    <br />
    <input type = "submit" value = "Submit" />
</form>
</body>
</html>
