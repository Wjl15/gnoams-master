package niit.wei.servlet;

import niit.wei.entity.Class1;
import niit.wei.entity.Subject;
import niit.wei.service.ClassService;
import niit.wei.service.SubjectService;
import niit.wei.service.impl.ClassServiceImpl;
import niit.wei.service.impl.SubjectServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/ClassToAddServlet")
public class ClassToAddServlet extends HttpServlet {
    private ClassService classService = new ClassServiceImpl();
    private SubjectService subjectService = new SubjectServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Class1> allClass = classService.getAllClass();
        List<Subject> subjects = subjectService.getSubjectList();
        request.setAttribute("subjects", subjects);
        System.out.println(allClass);
        request.setAttribute("allClass", allClass);

        request.getRequestDispatcher("class_add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
