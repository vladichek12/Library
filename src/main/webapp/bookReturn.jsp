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
    <title>Title</title>
</head>
<body>
<p>Reader:${reader.getName()} ${reader.getSurname()}</p>
<p>Choose books from return</p>
<form method="post" action="book-return">
    <select id = "books" multiple = "multiple" name = "booksItems">
        <c:forEach var ="element" items = "${books}">
            <option value = ${element.getId()}>${element.getOriginalName()}</option>
        </c:forEach>
    </select>
    <br>
    <input type = "submit" value = "Submit" />
</form>

</body>
</html>
