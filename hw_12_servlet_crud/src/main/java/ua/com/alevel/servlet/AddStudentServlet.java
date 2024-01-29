package ua.com.alevel.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.com.alevel.entity.Student;
import ua.com.alevel.entity.Group;
import ua.com.alevel.service.StudentService;
import ua.com.alevel.service.GroupService;
import ua.com.alevel.dao.StudentDaoImpl;
import ua.com.alevel.dao.GroupDaoImpl;
import java.io.IOException;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {

    private StudentService studentService;
    private GroupService groupService;

    @Override
    public void init() {
        studentService = new StudentService(new StudentDaoImpl());
        groupService = new GroupService(new GroupDaoImpl());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int groupId = Integer.parseInt(request.getParameter("groupId"));

        Group group = groupService.getGroupById(groupId);
        Student student = new Student(name, group);
        studentService.addStudent(student);
        response.sendRedirect("students.jsp");
    }
}
