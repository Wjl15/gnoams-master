package niit.wei.servlet;

import niit.wei.entity.Employee;
import niit.wei.service.EmployeeService;
import niit.wei.service.impl.EmployeeServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/EmployeeAddServlet")
public class EmployeeAddServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee employee = new Employee();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String empName = request.getParameter("empName");
        employee.setEmpName(empName);
        System.out.println(empName);
        String deptId = request.getParameter("deptId");
        System.out.println(deptId);
        employee.setDeptId(Integer.parseInt(deptId));
        String roleId = request.getParameter("roleId");
        System.out.println(roleId);
        employee.setRoleId(Integer.parseInt(roleId));
        String gender = request.getParameter("gender");
        System.out.println(gender);
        employee.setGender(Integer.parseInt(gender));
        String managerId = request.getParameter("managerId");
        System.out.println(managerId);
        employee.setManagerId(Integer.parseInt(managerId));
        String phone = request.getParameter("phone");
        System.out.println(phone);
        employee.setPhone(phone);
        String password = request.getParameter("password");
        System.out.println(password);
        employee.setPassword(password);
        String email = request.getParameter("email");
        System.out.println(email);
        employee.setEmail(email);
        String hireTime = request.getParameter("hireTime");
        System.out.println(hireTime);
        try {
            employee.setHireTime(sf.parse(hireTime));
            employeeService.addEmployee(employee);
            response.sendRedirect("employee_list.jsp");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
