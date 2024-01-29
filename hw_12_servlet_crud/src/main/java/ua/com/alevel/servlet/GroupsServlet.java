package ua.com.alevel.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.com.alevel.dao.GroupDaoImpl;
import ua.com.alevel.entity.Group;
import ua.com.alevel.service.GroupService;

import java.io.IOException;
import java.util.List;

@WebServlet("/groups")
public class GroupsServlet extends HttpServlet {

    private GroupService groupService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.groupService = new GroupService(new GroupDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Group> groups = groupService.getAllGroups();
        request.setAttribute("groups", groups);
        request.getRequestDispatcher("/path/to/groups.jsp").forward(request, response);
    }
}
