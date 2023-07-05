package niit.wei.servlet;
import com.alibaba.fastjson.JSON;
import niit.wei.dto.Page;
import niit.wei.service.ClassService;
import niit.wei.service.StudentService;
import niit.wei.service.impl.ClassServiceImpl;
import niit.wei.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/StudentPageJsonServlet")
public class StudentPageJsonServlet extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageNo = request.getParameter("pageNumber");
        String pageSize = request.getParameter("pageSize");
        Page studentPage = studentService.getStudentPage(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
        String jsonString = JSON.toJSONStringWithDateFormat(studentPage, "yyyy-MM-dd");
//        String jsonString = JSON.toJSONString(classPage);
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
