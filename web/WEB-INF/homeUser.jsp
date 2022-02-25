<%@ page import="model.Item" %>
<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<%@ page import="model.Category" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Home</title>
</head>
<body>
<%List<Item> allItems = (List<Item>) request.getAttribute("items");%>
<% List<User> users = (List<User>) request.getAttribute("users");%>
<% List<Category> categories = (List<Category>) request.getAttribute("categories");%>
My all items:
<table border="1">

    <tr>
        <th>title</th>
        <th>price</th>
        <th>image</th>
        <th>Delete item</th>

    </tr>
    <%
        for (Item item : allItems) { %>
    <tr>
        <td><%=item.getTitle()%>
        </td>
        <td><%=item.getPrice()%>
        </td>
        <td><%=item.getPictureUrl()%>
        </td>
        <td><a href="/deleteItem"> Delete</a></td>
    </tr>

    </tr>
    <% }

    %>


</table>
Add item:
<form action="/addItem" method="post">
    Title: <input type="text" name="title"/><br>
    Price: <input type="text" name="price"/><br>
    Category_id: <select name="category_id">
    <%
        for (Category category : categories) {%>
    <option value="<%=category.getId()%>"><%=category.getName()%>
    </option>
    <%
        }
    %>
</select><br>
    Image<input type="file" name="pic_url">
    User_id: <select name="user_id">
    <%
        for (User user : users) {%>
    <option value="<%=user.getId()%>"><%=user.getName()%><%=user.getSurname()%>
    </option>
    <%
        }
    %>
</select><br>
    <input type="submit" value="ok">
</form>
</body>
</html>
