<%--
  Created by IntelliJ IDEA.
  User: Asya
  Date: 25.02.2022
  Time: 00:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
Register user:<br>
<form action="/register" method="post" enctype="multipart/form-data">
    Name: <input type="text" name="name"/><br>
    Surname: <input type="text" name="surname"/><br>
    email: <input type="email" name="email"/><br>
    password: <input type="password" name="password"/><br>
    <input type="submit" value="Գրանցվել">
</form>

</body>
</html>
