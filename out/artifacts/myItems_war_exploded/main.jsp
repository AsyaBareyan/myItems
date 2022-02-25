<%@ page import="model.Category" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Asya
  Date: 24.02.2022
  Time: 02:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>myItems.am</title>
  </head>
  <body>
  <% List<Category> categories=(List<Category>) request.getAttribute("categories");%>
  <a href="/">Գլխավոր էջ</a>
  <a href="/login">Լոգին</a>
  <a href="/register">Գրանցում</a>
  <% for (Category allCategories:categories) {%>
  <a href="/"><%=allCategories.getName()%></a>

}</a>
  </body>
</html>
