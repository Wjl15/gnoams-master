package niit.wei.service.impl;

import niit.wei.entity.Employee;
import niit.wei.service.EmployeeService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EmployeeServiceImplTest {
    private EmployeeService employeeService = new EmployeeServiceImpl();

    @Test
    public void getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        System.out.println(employees);
    }

    @Test
    public void getEmployeeById() {
        Employee employee = employeeService.getEmployeeById(10000);
        System.out.println(employee);
    }

    @Test
    public void addEmployee() {
    }

    @Test
    public void updateEmployee() {
    }

    @Test
    public void deleteEmployee() {
    }

    @Test
    public void getEmployeePage() {
    }
    @Test
    public void getManagers() {
        List<Employee> managers = employeeService.getAllManagers();
        System.out.println(managers);
    }
}