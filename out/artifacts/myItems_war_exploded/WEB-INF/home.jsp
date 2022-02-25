<%@ page import="model.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Item" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home page</title>
</head>
<body>
<% List<Category> categories=(List<Category>) request.getAttribute("categories");%>
<% List<Item> items=(List<Item>) request.getAttribute("items");%>
<% for (Item item : items) {
    int categoryID = item.getCategoryID();

}%>

</body>
</html>
