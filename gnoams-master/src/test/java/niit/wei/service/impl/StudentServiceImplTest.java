package niit.wei.service.impl;

import niit.wei.entity.Class1;
import niit.wei.entity.Employee;
import niit.wei.entity.Student;
import niit.wei.service.StudentService;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class StudentServiceImplTest {
    private StudentService studentService = new StudentServiceImpl();
    @Test
    public void getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        System.out.println(students);
    }

    @Test
    public void getStudentById() {
    }

    @Test
    public void addStudent() {
    }

    @Test
    public void updateStudent() {
    }

    @Test
    public void deleteStudent() {
    }

    @Test
    public void getStudentPage() {
    }

    @Test
    public void testAddStudent() {
        Student student = new Student();
        student.setStudentName("张三");
        student.setClassId(10001);
        student.setEmpId(10003);
        student.setGender("0");
        student.setPhone("13888888888");
        student.setIdCard("1234567890123456");
        student.setGraduateSchool("北京");
        student.setEducationId(10000);
        student.setTuition(1000.0);
        student.setAdmissionTime(new Date());
        studentService.addStudent(student);
    }
}