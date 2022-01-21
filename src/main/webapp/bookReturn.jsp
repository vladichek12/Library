<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HOME
  Date: 19.01.2022
  Time: 18:17
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
<br>
<div class="registrationForm">

    <form method="post" action="book-return">
        <p>Reader:${reader.getName()} ${reader.getSurname()}</p>
        <p>Choose books from return</p>
        <select id = "books" multiple = "multiple" name = "booksItems" required>
            <c:forEach var ="element" items = "${books}">
                <option value = ${element.getId()}>${element.getOriginalName()}</option>
            </c:forEach>
        </select>
        <br>
        <input type = "submit" value = "Submit" class="submitButton"/>
    </form>
</div>


</body>
</html>
