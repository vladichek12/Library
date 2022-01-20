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

<div class="logo" >
    <a href="book-list_servlet" ><img src="img/nE0DllVj_m.jpg"></a>
    <link rel="stylesheet" href="css/bookRegistration.css">
</div>
<div class="title">
    <h2>Book registration</h2>
</div>

<form action="${pageContext.request.contextPath}/reader-registration_servlet" method="post" class="registrationForm">
    <p>Reader surname:</p>
    <input type = "text" name = "surname">

    <p>Reader name:</p>
    <input type = "text" name = "name">

    <p>Reader birthday:</p>
    <input type = "date" name = "birthday">

    <p>Reader email:</p>
    <input type = "email" name = "email">

    <p>Reader address:</p>
    <input type = "text" name = "address">

    <br />
    <input type = "submit" value = "Submit"  class = "submitButton"/>
</form>
</body>
</html>
