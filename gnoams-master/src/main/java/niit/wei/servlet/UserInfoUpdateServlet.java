package niit.wei.servlet;

import niit.wei.entity.Employee;
import niit.wei.service.EmployeeService;
import niit.wei.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author WeiJinLong
 * @Date 2023-07-04 14:48
 * @Version 1.0
 */
@WebServlet("/UserInfoUpdateServlet")
public class UserInfoUpdateServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String empname = req.getParameter("empname");
        String empId = req.getParameter("empId");
        employeeService.updateEmployee(username,empname);
        Employee employeeByName = employeeService.getEmployeeById(Integer.parseInt(empId));
        HttpSession session = req.getSession();
        session.setAttribute("employee",employeeByName);
        resp.sendRedirect("index.jsp");
    }
}
