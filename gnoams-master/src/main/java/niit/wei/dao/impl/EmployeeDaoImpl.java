package niit.wei.dao.impl;

import niit.wei.dao.EmployeeDao;
import niit.wei.entity.Employee;
import niit.wei.utils.BaseDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author WeiJinLong
 * @Date 2023-07-03 21:58
 * @Version 1.0
 */
public class EmployeeDaoImpl extends BaseDao<Employee> implements EmployeeDao {
    @Override
    public List<Employee> getEmployeeList(Connection conn, String sql, Class<Employee> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        return getList(conn, sql, clazz, args);
    }

    @Override
    public Employee getEmployee(Connection conn, String sql, Class<Employee> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        return getOne(conn, sql, clazz, args);
    }

    @Override
    public Long getEmployeeCount(Connection conn, String sql, Object... args) throws SQLException {
        return getCount(conn, sql, args);
    }

    @Override
    public void addEmployee(Connection conn, String sql, Object... args) throws SQLException {
        update(conn, sql, args);
    }

    @Override
    public void deleteEmployee(Connection conn, String sql, Object... args) throws SQLException {
        update(conn, sql, args);
    }

    @Override
    public void updateEmployee(Connection conn, String sql, Object... args) throws SQLException {
        update(conn, sql, args);
    }
}
