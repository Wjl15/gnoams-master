package niit.wei.servlet;

import niit.wei.entity.Department;
import niit.wei.entity.Employee;
import niit.wei.entity.Role;
import niit.wei.service.DepartmentService;
import niit.wei.service.EmployeeService;
import niit.wei.service.RoleService;
import niit.wei.service.impl.DepartmentServiceImpl;
import niit.wei.service.impl.EmployeeServiceImpl;
import niit.wei.service.impl.RoleServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/EmployeeToUpdateServlet")
public class EmployeeToUpdateServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceImpl();
    private DepartmentService departmentService = new DepartmentServiceImpl();
    private RoleService roleService = new RoleServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empId = request.getParameter("empId");
        Employee employeeById = employeeService.getEmployeeById(Integer.parseInt(empId));
        request.setAttribute("employee", employeeById);
        List<Department> allDepartments = departmentService.getAllDepartments();
        request.setAttribute("departments", allDepartments);
        List<Role> allRoles = roleService.getAllRoles();
        request.setAttribute("roles", allRoles);
        List<Employee> allManagers = employeeService.getAllManagers();
        request.setAttribute("managers", allManagers);
        request.getRequestDispatcher("employee_update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
