<%--
  Created by IntelliJ IDEA.
  User: 15415
  Date: 2023/7/3
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>光年OA管理系统</title>
    <link rel="icon" href="imgs/favicon.ico" type="image/ico">
    <meta name="keywords" content="ukoko.cn">
    <meta name="description" content="解决中小企业...">
    <meta name="author" content="夜泊">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/materialdesignicons.min.css" rel="stylesheet">
    <link href="css/style.min.css" rel="stylesheet">
</head>

<body>
<div class="lyear-layout-web">
    <div class="lyear-layout-container">
        <!--左侧导航-->
        <jsp:include page="menu.jsp"></jsp:include>
        <!--End 左侧导航-->

        <!--头部信息-->
        <jsp:include page="head.jsp"></jsp:include>
        <!--End 头部信息-->

        <!--页面主要内容-->
        <main class="lyear-layout-content">

            <div class="container-fluid">

                <!-- 内容区 -->
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-header text-center">
                            更新学生
                        </div>
                        <div class="card-body">
                            <form class="form-horizontal" action="StudentUpdateServlet" method="post">
                                <input type="hidden" value="${student.studentId}" name="studentId" />
                                <input type="hidden" value="19800" name="tuition" />
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="gn_name">姓名</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="text" id="gn_name" placeholder="学员姓名" name="studentName" value="${student.studentName}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="gn_class">班级</label>
                                    <div class="col-md-7">
                                        <select style="padding: 10px 0;" class="form-control" id="gn_class" size="1" name="classId">
                                            <c:forEach items="${ClassList}" var="class1">
                                                <option <c:if test="${class1.classId eq student.classId}">selected</c:if> value="${class1.classId}">${class1.className}</option>
                                            </c:forEach>
<%--                                            <option value="-1">请选择</option>--%>
<%--                                            <option value="1">JavaEE 1901</option>--%>
<%--                                            <option value="2">H5 1901</option>--%>
<%--                                            <option value="3">Python 1901</option>--%>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">性别</label>
                                    <div class="col-md-7">
                                        <label class="radio-inline" for="man">
                                            <input type="radio" <c:if test="${student.gender == 1}">checked</c:if> ="checked" id="man"  name="gender" value="1">
                                            男
                                        </label>
                                        <label class="radio-inline" for="woman">
                                            <input type="radio" <c:if test="${student.gender == 0}">checked</c:if> name="gender" id="woman" value="0">
                                            女
                                        </label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="phone">手机</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="text" id="phone" placeholder="手机号" name="phone" value="${student.phone}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="idcard">身份证</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="text" id="idcard" placeholder="身份证" name="idCard" value="${student.idCard}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="graduate_school">毕业学校</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="text" id="graduate_school" placeholder="毕业学校" name="graduateSchool" value="${student.graduateSchool}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="education">学历</label>
                                    <div class="col-md-7">
                                        <select style="padding: 10px 0;" class="form-control" id="education" size="1" name="educationId">
                                            <c:forEach items="${educationList}" var="education">
                                                <option <c:if test="${education.educationId eq student.educationId}">selected</c:if> value="${education.educationId}">${education.educationName}</option>
                                            </c:forEach>
<%--                                            <option value="-1">请选择</option>--%>
<%--                                            <option value="0">小学</option>--%>
<%--                                            <option value="1">初中</option>--%>
<%--                                            <option value="2">高中</option>--%>
<%--                                            <option value="3">专科</option>--%>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="example-hf-hire">入学日期</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="date" id="example-hf-hire" name="admissionTime" value="${student.admissionTime}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="example-manager">招生老师</label>
                                    <div class="col-md-7">
                                        <select style="padding: 10px 0;" class="form-control" id="example-manager" size="1" name="empId">
                                            <c:forEach items="${EmployeeList}" var="employee">
                                                <option <c:if test="${student.empId eq employee.empId}">selected</c:if>  value="${employee.empId}">${employee.empName}</option>
                                            </c:forEach>
<%--                                            <option value="0">请选择</option>--%>
<%--                                            <option value="1">张三</option>--%>
<%--                                            <option value="2">李四</option>--%>
<%--                                            <option value="3">王五</option>--%>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-9 col-md-offset-3">
                                        <button class="btn btn-primary" type="submit">添加学生</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </main>
        <!--End 页面主要内容-->
    </div>
</div>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="js/main.min.js"></script>
</body>
</html>
