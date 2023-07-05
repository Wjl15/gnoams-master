package niit.wei.servlet;

import niit.wei.entity.Department;
import niit.wei.service.DepartmentService;
import niit.wei.service.impl.DepartmentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/DeptUpdateServlet")
public class DeptUpdateServlet extends HttpServlet {
    private DepartmentService departmentService = new DepartmentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Department department = new Department();
        String deptId = request.getParameter("deptId");
        department.setDeptId(Integer.parseInt(deptId));
        String deptName = request.getParameter("deptName");
        System.out.println(deptName);
        department.setDeptName(deptName);
        String createTime = request.getParameter("createTime");
        System.out.println(createTime);
        try {
            Date parse = sf.parse(createTime);
            department.setCreateTime(parse);
            departmentService.updateDepartment(department);
            response.sendRedirect("dept_list.jsp");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
