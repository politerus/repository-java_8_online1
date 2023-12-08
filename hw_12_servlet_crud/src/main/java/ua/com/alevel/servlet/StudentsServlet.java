package ua.com.alevel.servlet;

import ua.com.alevel.dao.StudentDaoImpl;
import ua.com.alevel.entity.Student;
import ua.com.alevel.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/students")
public class StudentsServlet extends HttpServlet {

    private StudentService studentService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.studentService = new StudentService(new StudentDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        List<Student> students = studentService.getAllStudents();

        out.println("<html><body>");
        out.println("<h1>Список студентов</h1>");
        out.println("<ul>");
        for (Student student : students) {
            out.println("<li>" + student.getName() + " (ID: " + student.getStudentId() +
                    ", Группа: " + (student.getGroup() != null ? student.getGroup().getGroupName() : "Нет группы") +
                    ")</li>");
        }
        out.println("</ul>");
        out.println("</body></html>");
    }
}
