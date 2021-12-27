<%--
  Created by IntelliJ IDEA.
  User: HOME
  Date: 20.12.2021
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Library</title>
</head>
<body>

<h1><%= "READER REGISTRATION" %></h1>
<form method = "post" action="index.jsp">
    <input type = "submit" value="Tut budet norm logo">
</form>

<form action="bookRegistration.jsp" method="get">
    Reader surname: <input type = "text" name = "surname">
    <br />
    Reader name: <input type = "text" name = "name">
    <br />
    Reader birthday: <input type = "date" name = "birthday">
    <br />
    Reader email: <input type = "text" name = "email">
    <br />
    Reader address: <input type = "text" name = "address">
    <br />
    <input type = "submit" value = "Submit" />
</form>
</body>
</html>
