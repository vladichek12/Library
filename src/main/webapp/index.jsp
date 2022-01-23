<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Library</title>
    <link rel="stylesheet" href="css/index.css">
    <script src="js/sort.js"></script>
</head>
<body>
<div class="logo" >
    <a href="book-list_servlet" ><img src="img/nE0DllVj_m.jpg"></a>
</div>
<div class="nav">
    <nav>
        <ul>
            <li><a href="bookRegistration.jsp" class="button">Register a new book</a></li>
            <li><a href="readerRegistration.jsp" class="button">Register a new reader</a></li>
            <li><a href="book-lending_servlet" class="button">Lend books</a></li>
            <li><a href="bookAcceptance.jsp" class="button">Accept books</a></li>
        </ul>
    </nav>
</div>

<hr>

<div class="books">
    <table id = "sortable">
        <tr>
            <td >Russian title</td>
            <td>Genres</td>
            <td>Registration date</td>
            <td>Number of available copies</td>
        </tr>
        <tbody>
        <c:forEach var ="element" items = "${books}">

            <tr>
                <td>${element.getRussianName()}</td>
                <td>
                    <c:forEach var="genre" items="${element.getGenres()}">
                        <p>${genre}</p>
                    </c:forEach>
                </td>
                <td>${element.getRegistrationDate()}</td>
                <td>${element.getNumberOfCopies()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>
</html>