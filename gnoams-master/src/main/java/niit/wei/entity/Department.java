package niit.wei.entity;

import java.util.Date;

/**
 * @Author WeiJinLong
 * @Date 2023-07-03 17:22
 * @Version 1.0
 */
public class Department {
    private Integer deptId;
    private String deptName;
    private Date createTime;

    public Department() {
    }

    public Department(Integer deptId, String deptName, Date createTime) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.createTime = createTime;
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
     * @return deptName
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 设置
     * @param deptName
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * 获取
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String toString() {
        return "Department{deptId = " + deptId + ", deptName = " + deptName + ", createTime = " + createTime + "}";
    }
}
