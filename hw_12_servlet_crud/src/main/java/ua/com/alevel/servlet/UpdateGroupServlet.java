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

@WebServlet("/updateGroup")
public class  UpdateGroupServlet extends HttpServlet {

    private GroupService groupService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.groupService = new GroupService(new GroupDaoImpl());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        String groupName = request.getParameter("groupName");

        Group group = groupService.getGroupById(groupId);
        group.setGroupName(groupName);
        groupService.updateGroup(group);
        response.sendRedirect("groups.jsp");
    }
}
