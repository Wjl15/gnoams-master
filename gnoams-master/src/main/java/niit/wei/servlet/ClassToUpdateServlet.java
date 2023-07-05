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

@WebServlet("/ClassToUpdateServlet")
public class ClassToUpdateServlet extends HttpServlet {
    private ClassService classService = new ClassServiceImpl();
    private SubjectService subjectService = new SubjectServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String classId = request.getParameter("classId");
        Class1 classById = classService.getClassById(Integer.parseInt(classId));
        request.setAttribute("class2", classById);
        List<Class1> allClass = classService.getAllClass();
        request.setAttribute("allClass", allClass);
        List<Subject> subjects = subjectService.getSubjectList();
        request.setAttribute("subjects", subjects);
        request.getRequestDispatcher("class_update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
