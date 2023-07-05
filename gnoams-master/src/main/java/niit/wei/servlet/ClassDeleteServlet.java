package niit.wei.servlet;

import niit.wei.service.ClassService;
import niit.wei.service.impl.ClassServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author WeiJinLong
 * @Date 2023-07-03 20:17
 * @Version 1.0
 */
@WebServlet("/ClassDeleteServlet")
public class ClassDeleteServlet extends HttpServlet {
    private ClassService classService = new ClassServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String classId = req.getParameter("classId");
        classService.deleteClassById(Integer.parseInt(classId));
        resp.sendRedirect("class_list.jsp");
    }
}
