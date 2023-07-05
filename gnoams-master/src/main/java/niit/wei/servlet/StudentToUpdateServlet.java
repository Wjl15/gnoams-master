package niit.wei.servlet;

import niit.wei.entity.Class1;
import niit.wei.entity.Education;
import niit.wei.entity.Employee;
import niit.wei.entity.Student;
import niit.wei.service.ClassService;
import niit.wei.service.EducationService;
import niit.wei.service.EmployeeService;
import niit.wei.service.StudentService;
import niit.wei.service.impl.ClassServiceImpl;
import niit.wei.service.impl.EducationServiceImpl;
import niit.wei.service.impl.EmployeeServiceImpl;
import niit.wei.service.impl.StudentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/StudentToUpdateServlet")
public class StudentToUpdateServlet extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();
    private EducationService educationService = new EducationServiceImpl();
    private ClassService classService = new ClassServiceImpl();
    private EmployeeService employeeService = new EmployeeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("studentId");
        System.out.println(studentId);
        Student studentById = studentService.getStudentById(Integer.parseInt(studentId));
        request.setAttribute("student", studentById);
        List<Education> educationList = educationService.getEducationList();
        request.setAttribute("educationList",educationList);
        List<Class1> allClass = classService.getAllClass();
        request.setAttribute("ClassList",allClass);
        List<Employee> allEmployees = employeeService.getAllEmployees();
        request.setAttribute("EmployeeList",allEmployees);
        request.getRequestDispatcher("student_update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
