package ua.com.alevel.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.com.alevel.entity.Group;
import ua.com.alevel.service.GroupService;
import ua.com.alevel.dao.GroupDaoImpl;
import java.io.IOException;

@WebServlet("/addGroup")
public class AddGroupServlet extends HttpServlet {

    private GroupService groupService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.groupService = new GroupService(new GroupDaoImpl());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String groupName = request.getParameter("groupName");
        Group group = new Group(groupName);
        groupService.addGroup(group);
        response.sendRedirect("groups.jsp");
    }
}
