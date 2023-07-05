package niit.wei.service.impl;

import niit.wei.dao.ClassDao;
import niit.wei.dao.EducationDao;
import niit.wei.dao.EmployeeDao;
import niit.wei.dao.StudentDao;
import niit.wei.dao.impl.ClassDaoImpl;
import niit.wei.dao.impl.EducationDaoImpl;
import niit.wei.dao.impl.EmployeeDaoImpl;
import niit.wei.dao.impl.StudentDaoImpl;
import niit.wei.dto.Page;
import niit.wei.entity.*;
import niit.wei.service.StudentService;
import niit.wei.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author WeiJinLong
 * @Date 2023-07-04 10:02
 * @Version 1.0
 */
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = new StudentDaoImpl();
    private ClassDao classDao = new ClassDaoImpl();
    private EmployeeDao employeeDao = new EmployeeDaoImpl();

    private EducationDao educationDao = new EducationDaoImpl();

    @Override
    public List<Student> getAllStudents() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select student_id studentId, student_name studentName, class_id classId, emp_id empId, gender, phone, id_card idCard, graduate_school graduateSchool, education_id educationId, tuition, admission_time admissionTime from student";
            List<Student> studentList = studentDao.getStudentList(conn, sql, Student.class);
            for (Student student : studentList) {
                Class1 class1 = classDao.getClass1(conn, "select class_id classId,class_name className from class where class_id=?", Class1.class, student.getClassId());
                student.setClass1(class1);
                Employee employee = employeeDao.getEmployee(conn, "select emp_id empId, emp_name empName from employee where emp_id=?", Employee.class, student.getEmpId());
                student.setEmployee(employee);
                Education education = educationDao.getEducation(conn, "select education_id educationId, education_name educationName from education where education_id=?", Education.class, student.getEducationId());
                student.setEducation(education);
            }
            return studentList;
        } catch (SQLException | ClassNotFoundException | NoSuchFieldException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public Student getStudentById(Integer studentId) {
        Connection conn = null;
        try {
            conn= JDBCUtils.getConnection();
            String sql = "select student_id studentId, student_name studentName, class_id classId, emp_id empId, gender, phone, id_card idCard, graduate_school graduateSchool, education_id educationId, tuition, admission_time admissionTime from student where student_id=?";
            Student student = studentDao.getStudent(conn, sql, Student.class, studentId);
            return student;
        } catch (SQLException | ClassNotFoundException | NoSuchFieldException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }finally {
            if (conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public void addStudent(Student student) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql = "insert into student(student_name, class_id, emp_id, gender, phone, id_card, graduate_school, education_id, tuition, admission_time) values (?,?,?,?,?,?,?,?,?,?);";
            studentDao.addStudent(conn, sql, student.getStudentName(), student.getClassId(), student.getEmpId(), student.getGender(), student.getPhone(), student.getIdCard(),student.getGraduateSchool(), student.getEducationId(), student.getTuition(),student.getAdmissionTime());
            conn.commit();
        } catch (SQLException | ClassNotFoundException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            throw new RuntimeException(e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void updateStudent(Student student) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql = "update  student set student_name=?,class_id=?,emp_id=?,gender=?,phone=?,id_card=?,graduate_school=?,education_id=?,tuition=?,admission_time=? where student_id=?;";
            studentDao.updateStudent(conn, sql, student.getStudentName(), student.getClassId(), student.getEmpId(), student.getGender(), student.getPhone(), student.getIdCard(), student.getGraduateSchool(), student.getEducationId(), student.getTuition(),student.getAdmissionTime(),student.getStudentId());
            conn.commit();
        } catch (SQLException | ClassNotFoundException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            throw new RuntimeException(e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void deleteStudent(Integer studentId) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql = "delete from student where student_id=?;";
            studentDao.deleteStudent(conn, sql, studentId);
            conn.commit();
        } catch (SQLException | ClassNotFoundException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            throw new RuntimeException(e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Page getStudentPage(Integer pageNo, Integer pageSize) {
        Page page = new Page();
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select student_id studentId, student_name studentName, class_id classId, emp_id empId, gender, phone, id_card idCard, graduate_school graduateSchool, education_id educationId, tuition, admission_time admissionTime from student limit ?,?";
            List<Student> studentList = studentDao.getStudentList(conn, sql, Student.class, (pageNo - 1) * pageSize, pageSize);
            for (Student student : studentList) {
                Class1 class1 = classDao.getClass1(conn, "select class_id classId,class_name className from class where class_id=?", Class1.class, student.getClassId());
                student.setClass1(class1);
                Employee employee = employeeDao.getEmployee(conn, "select emp_id empId, emp_name empName from employee where emp_id=?", Employee.class, student.getEmpId());
                student.setEmployee(employee);
                Education education = educationDao.getEducation(conn, "select education_id educationId, education_name educationName from education where education_id=?", Education.class, student.getEducationId());
                student.setEducation(education);
            }
            page.setPage(studentList);
            page.setPageNo(pageNo);
            page.setPageSize(pageSize);

            Long studentCount = studentDao.getStudentCount(conn, "select count(*) count from student");
            page.setCount(studentCount);
            long count = (studentCount % pageSize == 0) ? (studentCount / pageSize) : (studentCount / pageSize + 1);
            int PageCount = (int) count;
            page.setPageCount(PageCount);

            page.setHasPrePage(pageNo <= 1 ? false : true);
            page.setHasNextPage(pageNo >= PageCount ? false : true);
            return page;
        } catch (SQLException | ClassNotFoundException | NoSuchFieldException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
