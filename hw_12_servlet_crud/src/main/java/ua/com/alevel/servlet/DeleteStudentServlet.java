package ua.com.alevel.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.com.alevel.dao.StudentDaoImpl;
import ua.com.alevel.service.StudentService;

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
