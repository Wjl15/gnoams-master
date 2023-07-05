package niit.wei.servlet;

import com.alibaba.fastjson.JSON;
import niit.wei.dto.Page;
import niit.wei.service.RoleService;
import niit.wei.service.impl.RoleServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/RolePageJsonServlet")
public class RolePageJsonServlet extends HttpServlet {
    private RoleService roleService = new RoleServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageNo = request.getParameter("pageNumber");
        String pageSize = request.getParameter("pageSize");
        Page rolePage = roleService.getRolePage(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
        String jsonString = JSON.toJSONString(rolePage);
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
