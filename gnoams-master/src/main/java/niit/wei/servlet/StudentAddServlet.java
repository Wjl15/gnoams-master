package niit.wei.servlet;

import niit.wei.entity.Student;
import niit.wei.service.StudentService;
import niit.wei.service.impl.StudentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/StudentAddServlet")
public class StudentAddServlet extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = new Student();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String studentName = request.getParameter("studentName");
        System.out.println(studentName);
        student.setStudentName(studentName);
        String classId = request.getParameter("classId");
        System.out.println(classId);
        student.setClassId(Integer.parseInt(classId));
        String gender = request.getParameter("gender");
        System.out.println(gender);
        student.setGender(gender);
        String phone = request.getParameter("phone");
        System.out.println(phone);
        student.setPhone(phone);
        String idCard = request.getParameter("idCard");
        System.out.println(idCard);
        student.setIdCard(idCard);
        String graduateSchool = request.getParameter("graduateSchool");
        System.out.println(graduateSchool);
        student.setGraduateSchool(graduateSchool);
        String educationId = request.getParameter("educationId");
        System.out.println(educationId);
        student.setEducationId(Integer.parseInt(educationId));
        String tuition = request.getParameter("tuition");
        System.out.println(tuition);
        student.setTuition(Double.parseDouble(tuition));
        String admissionTime = request.getParameter("admissionTime");
        System.out.println(admissionTime);
        try {
            student.setAdmissionTime(sf.parse(admissionTime));
            String empId = request.getParameter("empId");
            System.out.println(empId);
            student.setEmpId(Integer.parseInt(empId));
            studentService.addStudent(student);
            response.sendRedirect("student_list.jsp");

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
