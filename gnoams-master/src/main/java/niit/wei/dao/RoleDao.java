package niit.wei.dao;

import niit.wei.entity.Role;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface RoleDao {
    /**
     * Returns
     * @return 所有角色
     */
    List<Role> getRoleList(Connection conn, String sql, Class<Role> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException;
    Role getRole(Connection conn, String sql, Class<Role> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException;

    Long getRoleCount(Connection conn, String sql, Object... args) throws SQLException;

    void addRole(Connection conn, String sql,Object...args) throws SQLException;
    void deleteRole(Connection conn, String sql,Object...args) throws SQLException;
    void updateRole(Connection conn, String sql,Object...args) throws SQLException;

}
