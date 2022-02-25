<%@ page import="model.Item" %>
<%@ page import="java.util.List" %>
<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: Asya
  Date: 24.02.2022
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User page</title>
</head>
<body>
<%

    User user = (User) session.getAttribute("user");
%>
Welcome <%= user.getName()%>
<a href="/addItem">ավելացնել</a>
<a href="/myItems">իմ հայտարարությունները</a>
<a href="/logout">logout</a><br>

</body>
</html>
