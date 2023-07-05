package niit.wei.dao.impl;

import niit.wei.dao.RoleDao;
import niit.wei.entity.Role;
import niit.wei.utils.BaseDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author WeiJinLong
 * @Date 2023-07-03 11:37
 * @Version 1.0
 */
public class RoleDaoImpl extends BaseDao<Role> implements RoleDao {
    @Override
    public List<Role> getRoleList(Connection conn, String sql, Class<Role> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        return getList(conn, sql, clazz, args);
    }

    @Override
    public Role getRole(Connection conn, String sql, Class<Role> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        return getOne(conn, sql, clazz, args);
    }

    @Override
    public Long getRoleCount(Connection conn, String sql, Object... args) throws SQLException {
        return getCount(conn, sql, args);
    }

    @Override
    public void addRole(Connection conn, String sql, Object... args) throws SQLException {
        update(conn, sql, args);
    }

    @Override
    public void deleteRole(Connection conn, String sql, Object... args) throws SQLException {
        update(conn, sql, args);
    }

    @Override
    public void updateRole(Connection conn, String sql, Object... args) throws SQLException {
        update(conn, sql, args);
    }
}
