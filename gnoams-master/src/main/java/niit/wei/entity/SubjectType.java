package niit.wei.entity;

import java.util.List;

/**
 * @Author WeiJinLong
 * @Date 2023-07-03 14:41
 * @Version 1.0
 */
public class SubjectType {
    private Integer subjectTypeId;
    private String subjectTypeName;
    List<Subject> subjects;

    public SubjectType() {
    }

    public SubjectType(Integer subjectTypeId, String subjectTypeName, List<Subject> subjects) {
        this.subjectTypeId = subjectTypeId;
        this.subjectTypeName = subjectTypeName;
        this.subjects = subjects;
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
     * @return subjectTypeName
     */
    public String getSubjectTypeName() {
        return subjectTypeName;
    }

    /**
     * 设置
     * @param subjectTypeName
     */
    public void setSubjectTypeName(String subjectTypeName) {
        this.subjectTypeName = subjectTypeName;
    }

    /**
     * 获取
     * @return subjects
     */
    public List<Subject> getSubjects() {
        return subjects;
    }

    /**
     * 设置
     * @param subjects
     */
    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public String toString() {
        return "SubjectType{subjectTypeId = " + subjectTypeId + ", subjectTypeName = " + subjectTypeName + ", subjects = " + subjects + "}";
    }
}
