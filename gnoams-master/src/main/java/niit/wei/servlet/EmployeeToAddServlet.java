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

@WebServlet("/EmployeeToAddServlet")
public class EmployeeToAddServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceImpl();
    private DepartmentService departmentService = new DepartmentServiceImpl();
    private RoleService roleService = new RoleServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        request.setAttribute("employees", allEmployees);
        List<Employee> allManagers = employeeService.getAllManagers();
        request.setAttribute("managers", allManagers);
        List<Department> allDepartments = departmentService.getAllDepartments();
        List<Role> allRoles = roleService.getAllRoles();
        request.setAttribute("roles", allRoles);
        request.setAttribute("departments", allDepartments);
        request.getRequestDispatcher("employee_add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
