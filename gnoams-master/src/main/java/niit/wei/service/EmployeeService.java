package niit.wei.service;

import niit.wei.dto.Page;
import niit.wei.entity.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    List<Employee> getAllManagers();

    Employee getEmployeeById(Integer employeeId);
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(Integer employeeId);
    Page getEmployeePage(Integer pageNo, Integer pageSize);

    Employee login(String phone,String password);

    void updateEmployee(String empName,String userName);

    Employee getEmployeeByName(String empName);

    void updateEmployeePwd(String newPwd,Integer empId);

}
