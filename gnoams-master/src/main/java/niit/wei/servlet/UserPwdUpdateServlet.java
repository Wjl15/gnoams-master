package niit.wei.servlet;

import niit.wei.entity.Employee;
import niit.wei.service.EmployeeService;
import niit.wei.service.impl.EmployeeServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/UserPwdUpdateServlet")
public class UserPwdUpdateServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empId = request.getParameter("empId");
        System.out.println(empId);
        String oldpwd = request.getParameter("oldpwd");
        System.out.println(oldpwd);
        String newpwd = request.getParameter("newpwd");
        System.out.println(newpwd);
        String confirmpwd = request.getParameter("confirmpwd");
        System.out.println(confirmpwd);
        String oldrealpwd = request.getParameter("oldrealpwd");
        if (oldpwd == null || oldpwd.length() == 0) {
            request.setAttribute("msg", "原密码不能为空 ");
            request.getRequestDispatcher("user_pwd.jsp").forward(request, response);
        }else {
            if (!oldrealpwd.equals(oldpwd)){
                request.setAttribute("msg", "原密码不正确 ");
                request.getRequestDispatcher("user_pwd.jsp").forward(request, response);
            }else {
                if (newpwd == null || newpwd.length() == 0) {
                    request.setAttribute("msg", "新密码不能为空 ");
                    request.getRequestDispatcher("user_pwd.jsp").forward(request, response);
                } else {
                    if (confirmpwd == null || confirmpwd.length() == 0) {
                        request.setAttribute("msg", "确认密码不能为空 ");
                        request.getRequestDispatcher("user_pwd.jsp").forward(request, response);
                    }else {
                        if (!newpwd.equals(confirmpwd)) {
                            request.setAttribute("msg", "两次输入的密码不一致 ");
                            request.getRequestDispatcher("user_pwd.jsp").forward(request, response);
                        }else {
                            employeeService.updateEmployeePwd(newpwd,Integer.parseInt(empId));
                            request.getRequestDispatcher("login.jsp").forward(request, response);
                        }
                    }
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
