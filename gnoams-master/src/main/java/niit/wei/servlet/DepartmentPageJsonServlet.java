package niit.wei.servlet;
import com.alibaba.fastjson.JSON;
import niit.wei.dto.Page;
import niit.wei.service.DepartmentService;
import niit.wei.service.SubjectService;
import niit.wei.service.impl.DepartmentServiceImpl;
import niit.wei.service.impl.SubjectServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DepartmentPageJsonServlet")
public class DepartmentPageJsonServlet extends HttpServlet {
    private DepartmentService departmentService = new DepartmentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageNo = request.getParameter("pageNumber");
        String pageSize = request.getParameter("pageSize");
        Page subjectPage = departmentService.getDepartmentPage(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
        String jsonString = JSON.toJSONStringWithDateFormat(subjectPage, "yyyy-MM-dd");
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
