package niit.wei.servlet;

import niit.wei.entity.Role;
import niit.wei.service.RoleService;
import niit.wei.service.impl.RoleServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/RoleToUpdateServlet")
public class RoleToUpdateServlet extends HttpServlet {
    private RoleService roleService = new RoleServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roleId = request.getParameter("roleId");
        Role role = roleService.getRoleByRoleId(Integer.parseInt(roleId));
        request.setAttribute("role", role);
        request.getRequestDispatcher("role_update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
