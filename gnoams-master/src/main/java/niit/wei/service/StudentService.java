package niit.wei.service;

import niit.wei.dto.Page;
import niit.wei.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Integer studentId);
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Integer studentId);

    Page getStudentPage(Integer pageNo, Integer pageSize);
}
