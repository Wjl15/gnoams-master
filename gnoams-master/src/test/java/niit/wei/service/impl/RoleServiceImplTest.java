package niit.wei.service.impl;

import niit.wei.dto.Page;
import niit.wei.entity.Role;
import niit.wei.service.RoleService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RoleServiceImplTest {
    private RoleService roleService = new RoleServiceImpl();

    @Test
    public void addRole() {
        Role role = new Role();
        role.setRoleName("副总监");
        role.setStatus(0);
        roleService.addRole(role);
    }

    @Test
    public void updateRole() {
        Role role = new Role();
        role.setRoleId(10003);
        role.setRoleName("副总监");
        role.setStatus(1);
        roleService.updateRole(role);
    }

    @Test
    public void deleteRole() {
        roleService.deleteRole(10003);
    }

    @Test
    public void getRoleByRoleId() {
        Role roleByRoleId = roleService.getRoleByRoleId(10002);
        System.out.println(roleByRoleId);
    }

    @Test
    public void getAllRoles() {
        List<Role> allRoles = roleService.getAllRoles();
        System.out.println(allRoles);

    }

    @Test
    public void getRolePage() {
        Page rolePage = roleService.getRolePage(1, 2);
        System.out.println(rolePage);
    }
}