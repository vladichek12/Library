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
    <link rel="stylesheet" href="css/bookRegistration.css">
</head>

<div class="logo" >
    <a href="book-list_servlet" ><img src="img/nE0DllVj_m.jpg"></a>
</div>
<div class="title">
    <h2>Book registration</h2>
</div>

<div class="registrationForm">
<form action="book-registration_servlet" method="post">
    <p>Book title in russian:</p>
    <input type = "text" name = "russianName" class="row" required>

    <p>Book original title:</p>
    <input type = "text" name = "originalName" class="row" required>

    <p>Book genres:</p>
    <select name="genres" size = "5" multiple = "multiple" class="row" required>
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

    <p>Book price:</p>
    <input type = "number" step="0.01" name = "price" min="0" class="row" required>

    <p>Book number of copies:</p>
    <input type = "number" name = "numberOfCopies" min="0" class="row" required>

    <p>Book authors:</p>
    <textarea name ="authors" class="row" required>Input authors</textarea>

    <p>Book cover photo:</p>
    <input type = "text" name = "coverPhoto" class="row" required>

    <p>Book price per day:</p>
    <input type = "number" step="0.01" name = "pricePerDay" min="0" class="row" required>

    <br>
    <input type = "submit" value = "Submit" class="submitButton"/>
</form>
</div>
</body>
</html>
