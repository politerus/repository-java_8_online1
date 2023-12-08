<%@ page import="ua.com.alevel.entity.Group" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список групп</title>
</head>
<body>
<h2>Список групп</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Название группы</th>
        <th>Действия</th>
    </tr>
    <%
        List<Group> groups = (List<Group>) request.getAttribute("groups");
        for (Group group : groups) {
    %>
    <tr>
        <td><%= group.getGroupId() %></td>
        <td><%= group.getGroupName() %></td>
        <td>
            <a href="updateGroup?groupId=<%= group.getGroupId() %>">Редактировать</a>
            <a href="deleteGroup?groupId=<%= group.getGroupId() %>">Удалить</a>
        </td>
    </tr>
    <% } %>
</table>
</body>
</html>
