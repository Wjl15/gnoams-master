package niit.wei.service.impl;

import niit.wei.entity.Department;
import niit.wei.service.DepartmentService;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class DepartmentServiceImplTest {
    private DepartmentService departmentService = new DepartmentServiceImpl();
    @Test
    public void getAllDepartments() {
        List<Department> allDepartments = departmentService.getAllDepartments();
        System.out.println(allDepartments);
    }

    @Test
    public void getDepartmentById() {
        Department department = departmentService.getDepartmentById(10000);
        System.out.println(department);
    }

    @Test
    public void addDepartment() {
    }

    @Test
    public void updateDepartment() {
        Department department = new Department();
        department.setDeptId(10000);
        department.setDeptName("财务部");
        Date date = new Date();

//        java.sql.Date date1 = new java.sql.Date(date.getTime());
        department.setCreateTime(date);
        departmentService.updateDepartment(department);
    }

    @Test
    public void deleteDepartment() {
    }

    @Test
    public void getDepartmentPage() {
    }
}