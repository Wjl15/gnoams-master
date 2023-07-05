package niit.wei.servlet;

import niit.wei.entity.Employee;
import niit.wei.service.EmployeeService;
import niit.wei.service.impl.EmployeeServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/UserInfoToUpdateServlet")
public class UserInfoToUpdateServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empId = request.getParameter("empId");
        System.out.println(empId);
        Employee employeeById = employeeService.getEmployeeById(Integer.parseInt(empId));
        request.setAttribute("employee", employeeById);
        request.getRequestDispatcher("user_info.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
