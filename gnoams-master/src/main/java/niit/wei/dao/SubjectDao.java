package niit.wei.dao;



import niit.wei.entity.Subject;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface SubjectDao {
    List<Subject> getSubjectList(Connection conn, String sql, Class<Subject> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException;
    Subject getSubject(Connection conn, String sql, Class<Subject> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException;

    Long getSubjectCount(Connection conn, String sql, Object... args) throws SQLException;

    void addSubject(Connection conn, String sql,Object...args) throws SQLException;
    void deleteSubject(Connection conn, String sql,Object...args) throws SQLException;
    void updateSubject(Connection conn, String sql,Object...args) throws SQLException;
}
