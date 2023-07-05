package niit.wei.dao;

import niit.wei.entity.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
    List<Employee> getEmployeeList(Connection conn, String sql, Class<Employee> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException;
    Employee getEmployee(Connection conn, String sql, Class<Employee> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException;

    Long getEmployeeCount(Connection conn, String sql, Object... args) throws SQLException;

    void addEmployee(Connection conn, String sql,Object...args) throws SQLException;
    void deleteEmployee(Connection conn, String sql,Object...args) throws SQLException;
    void updateEmployee(Connection conn, String sql,Object...args) throws SQLException;
}
