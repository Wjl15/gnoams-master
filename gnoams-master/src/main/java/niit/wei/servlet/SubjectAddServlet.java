package niit.wei.servlet;

import niit.wei.entity.Subject;
import niit.wei.service.SubjectService;
import niit.wei.service.impl.SubjectServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/SubjectAddServlet")
public class SubjectAddServlet extends HttpServlet {
    private SubjectService subjectService = new SubjectServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Subject subject = new Subject();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String subjectName = request.getParameter("subjectName");
        System.out.println(subjectName);
        subject.setSubjectName(subjectName);
        String createTime = request.getParameter("createTime");
        System.out.println(createTime);
        try {
            Date parse = sf.parse(createTime);
            java.sql.Date date = new java.sql.Date(parse.getTime());
            subject.setCreateTime(date);
            String subjectLife = request.getParameter("subjectLife");
            System.out.println(subjectLife);
            subject.setSubjectLife(Integer.parseInt(subjectLife));
            String subjectTypeId = request.getParameter("subjectTypeId");
            System.out.println(subjectTypeId);
            subject.setSubjectTypeId(Integer.parseInt(subjectTypeId));
            subjectService.add(subject);
            response.sendRedirect("subject_list.jsp");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
