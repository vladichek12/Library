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
</head>
<body>
<h1><%= "BOOK LENDING" %></h1>
<form method = "post" action="index.jsp">
    <input type = "submit" value="Tut budet norm logo">
</form>

<p>input info about reader</p>
<form method="post" action="book-lending_servlet">
    Reader surname: <input type = "text" name = "surname">
    <br />
    Reader name: <input type = "text" name = "name">
    <br />
    Reader birthday: <input type = "date" name = "birthday">
    <br />
    Reader email: <input type = "email" name = "email">
    <br />
    Reader address: <input type = "text" name = "address">
    <br />
    <p>choose books</p>

    <select id = "books" multiple = "multiple" name = "booksItems">
        <c:forEach var ="element" items = "${lendingBooks}">
            <option value = ${element.getId()}>${element.getOriginalName()}</option>
        </c:forEach>
    </select>
    <br>
    <input type = "submit" value = "Submit" />
</form>

</body>
</html>
