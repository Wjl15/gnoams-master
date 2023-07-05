package niit.wei.servlet;

import niit.wei.entity.Class1;
import niit.wei.service.ClassService;
import niit.wei.service.impl.ClassServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/ClassAddServlet")
public class ClassAddServlet extends HttpServlet {
    private ClassService classService = new ClassServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Class1 class1 = new Class1();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String className = request.getParameter("className");
        System.out.println(className);
        class1.setClassName(className);
        String subjectId = request.getParameter("subjectId");
        System.out.println(subjectId);
        class1.setSubjectId(Integer.parseInt(subjectId));
        String createTime = request.getParameter("createTime");
        System.out.println(createTime);
        try {
            Date parse = sf.parse(createTime);
            class1.setCreateTime(parse);
            String classLife = request.getParameter("classLife");
            System.out.println(classLife);
            class1.setClassLife(Integer.parseInt(classLife));
            String classCount = request.getParameter("classCount");
            System.out.println(classCount);
            class1.setClassCount(Integer.parseInt(classCount));
            String classAddress = request.getParameter("classAddress");
            System.out.println(classAddress);
            class1.setClassAddress(classAddress);
            classService.addClass(class1);
            response.sendRedirect("class_list.jsp");

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
