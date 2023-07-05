package niit.wei.entity;

import java.util.Date;

/**
 * @Author WeiJinLong
 * @Date 2023-07-04 9:53
 * @Version 1.0
 */
public class Student {
    private Integer studentId;
    private String studentName;
    private Integer classId;
    private Integer empId;
    private String gender;
    private String phone;
    private String idCard;
    private  String graduateSchool;
    private Integer educationId;
    private Double tuition;
    private Date admissionTime;
    private Class1 class1;
    private Employee employee;
    private Education education;

    public Student() {
    }

    public Student(Integer studentId, String studentName, Integer classId, Integer empId, String gender, String phone, String idCard, String graduateSchool, Integer educationId, Double tuition, Date admissionTime, Class1 class1, Employee employee, Education education) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.classId = classId;
        this.empId = empId;
        this.gender = gender;
        this.phone = phone;
        this.idCard = idCard;
        this.graduateSchool = graduateSchool;
        this.educationId = educationId;
        this.tuition = tuition;
        this.admissionTime = admissionTime;
        this.class1 = class1;
        this.employee = employee;
        this.education = education;
    }

    /**
     * 获取
     * @return studentId
     */
    public Integer getStudentId() {
        return studentId;
    }

    /**
     * 设置
     * @param studentId
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    /**
     * 获取
     * @return studentName
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * 设置
     * @param studentName
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
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
     * @return empId
     */
    public Integer getEmpId() {
        return empId;
    }

    /**
     * 设置
     * @param empId
     */
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    /**
     * 获取
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取
     * @return idCard
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 设置
     * @param idCard
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * 获取
     * @return graduateSchool
     */
    public String getGraduateSchool() {
        return graduateSchool;
    }

    /**
     * 设置
     * @param graduateSchool
     */
    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
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
     * @return tuition
     */
    public Double getTuition() {
        return tuition;
    }

    /**
     * 设置
     * @param tuition
     */
    public void setTuition(Double tuition) {
        this.tuition = tuition;
    }

    /**
     * 获取
     * @return admissionTime
     */
    public Date getAdmissionTime() {
        return admissionTime;
    }

    /**
     * 设置
     * @param admissionTime
     */
    public void setAdmissionTime(Date admissionTime) {
        this.admissionTime = admissionTime;
    }

    /**
     * 获取
     * @return class1
     */
    public Class1 getClass1() {
        return class1;
    }

    /**
     * 设置
     * @param class1
     */
    public void setClass1(Class1 class1) {
        this.class1 = class1;
    }

    /**
     * 获取
     * @return employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * 设置
     * @param employee
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * 获取
     * @return education
     */
    public Education getEducation() {
        return education;
    }

    /**
     * 设置
     * @param education
     */
    public void setEducation(Education education) {
        this.education = education;
    }

    public String toString() {
        return "Student{studentId = " + studentId + ", studentName = " + studentName + ", classId = " + classId + ", empId = " + empId + ", gender = " + gender + ", phone = " + phone + ", idCard = " + idCard + ", graduateSchool = " + graduateSchool + ", educationId = " + educationId + ", tuition = " + tuition + ", admissionTime = " + admissionTime + ", class1 = " + class1 + ", employee = " + employee + ", education = " + education + "}";
    }
}
