package niit.wei.entity;

import java.util.Date;

/**
 * @Author WeiJinLong
 * @Date 2023-07-03 21:47
 * @Version 1.0
 */
public class Employee {
    private Integer empId;
    private String empName;
    private Integer deptId;
    private Integer roleId;
    private Integer managerId;
    private Integer gender;
    private  String phone;
    private String password;
    private String email;
    private Date hireTime;
    private Department department;

    private Role role;

    private Employee employee;


    public Employee() {
    }

    public Employee(Integer empId, String empName, Integer deptId, Integer roleId, Integer managerId, Integer gender, String phone, String password, String email, Date hireTime, Department department, Role role, Employee employee) {
        this.empId = empId;
        this.empName = empName;
        this.deptId = deptId;
        this.roleId = roleId;
        this.managerId = managerId;
        this.gender = gender;
        this.phone = phone;
        this.password = password;
        this.email = email;
        this.hireTime = hireTime;
        this.department = department;
        this.role = role;
        this.employee = employee;
    }

    /**
     * 获取
     * @return empId
     */
    public Integer getEmpId() {
        return empId;
    }

    /**
     * 设置
     * @param empId
     */
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    /**
     * 获取
     * @return empName
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * 设置
     * @param empName
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     * 获取
     * @return deptId
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * 设置
     * @param deptId
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     * 获取
     * @return roleId
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 设置
     * @param roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取
     * @return managerId
     */
    public Integer getManagerId() {
        return managerId;
    }

    /**
     * 设置
     * @param managerId
     */
    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    /**
     * 获取
     * @return gender
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取
     * @return hireTime
     */
    public Date getHireTime() {
        return hireTime;
    }

    /**
     * 设置
     * @param hireTime
     */
    public void setHireTime(Date hireTime) {
        this.hireTime = hireTime;
    }

    /**
     * 获取
     * @return department
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * 设置
     * @param department
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * 获取
     * @return role
     */
    public Role getRole() {
        return role;
    }

    /**
     * 设置
     * @param role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * 获取
     * @return employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * 设置
     * @param employee
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String toString() {
        return "Employee{empId = " + empId + ", empName = " + empName + ", deptId = " + deptId + ", roleId = " + roleId + ", managerId = " + managerId + ", gender = " + gender + ", phone = " + phone + ", password = " + password + ", email = " + email + ", hireTime = " + hireTime + ", department = " + department + ", role = " + role + ", employee = " + employee + "}";
    }
}
