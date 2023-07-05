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
 * @Date 2023-06-29 13:20
 * @Version 1.0
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        String captcha = req.getParameter("captcha");
        HttpSession session = req.getSession();
        Object text = session.getAttribute("text");
        System.out.println("aa" + captcha);
        if (captcha == null || captcha.length() == 0) {
            req.setAttribute("msg", "验证码不能为空 ");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else if (!captcha.equals(text)) {
            req.setAttribute("msg", "验证码错误 ");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else {
            Employee employee = employeeService.login(phone, password);
            if (phone == null || phone.length() == 0 || password == null || password.length() == 0) {
                req.setAttribute("msg", "手机号密码不能为空");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            } else {
                if (employee != null) {
                    req.getSession().setAttribute("employee", employee);
                    resp.setContentType("text/html;charset=utf-8");
                    resp.sendRedirect("index.jsp");
                } else {
                    req.setAttribute("msg", "手机号或密码错误");
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                }
            }
        }
    }
}
