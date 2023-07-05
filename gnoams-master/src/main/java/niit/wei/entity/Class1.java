package niit.wei.entity;

import java.util.Date;

/**
 * @Author WeiJinLong
 * @Date 2023-07-03 19:02
 * @Version 1.0
 */
public class Class1 {
    private Integer classId;
    private String className;
    private Integer subjectId;
    private Integer classCount;
    private Integer classLife;
    private String classAddress;
    private Date createTime;
    private Subject subject;

    public Class1() {
    }

    public Class1(Integer classId, String className, Integer subjectId, Integer classCount, Integer classLife, String classAddress, Date createTime, Subject subject) {
        this.classId = classId;
        this.className = className;
        this.subjectId = subjectId;
        this.classCount = classCount;
        this.classLife = classLife;
        this.classAddress = classAddress;
        this.createTime = createTime;
        this.subject = subject;
    }

    /**
     * 获取
     * @return classId
     */
    public Integer getClassId() {
        return classId;
    }

    /**
     * 设置
     * @param classId
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    /**
     * 获取
     * @return className
     */
    public String getClassName() {
        return className;
    }

    /**
     * 设置
     * @param className
     */
    public void setClassName(String className) {
        this.className = className;
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
     * @return classCount
     */
    public Integer getClassCount() {
        return classCount;
    }

    /**
     * 设置
     * @param classCount
     */
    public void setClassCount(Integer classCount) {
        this.classCount = classCount;
    }

    /**
     * 获取
     * @return classLife
     */
    public Integer getClassLife() {
        return classLife;
    }

    /**
     * 设置
     * @param classLife
     */
    public void setClassLife(Integer classLife) {
        this.classLife = classLife;
    }

    /**
     * 获取
     * @return classAddress
     */
    public String getClassAddress() {
        return classAddress;
    }

    /**
     * 设置
     * @param classAddress
     */
    public void setClassAddress(String classAddress) {
        this.classAddress = classAddress;
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
     * @return subject
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * 设置
     * @param subject
     */
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String toString() {
        return "Class{classId = " + classId + ", className = " + className + ", subjectId = " + subjectId + ", classCount = " + classCount + ", classLife = " + classLife + ", classAddress = " + classAddress + ", createTime = " + createTime + ", subject = " + subject + "}";
    }
}
