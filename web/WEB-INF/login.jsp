<%--
  Created by IntelliJ IDEA.
  User: Asya
  Date: 25.02.2022
  Time: 00:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="/login" method="post">
    <label for="email"></label><br>
    <input type="email" id="email" name="email" placeholder="Input your email"><br>
    <label for="password" ></label><br>
    <input type="password" id="password" name="password" placeholder="Input your password" ><br>
    <input type="submit" value="LOGIN">
</form>

</body>
</html>
