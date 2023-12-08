package ua.com.alevel.servlet;

import ua.com.alevel.dao.StudentDaoImpl;
import ua.com.alevel.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {
    private StudentService studentService;

    @Override
    public void init() {
        this.studentService = new StudentService(new StudentDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("studentId"));

        studentService.deleteStudent(studentId);
        response.sendRedirect("students.jsp");
    }
}
