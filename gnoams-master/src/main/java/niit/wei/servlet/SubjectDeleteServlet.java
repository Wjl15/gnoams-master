package niit.wei.servlet;

import niit.wei.service.SubjectService;
import niit.wei.service.impl.SubjectServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/SubjectDeleteServlet")
public class SubjectDeleteServlet extends HttpServlet {
    private SubjectService subjectService = new SubjectServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String subjectId = request.getParameter("subjectId");
        subjectService.delete(Integer.parseInt(subjectId));
        response.sendRedirect("subject_list.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
