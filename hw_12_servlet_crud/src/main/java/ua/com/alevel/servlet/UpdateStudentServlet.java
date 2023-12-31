package ua.com.alevel.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.com.alevel.dao.GroupDaoImpl;
import ua.com.alevel.dao.StudentDaoImpl;
import ua.com.alevel.entity.Group;
import ua.com.alevel.entity.Student;
import ua.com.alevel.service.GroupService;
import ua.com.alevel.service.StudentService;

import java.io.IOException;

@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {
    private StudentService studentService;

    @Override
    public void init() {
        this.studentService = new StudentService(new StudentDaoImpl());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        String name = request.getParameter("name");
        int groupId = Integer.parseInt(request.getParameter("groupId"));

        Group group = new GroupService(new GroupDaoImpl()).getGroupById(groupId);
        Student student = new Student(studentId, name, group);

        studentService.updateStudent(student);
        response.sendRedirect("students.jsp");
    }
}
