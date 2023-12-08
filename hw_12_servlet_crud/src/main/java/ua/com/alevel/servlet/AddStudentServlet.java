package ua.com.alevel.servlet;

import ua.com.alevel.dao.GroupDaoImpl;
import ua.com.alevel.dao.StudentDaoImpl;
import ua.com.alevel.entity.Group;
import ua.com.alevel.entity.Student;
import ua.com.alevel.service.GroupService;
import ua.com.alevel.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "AddStudentServlet", urlPatterns = {"/addStudent"})
public class AddStudentServlet extends HttpServlet {
    private StudentService studentService; // Сервис для работы со студентами

    @Override
    public void init() {
        studentService = new StudentService(new StudentDaoImpl());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int groupId = Integer.parseInt(request.getParameter("groupId"));

        Group group = new GroupService(new GroupDaoImpl()).getGroupById(groupId);
        Student student = new Student();
        student.setName(name);
        student.setGroup(group);

        studentService.addStudent(student);
        response.sendRedirect("students.jsp"); // Перенаправление на страницу со списком студентов
    }
}
