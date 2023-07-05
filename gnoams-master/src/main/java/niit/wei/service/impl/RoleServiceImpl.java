package niit.wei.service.impl;

import niit.wei.dao.RoleDao;
import niit.wei.dao.impl.RoleDaoImpl;
import niit.wei.dto.Page;
import niit.wei.entity.Role;
import niit.wei.service.RoleService;
import niit.wei.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author WeiJinLong
 * @Date 2023-07-03 11:41
 * @Version 1.0
 */
public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao = new RoleDaoImpl();

    @Override
    public void addRole(Role role) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql = "INSERT INTO role(role_name,status) values(?,?)";
            roleDao.addRole(conn, sql, role.getRoleName(), role.getStatus());
            conn.commit();
        } catch (SQLException | ClassNotFoundException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            throw new RuntimeException(e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void updateRole(Role role) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql = "update role set role_name=?,status=? where role_id=?";
            roleDao.addRole(conn, sql, role.getRoleName(), role.getStatus(),role.getRoleId());
            conn.commit();
        } catch (SQLException | ClassNotFoundException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            throw new RuntimeException(e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void deleteRole(Integer roleId) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql = "delete from role where role_id=?;";
            roleDao.addRole(conn, sql, roleId);
            conn.commit();
        } catch (SQLException | ClassNotFoundException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            throw new RuntimeException(e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Role getRoleByRoleId(Integer roleId) {
        Connection conn = null;
        try {
            conn= JDBCUtils.getConnection();
            String sql = "select role_id roleId, role_name roleName, status from role where role_id=?";
            Role role = roleDao.getRole(conn, sql, Role.class, roleId);
            return role;
        } catch (SQLException | ClassNotFoundException | NoSuchFieldException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }finally {
            if (conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public List<Role> getAllRoles() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select role_id roleId, role_name roleName, status from role";
            List<Role> roleList = roleDao.getRoleList(conn, sql, Role.class);
            return roleList;
        } catch (SQLException | ClassNotFoundException | NoSuchFieldException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public Page getRolePage(Integer pageNo, Integer pageSize) {
        Page page = new Page();
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select role_id roleId, role_name roleName, status  from role limit ?,?";
            List<Role> roleList = roleDao.getRoleList(conn, sql, Role.class, (pageNo - 1) * pageSize, pageSize);
            page.setPage(roleList);
            page.setPageNo(pageNo);
            page.setPageSize(pageSize);

            Long roleCount = roleDao.getRoleCount(conn,"select count(*) count from role");
            page.setCount(roleCount);
            long count = (roleCount % pageSize == 0) ? (roleCount / pageSize) : (roleCount / pageSize + 1);
            int PageCount = (int) count;
            page.setPageCount(PageCount);

            page.setHasPrePage(pageNo <= 1 ? false : true);
            page.setHasNextPage(pageNo >= PageCount ? false : true);
            return page;
        } catch (SQLException | ClassNotFoundException | NoSuchFieldException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn!= null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
