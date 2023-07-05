package niit.wei.entity;

import java.util.Date;

/**
 * @Author WeiJinLong
 * @Date 2023-07-03 14:39
 * @Version 1.0
 */
public class Subject {
    private Integer subjectId;
    private String subjectName;
    private Integer subjectLife;
    private Date createTime;
    private Integer subjectTypeId;
    private SubjectType subjectType;

    public Subject() {
    }

    public Subject(Integer subjectId, String subjectName, Integer subjectLife, Date createTime, Integer subjectTypeId, SubjectType subjectType) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.subjectLife = subjectLife;
        this.createTime = createTime;
        this.subjectTypeId = subjectTypeId;
        this.subjectType = subjectType;
    }

    /**
     * 获取
     * @return subjectId
     */
    public Integer getSubjectId() {
        return subjectId;
    }

    /**
     * 设置
     * @param subjectId
     */
    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * 获取
     * @return subjectName
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * 设置
     * @param subjectName
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     * 获取
     * @return subjectLife
     */
    public Integer getSubjectLife() {
        return subjectLife;
    }

    /**
     * 设置
     * @param subjectLife
     */
    public void setSubjectLife(Integer subjectLife) {
        this.subjectLife = subjectLife;
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

    /**
     * 获取
     * @return subjectTypeId
     */
    public Integer getSubjectTypeId() {
        return subjectTypeId;
    }

    /**
     * 设置
     * @param subjectTypeId
     */
    public void setSubjectTypeId(Integer subjectTypeId) {
        this.subjectTypeId = subjectTypeId;
    }

    /**
     * 获取
     * @return subjectType
     */
    public SubjectType getSubjectType() {
        return subjectType;
    }

    /**
     * 设置
     * @param subjectType
     */
    public void setSubjectType(SubjectType subjectType) {
        this.subjectType = subjectType;
    }

    public String toString() {
        return "Subject{subjectId = " + subjectId + ", subjectName = " + subjectName + ", subjectLife = " + subjectLife + ", createTime = " + createTime + ", subjectTypeId = " + subjectTypeId + ", subjectType = " + subjectType + "}";
    }
}
