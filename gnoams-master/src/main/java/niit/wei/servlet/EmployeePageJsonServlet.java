package niit.wei.servlet;
import com.alibaba.fastjson.JSON;
import niit.wei.dto.Page;
import niit.wei.service.EmployeeService;
import niit.wei.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/EmployeePageJsonServlet")
public class EmployeePageJsonServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageNo = request.getParameter("pageNumber");
        String pageSize = request.getParameter("pageSize");
        Page employeePage = employeeService.getEmployeePage(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
        String jsonString = JSON.toJSONStringWithDateFormat(employeePage, "yyyy-MM-dd");
//        String jsonString = JSON.toJSONString(classPage);
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
