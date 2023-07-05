package niit.wei.entity;

/**
 * @Author WeiJinLong
 * @Date 2023-07-04 9:52
 * @Version 1.0
 */
public class Education {
    private Integer educationId;
    private String educationName;

    public Education() {
    }

    public Education(Integer educationId, String educationName) {
        this.educationId = educationId;
        this.educationName = educationName;
    }

    /**
     * 获取
     * @return educationId
     */
    public Integer getEducationId() {
        return educationId;
    }

    /**
     * 设置
     * @param educationId
     */
    public void setEducationId(Integer educationId) {
        this.educationId = educationId;
    }

    /**
     * 获取
     * @return educationName
     */
    public String getEducationName() {
        return educationName;
    }

    /**
     * 设置
     * @param educationName
     */
    public void setEducationName(String educationName) {
        this.educationName = educationName;
    }

    public String toString() {
        return "Education{educationId = " + educationId + ", educationName = " + educationName + "}";
    }
}
