package niit.wei.servlet;

import niit.wei.entity.Role;
import niit.wei.service.RoleService;
import niit.wei.service.impl.RoleServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/RoleUpdateServlet")
public class RoleUpdateServlet extends HttpServlet {
    private RoleService roleService = new RoleServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status = request.getParameter("example-inline-radios");
        String roleId = request.getParameter("roleId");
        String roleName = request.getParameter("roleName");
        Role role = new Role(Integer.parseInt(roleId),roleName,Integer.parseInt(status));
        roleService.updateRole(role);
        response.sendRedirect("role_list.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
