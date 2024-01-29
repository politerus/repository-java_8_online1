<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ua.com.alevel.entity.Group" %>
<%@ page import="java.util.List" %>
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
    </tr>
    <%
        List<Group> groups = (List<Group>) request.getAttribute("groups");
        for (Group group : groups) {
    %>
    <tr>
        <td><%= group.getGroupId() %></td>
        <td><%= group.getGroupName() %></td>
    </tr>
    <% } %>
</table>
</body>
</html>
