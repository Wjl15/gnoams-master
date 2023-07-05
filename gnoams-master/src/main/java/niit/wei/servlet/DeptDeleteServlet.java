package niit.wei.servlet;

import niit.wei.service.DepartmentService;
import niit.wei.service.impl.DepartmentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/DeptDeleteServlet")
public class DeptDeleteServlet extends HttpServlet {
    private DepartmentService departmentService = new DepartmentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String deptId = request.getParameter("deptId");
        departmentService.deleteDepartment(Integer.parseInt(deptId));
        response.sendRedirect("dept_list.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
