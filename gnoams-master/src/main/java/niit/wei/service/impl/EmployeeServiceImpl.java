package niit.wei.service.impl;

import niit.wei.dao.DepartmentDao;
import niit.wei.dao.EmployeeDao;
import niit.wei.dao.RoleDao;
import niit.wei.dao.impl.DepartmentDaoImpl;
import niit.wei.dao.impl.EmployeeDaoImpl;
import niit.wei.dao.impl.RoleDaoImpl;
import niit.wei.dto.Page;
import niit.wei.entity.Department;
import niit.wei.entity.Employee;
import niit.wei.entity.Role;
import niit.wei.service.EmployeeService;
import niit.wei.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author WeiJinLong
 * @Date 2023-07-03 22:02
 * @Version 1.0
 */
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao = new EmployeeDaoImpl();
    private DepartmentDao departmentDao = new DepartmentDaoImpl();
    private RoleDao roleDao = new RoleDaoImpl();

    @Override
    public List<Employee> getAllEmployees() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select emp_id empId, emp_name empName, dept_id deptId, role_id roleId, manager_id managerId, gender, phone, password, email, hire_time hireTime from employee;";
            List<Employee> employeeList = employeeDao.getEmployeeList(conn, sql, Employee.class);
            for (Employee employee : employeeList) {
                Department department = departmentDao.getDepartment(conn, "select dept_id deptId, dept_name deptName from department where dept_id=?", Department.class, employee.getDeptId());
                employee.setDepartment(department);
                Role role = roleDao.getRole(conn, "select role_id roleId,role_name roleName  from role where role_id=?", Role.class, employee.getRoleId());
                employee.setRole(role);
                Employee employee1 = employeeDao.getEmployee(conn, "select m.emp_name empName ,m.emp_id empId from employee e , employee m where m.emp_id = e.manager_id and e.emp_id=?;", Employee.class, employee.getEmpId());
                employee.setEmployee(employee1);
            }
            return employeeList;
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
    public List<Employee> getAllManagers() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select distinct m.emp_id empId,m.emp_name empName  from employee e,employee m where e.manager_id = m.emp_id;";
            List<Employee> managerList = employeeDao.getEmployeeList(conn, sql, Employee.class);
            return managerList;
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
    public Employee getEmployeeById(Integer employeeId) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select emp_id empId, emp_name empName, dept_id deptId, role_id roleId, manager_id managerId, gender, phone, password, email, hire_time hireTime from employee where emp_id=?";
            Employee employee = employeeDao.getEmployee(conn, sql, Employee.class, employeeId);
            return employee;
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
    public void addEmployee(Employee employee) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql = "insert into employee (emp_name, dept_id, role_id, manager_id, gender, phone, password, email, hire_time) values(?,?,?,?,?,?,?,?,?)";
            employeeDao.addEmployee(conn, sql, employee.getEmpName(), employee.getDeptId(), employee.getRoleId(), employee.getManagerId(), employee.getGender(), employee.getPhone(), employee.getPassword(), employee.getEmail(), employee.getHireTime());
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
    public void updateEmployee(Employee employee) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql = "update employee set emp_name=?,dept_id=?,role_id=?,gender=?,manager_id=?,phone=?,password=?,email=?,hire_time=? where emp_id=?;";
            employeeDao.updateEmployee(conn, sql, employee.getEmpName(), employee.getDeptId(), employee.getRoleId(), employee.getGender(), employee.getManagerId(), employee.getPhone(), employee.getPassword(), employee.getEmail(), employee.getHireTime(), employee.getEmpId());
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
    public void deleteEmployee(Integer employeeId) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql = "delete from employee where emp_id=?;";
            employeeDao.deleteEmployee(conn, sql, employeeId);
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
    public Page getEmployeePage(Integer pageNo, Integer pageSize) {
        Page page = new Page();
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select emp_id empId, emp_name empName, dept_id deptId, role_id roleId, manager_id managerId, gender, phone, password, email, hire_time hireTime from employee limit ?,?;";
            List<Employee> employeeList = employeeDao.getEmployeeList(conn, sql, Employee.class, (pageNo - 1) * pageSize, pageSize);
            for (Employee employee : employeeList) {
                Department department = departmentDao.getDepartment(conn, "select dept_id deptId, dept_name deptName from department where dept_id=?", Department.class, employee.getDeptId());
                employee.setDepartment(department);
                Role role = roleDao.getRole(conn, "select role_id roleId,role_name roleName  from role where role_id=?", Role.class, employee.getRoleId());
                employee.setRole(role);
                Employee employee1 = employeeDao.getEmployee(conn, "select m.emp_name empName ,m.emp_id empId from employee e , employee m where m.emp_id = e.manager_id and e.emp_id=?;", Employee.class, employee.getEmpId());
                employee.setEmployee(employee1);
            }
            page.setPage(employeeList);
            page.setPageNo(pageNo);
            page.setPageSize(pageSize);

            Long employeeCount = employeeDao.getEmployeeCount(conn, "select count(*) count from employee");
            page.setCount(employeeCount);
            long count = (employeeCount % pageSize == 0) ? (employeeCount / pageSize) : (employeeCount / pageSize + 1);
            int PageCount = (int) count;
            page.setPageCount(PageCount);

            page.setHasPrePage(pageNo <= 1 ? false : true);
            page.setHasNextPage(pageNo >= PageCount ? false : true);
            return page;
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
    public Employee login(String phone, String password) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select emp_id empId, emp_name empName, dept_id deptId, role_id roleId, manager_id managerId, gender, phone, password, email, hire_time hireTime from employee where phone=? and password=?";
            Employee employee = employeeDao.getEmployee(conn, sql, Employee.class, phone, password);
            return employee;
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
    public void updateEmployee(String empName, String userName) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql = "update employee set emp_name=? where emp_name=?;";
            employeeDao.updateEmployee(conn, sql, empName, userName);
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
    public Employee getEmployeeByName(String empName) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select emp_id empId, emp_name empName, dept_id deptId, role_id roleId, manager_id managerId, gender, phone, password, email, hire_time hireTime from employee where emp_name=?";
            Employee employee = employeeDao.getEmployee(conn, sql, Employee.class, empName);
            return employee;
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
    public void updateEmployeePwd(String newPwd,Integer empId) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql = "update employee set password=? where emp_id=?;";
            employeeDao.updateEmployee(conn, sql, newPwd, empId);
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
}

