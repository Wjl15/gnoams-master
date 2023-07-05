package niit.wei.service;

import niit.wei.dto.Page;
import niit.wei.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();
    Department getDepartmentById(Integer deptId);
    void addDepartment(Department department);
    void updateDepartment(Department department);
    void deleteDepartment(Integer deptId);
    Page getDepartmentPage(Integer pageNo, Integer pageSize);
}
