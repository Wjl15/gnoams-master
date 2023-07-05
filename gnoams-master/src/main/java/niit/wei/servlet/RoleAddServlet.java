package niit.wei.servlet;

import niit.wei.entity.Role;
import niit.wei.service.RoleService;
import niit.wei.service.impl.RoleServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/RoleAddServlet")
public class RoleAddServlet extends HttpServlet {
    private RoleService roleService = new RoleServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roleName = request.getParameter("roleName");
        String status = request.getParameter("example-inline-radios");
        Role role = new Role();
        role.setRoleName(roleName);
        role.setStatus(Integer.parseInt(status));
        roleService.addRole(role);
        response.sendRedirect("role_list.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
