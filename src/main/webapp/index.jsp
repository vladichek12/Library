<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Library</title>
</head>
<body>
<h1><%= "LIBRARY LOGO" %>
</h1>
<br/>
<div></div>
<form method = "post" action="bookRegistration.jsp">
    <input type = "submit" value="Reg. new book">
</form>

<form method = "post" action="readerRegistration.jsp">
    <input type = "submit" value="Reg. new reader">
</form>

<form method = "post" action="bookLending.jsp">
    <input type = "submit" value="Lend books">
</form>

<form method = "post" action="bookAcceptance.jsp">
    <input type = "submit" value="Accept books">
</form>

<form method = "post" action="bookList.jsp">
    <input type = "submit" value="Show library books">
</form>

</form>
<form method = "post" action="readerList.jsp">
    <input type = "submit" value="Show library readers">
</form>
</body>
</html>