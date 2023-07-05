package niit.wei.servlet;
import com.alibaba.fastjson.JSON;
import niit.wei.dto.Page;
import niit.wei.service.ClassService;
import niit.wei.service.impl.ClassServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ClassPageJsonServlet")
public class ClassPageJsonServlet extends HttpServlet {
    private ClassService classService = new ClassServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageNo = request.getParameter("pageNumber");
        String pageSize = request.getParameter("pageSize");
        Page classPage = classService.getClassPage(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
        String jsonString = JSON.toJSONStringWithDateFormat(classPage, "yyyy-MM-dd");
//        String jsonString = JSON.toJSONString(classPage);
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
