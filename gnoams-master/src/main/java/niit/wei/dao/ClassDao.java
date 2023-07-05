package niit.wei.dao;

import niit.wei.entity.Class1;



import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ClassDao {
    List<Class1> getClassList(Connection conn, String sql, Class<Class1> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException;
    Class1 getClass1(Connection conn, String sql, Class<Class1> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException;

    Long getClass1Count(Connection conn, String sql, Object... args) throws SQLException;

    void addClass1(Connection conn, String sql,Object...args) throws SQLException;
    void deleteClass1(Connection conn, String sql,Object...args) throws SQLException;
    void updateClass1(Connection conn, String sql,Object...args) throws SQLException;
}
