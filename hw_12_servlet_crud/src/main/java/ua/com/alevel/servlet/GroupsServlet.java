package ua.com.alevel.servlet;

import ua.com.alevel.entity.Group;
import ua.com.alevel.service.GroupService;
import ua.com.alevel.dao.GroupDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/groups")
public class GroupsServlet extends HttpServlet {

    private GroupService groupService;

    @Override
    public void init() throws ServletException {
        super.init();
        // Инициализация GroupService с использованием GroupDaoImpl
        this.groupService = new GroupService(new GroupDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        List<Group> groups = groupService.getAllGroups();

        out.println("<html><body>");
        out.println("<h1>Список групп</h1>");
        out.println("<ul>");
        for (Group group : groups) {
            out.println("<li>" + group.getGroupName() + " (ID: " + group.getGroupId() + ")</li>");
        }
        out.println("</ul>");
        out.println("</body></html>");
    }
}
