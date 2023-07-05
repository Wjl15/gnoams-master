package niit.wei.dao.impl;

import niit.wei.dao.StudentDao;
import niit.wei.entity.Student;
import niit.wei.utils.BaseDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author WeiJinLong
 * @Date 2023-07-04 9:58
 * @Version 1.0
 */
public class StudentDaoImpl extends BaseDao<Student> implements StudentDao {
    @Override
    public List<Student> getStudentList(Connection conn, String sql, Class<Student> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        return getList(conn, sql, clazz, args);
    }

    @Override
    public Student getStudent(Connection conn, String sql, Class<Student> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        return getOne(conn,sql,clazz,args);
    }

    @Override
    public Long getStudentCount(Connection conn, String sql, Object... args) throws SQLException {
        return getCount(conn,sql,args);
    }

    @Override
    public void addStudent(Connection conn, String sql, Object... args) throws SQLException {
        update(conn,sql,args);
    }

    @Override
    public void deleteStudent(Connection conn, String sql, Object... args) throws SQLException {
        update(conn,sql,args);
    }

    @Override
    public void updateStudent(Connection conn, String sql, Object... args) throws SQLException {
        update(conn,sql,args);
    }
}
