<%@ page import="ua.com.alevel.entity.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список студентов</title>
</head>
<body>
<h2>Список студентов</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Имя</th>
        <th>Группа</th>
        <th>Действия</th>
    </tr>
    <%
        List<Student> students = (List<Student>) request.getAttribute("students");
        for (Student student : students) {
    %>
    <tr>
        <td><%= student.getStudentId() %></td>
        <td><%= student.getName() %></td>
        <td><%= student.getGroup().getGroupName() %></td>
        <td>
            <a href="updateStudent?studentId=<%= student.getStudentId() %>">Редактировать</a>
            <a href="deleteStudent?studentId=<%= student.getStudentId() %>">Удалить</a>
        </td>
    </tr>
    <% } %>
</table>
</body>
</html>
