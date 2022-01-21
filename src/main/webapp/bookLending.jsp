<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HOME
  Date: 20.12.2021
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Library</title>
    <link rel="stylesheet" href="css/bookRegistration.css">
</head>
<body>
<div class="logo" >
    <a href="book-list_servlet" ><img src="img/nE0DllVj_m.jpg"></a>
</div>
<div class="title">
    <h2>Book lending</h2>
</div>


<div class="registrationForm">
    <form method="post" action="book-lending_servlet">

        <p>Reader surname:</p>
        <input type = "text" name = "surname" required>

        <p>Reader name:</p>
        <input type = "text" name = "name" required>

        <p>Reader birthday:</p>
        <input type = "date" name = "birthday" required>

        <p>Reader email:</p>
        <input type = "email" name = "email" required>

        <p>Reader address:</p>
        <input type = "text" name = "address" required>


        <p>choose books from lending</p>
        <select id = "books" multiple = "multiple" name = "booksItems" required>
            <c:forEach var ="element" items = "${lendingBooks}">
                <option value = ${element.getId()}>${element.getOriginalName()}</option>
            </c:forEach>
        </select>
        <br>
        <input type = "submit" value = "Submit"  class="submitButton"/>
    </form>
</div>

</body>
</html>
