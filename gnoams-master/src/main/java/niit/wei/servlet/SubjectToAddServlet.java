package niit.wei.servlet;

import niit.wei.entity.SubjectType;
import niit.wei.service.SubjectService;
import niit.wei.service.SubjectTypeService;
import niit.wei.service.impl.SubjectServiceImpl;
import niit.wei.service.impl.SubjectTypeServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/SubjectToAddServlet")
public class SubjectToAddServlet extends HttpServlet {
    private SubjectTypeService subjectTypeService = new SubjectTypeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SubjectType> subjectTypes = subjectTypeService.getSubjectTypes();
        request.setAttribute("subjectTypes", subjectTypes);
        request.getRequestDispatcher("subject_add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
