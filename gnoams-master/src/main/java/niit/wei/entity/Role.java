package niit.wei.entity;

/**
 * @Author WeiJinLong
 * @Date 2023-07-03 11:30
 * @Version 1.0
 */
public class Role {
    private Integer roleId;
    private String roleName;
    private Integer status;

    public Role() {
    }

    public Role(Integer roleId, String roleName, Integer status) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.status = status;
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
     * @return roleName
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置
     * @param roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    public String toString() {
        return "Role{roleId = " + roleId + ", roleName = " + roleName + ", status = " + status + "}";
    }
}
