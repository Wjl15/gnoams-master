package niit.wei.dao;

import niit.wei.entity.Department;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface DepartmentDao {
    List<Department> getDepartmentList(Connection conn, String sql, Class<Department> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException;
    Department getDepartment(Connection conn, String sql, Class<Department> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException;

    Long getDepartmentCount(Connection conn, String sql, Object... args) throws SQLException;

    void addDepartment(Connection conn, String sql,Object...args) throws SQLException;
    void deleteDepartment(Connection conn, String sql,Object...args) throws SQLException;
    void updateDepartment(Connection conn, String sql,Object...args) throws SQLException;
}
