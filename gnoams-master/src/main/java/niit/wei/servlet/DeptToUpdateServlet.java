package niit.wei.servlet;

import niit.wei.entity.Department;
import niit.wei.service.DepartmentService;
import niit.wei.service.impl.DepartmentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/DeptToUpdateServlet")
public class DeptToUpdateServlet extends HttpServlet {
    private DepartmentService departmentService = new DepartmentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String deptId = request.getParameter("deptId");
        Department departmentById = departmentService.getDepartmentById(Integer.parseInt(deptId));
        request.setAttribute("department",departmentById);
        request.getRequestDispatcher("dept_update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
