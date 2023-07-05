package niit.wei.servlet;

import niit.wei.entity.Subject;
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

@WebServlet("/subjectToUpdateServlet")
public class subjectToUpdateServlet extends HttpServlet {
    private SubjectService subjectService = new SubjectServiceImpl();
    private SubjectTypeService subjectTypeService = new SubjectTypeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String subjectId = request.getParameter("subjectId");
        List<SubjectType> subjectTypes = subjectTypeService.getSubjectTypes();
        Subject subjectById = subjectService.getSubjectById(Integer.parseInt(subjectId));
        request.setAttribute("subject", subjectById);
        request.setAttribute("subjectTypes",subjectTypes);
        request.getRequestDispatcher("subject_update.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
