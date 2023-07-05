package niit.wei.service.impl;

import niit.wei.dao.DepartmentDao;
import niit.wei.dao.impl.DepartmentDaoImpl;
import niit.wei.dto.Page;
import niit.wei.entity.Department;
import niit.wei.entity.Role;
import niit.wei.service.DepartmentService;
import niit.wei.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author WeiJinLong
 * @Date 2023-07-03 17:29
 * @Version 1.0
 */
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDao departmentDao = new DepartmentDaoImpl();
    @Override
    public List<Department> getAllDepartments() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select dept_id deptId, dept_name deptName, create_time createTime from department;";
            List<Department> departmentList =departmentDao.getDepartmentList(conn, sql, Department.class);
            return departmentList;
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
    public Department getDepartmentById(Integer deptId) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select dept_id deptId, dept_name deptName, create_time createTime from department where dept_id=?";
            Department department = departmentDao.getDepartment(conn, sql, Department.class, deptId);
            return department;
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
    public void addDepartment(Department department) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql = "INSERT INTO department(dept_name,create_time) values(?,?)";
            departmentDao.addDepartment(conn, sql, department.getDeptName(), department.getCreateTime());
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
    public void updateDepartment(Department department) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql = "update department set dept_name=?,create_time=? where dept_id=?;";
            departmentDao.updateDepartment(conn,sql,department.getDeptName(),department.getCreateTime(),department.getDeptId());
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
    public void deleteDepartment(Integer deptId) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql = "delete from department where dept_id=?";
            departmentDao.deleteDepartment(conn,sql,deptId);
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
    public Page getDepartmentPage(Integer pageNo, Integer pageSize) {
        Page page = new Page();
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select dept_id deptId, dept_name deptName, create_time createTime from department limit ?,?";
            List<Department> departmentList = departmentDao.getDepartmentList(conn, sql, Department.class, (pageNo - 1) * pageSize, pageSize);
            page.setPage(departmentList);
            page.setPageNo(pageNo);
            page.setPageSize(pageSize);

            Long departmentCount = departmentDao.getDepartmentCount(conn,"select count(*) count from department");
            page.setCount(departmentCount);
            long count = (departmentCount % pageSize == 0) ? (departmentCount / pageSize) : (departmentCount / pageSize + 1);
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

