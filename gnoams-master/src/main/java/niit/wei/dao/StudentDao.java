package niit.wei.dao;

import niit.wei.entity.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    List<Student> getStudentList(Connection conn, String sql, Class<Student> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException;
    Student getStudent(Connection conn, String sql, Class<Student> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException;

    Long getStudentCount(Connection conn, String sql, Object... args) throws SQLException;

    void addStudent(Connection conn, String sql,Object...args) throws SQLException;
    void deleteStudent(Connection conn, String sql,Object...args) throws SQLException;
    void updateStudent(Connection conn, String sql,Object...args) throws SQLException;
}
