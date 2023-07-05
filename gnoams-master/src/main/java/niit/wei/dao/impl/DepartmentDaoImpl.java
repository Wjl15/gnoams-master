package niit.wei.dao.impl;

import niit.wei.dao.DepartmentDao;
import niit.wei.entity.Department;
import niit.wei.utils.BaseDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author WeiJinLong
 * @Date 2023-07-03 17:26
 * @Version 1.0
 */
public class DepartmentDaoImpl extends BaseDao<Department> implements DepartmentDao {
    @Override
    public List<Department> getDepartmentList(Connection conn, String sql, Class<Department> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        return getList(conn, sql, clazz, args);
    }

    @Override
    public Department getDepartment(Connection conn, String sql, Class<Department> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        return getOne(conn, sql, clazz, args);
    }

    @Override
    public Long getDepartmentCount(Connection conn, String sql, Object... args) throws SQLException {
        return getCount(conn, sql, args);
    }

    @Override
    public void addDepartment(Connection conn, String sql, Object... args) throws SQLException {
        update(conn, sql, args);
    }

    @Override
    public void deleteDepartment(Connection conn, String sql, Object... args) throws SQLException {
        update(conn, sql, args);
    }

    @Override
    public void updateDepartment(Connection conn, String sql, Object... args) throws SQLException {
        update(conn, sql, args);
    }
}
