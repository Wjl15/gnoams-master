package niit.wei.service;

import niit.wei.dto.Page;
import niit.wei.entity.Role;

import java.util.List;

public interface RoleService {
    void addRole(Role role);

    void updateRole(Role role);

    void deleteRole(Integer roleId);

    Role getRoleByRoleId(Integer roleId);

    List<Role> getAllRoles();

    Page getRolePage(Integer pageNo, Integer pageSize);
}
